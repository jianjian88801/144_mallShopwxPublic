---
### 👉作者QQ ：1556708905 微信：zheng0123Long (支持修改、部署调试、定制毕设)

### 👉接网站建设、小程序、H5、APP、各种系统等

### 👉选题+开题报告+任务书+程序定制+安装调试+ppt 都可以做
---

**博客地址：
[https://blog.csdn.net/2303_76227485/article/details/140045913](https://blog.csdn.net/2303_76227485/article/details/140045913)**

**视频演示：
[https://www.bilibili.com/video/BV1zn4y197BQ/](https://www.bilibili.com/video/BV1zn4y197BQ/)**

**毕业设计所有选题地址：
[https://github.com/ynwynw/allProject](https://github.com/ynwynw/allProject)**

## 基于Java+Springboot+Vue的商城小程序(源代码+数据库)144

## 一、系统介绍
本项目前后端分离，分为管理员、用户两种角色(可自行分配角色)

### 1、用户：
- 注册登录、商品浏览、商品关键字搜索、购物车、订单提交、商品收藏、分类搜索、收货地址管理、订单管理、轮播图、公告
### 2、管理员：
- 商品管理、分类管理、分组管理、规格管理、公告管理、自提点管理、运费模板管理、轮播图管理、热搜管理、会员管理、订单管理
- 地址管理、管理员管理、角色管理、菜单管理、定时任务、操作日志
## 二、所用技术

后端技术栈：

- Springboot
- MybatisPlus
- SpringSecurity
- Mysql
- Maven
- Redis

前端技术栈：

- Vue 
- Vue-router 
- axios 
- elementUi

## 三、环境介绍

基础环境:IDEA/eclipse, JDK1.8, Mysql5.7及以上, Maven3.6, node14, navicat, 微信开发者工具, 微信小程序账号

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、页面截图
### 1、用户
![contents](./picture/picture0.png)
![contents](./picture/picture00.png)
![contents](./picture/picture1.png)
![contents](./picture/picture2.png)
![contents](./picture/picture3.png)
![contents](./picture/picture4.png)
![contents](./picture/picture5.png)
![contents](./picture/picture6.png)
![contents](./picture/picture7.png)
![contents](./picture/picture8.png)
![contents](./picture/picture9.png)
![contents](./picture/picture10.png)
![contents](./picture/picture11.png)
![contents](./picture/picture12.png)
![contents](./picture/picture13.png)

### 2、管理员：
![contents](./picture/picture14.png)
![contents](./picture/picture15.png)
![contents](./picture/picture16.png)
![contents](./picture/picture17.png)
![contents](./picture/picture18.png)
![contents](./picture/picture19.png)
![contents](./picture/picture20.png)
![contents](./picture/picture21.png)
![contents](./picture/picture22.png)
![contents](./picture/picture23.png)
![contents](./picture/picture24.png)
![contents](./picture/picture25.png)
![contents](./picture/picture26.png)
![contents](./picture/picture27.png)
![contents](./picture/picture28.png)
![contents](./picture/picture29.png)
![contents](./picture/picture30.png)
![contents](./picture/picture31.png)
![contents](./picture/picture32.png)
![contents](./picture/picture33.png)
![contents](./picture/picture34.png)
![contents](./picture/picture35.png)

## 五、浏览地址

- 用户账号/密码：lisi/123456

后台登录页面: http://localhost:9528

- 管理员账号/密码：admin/123456

## 六、部署教程

1. 使用Navicat或者其它工具，在mysql中创建对应名称的数据库，并执行项目的sql

2. 使用IDEA/Eclipse导入gym项目，导入时，若为maven项目请选择maven; 等待依赖下载完成

3. 修改yami-shop-admin和yami-shop-api项目下application-dev.yml里面的数据库配置和redisson.yml里面的redis配置

4. 通过WebApplication启动项目后台接口，ApiApplication启动项目前台接口

5. vscode或idea打开vue项目

6. 在编译器中打开terminal，执行npm install 依赖下载完成后执行 npm run dev,执行成功后会显示后台管理访问地址

7. 微信开发者工具打开wechatapp项目,编译好之后就运行成功了

## 七、创新点
1、使用quartz定时任务实现系统自动确认收货订单功能
2、使用redis缓存频繁使用数据


