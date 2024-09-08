/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.yami.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yami.shop.common.util.FilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.yami.shop.bean.model.AttachFile;
import com.yami.shop.common.bean.Qiniu;
import com.yami.shop.common.util.Json;
import com.yami.shop.dao.AttachFileMapper;
import com.yami.shop.service.AttachFileService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * Created by  on 2024/07/27.
 */
@Service
public class AttachFileServiceImpl extends ServiceImpl<AttachFileMapper, AttachFile> implements AttachFileService {

    @Autowired
    private AttachFileMapper attachFileMapper;

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;
	@Autowired
	private Qiniu qiniu;

    @Autowired
    private Auth auth;

    public final static String NORM_MONTH_PATTERN = "yyyy/MM/";

	@Value("${server.port}")
	private String port;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public String uploadFile(byte[] bytes,String originalName) throws QiniuException {
		String extName = FileUtil.extName(originalName);
		String fileName =DateUtil.format(new Date(), NORM_MONTH_PATTERN)+ IdUtil.simpleUUID() + "." + extName;


		AttachFile attachFile = new AttachFile();
		attachFile.setFilePath(fileName);
		attachFile.setFileSize(bytes.length);
		attachFile.setFileType(extName);
		attachFile.setUploadTime(new Date());
		attachFileMapper.insert(attachFile);

		String upToken = auth.uploadToken(qiniu.getBucket(),fileName);
	    Response response = uploadManager.put(bytes, fileName, upToken);
	    Json.parseObject(response.bodyString(),  DefaultPutRet.class);
		return fileName;
	}

	@Override
	public void deleteFile(String fileName){
		attachFileMapper.delete(new LambdaQueryWrapper<AttachFile>().eq(AttachFile::getFilePath,fileName));
		try {
			bucketManager.delete(qiniu.getBucket(), fileName);
		} catch (QiniuException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String upload(MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();  // 获取源文件的名称
		// 定义文件的唯一标识（前缀）
		String flag = UUID.randomUUID().toString().replace("-", "");
		//String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;  // 获取上传的路径
		// 获取文件的后缀名
		String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
		String rootFilePath = FilePathUtil.filePath() + flag + suffixName;
		File saveFile = new File(rootFilePath);
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		jodd.io.FileUtil.writeBytes(rootFilePath, file.getBytes());  // 把文件写入到上传的路径
		//return "http://localhost:"+port+"/file/"+flag + suffixName;
		return "file/"+flag + suffixName;
	}


}
