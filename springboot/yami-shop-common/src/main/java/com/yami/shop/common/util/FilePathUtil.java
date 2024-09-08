package com.yami.shop.common.util;

public final class FilePathUtil {
    public static final String PROJECT_FILE_URL = "\\upload\\";

    /**
     * 获取Windows下项目路径 + 项目中资源路径 = 文件总路径
     * @return
     */
    public static String filePath(){
        return System.getProperty("user.dir") +  PROJECT_FILE_URL;
    }

}
