<div align="center">
<H1>fyan 命令行工具</H1>
  <img alt="GitHub release" src="https://img.shields.io/badge/java-%3E%3D1.8-red">
  <img alt="GitHub release" src="https://img.shields.io/github/release/BegoniaGit/fyan">
<img alt="GitHub All Releases" src="https://img.shields.io/github/downloads/BegoniaGit/fyan/total">
<a href="https://github.com/BegoniaGit/fyan/blob/master/LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/BegoniaGit/fyan"></a>
</div>

## 简述
- 常用的文件名批处理小工具,今天才写了一点,还有很多不足。
- 源码已传到GitHub,大家都可指出代码缺陷,发表issue,提交自己的代码。


## 运行环境
- Windows or Linux
- Java runtime environment (jre) version 1.8 及以上

## 安装
1. 先在GitHub上下载发行版包
2. 解压文件,将解压后文件bin路径配置到用户环境变量中
3. 在任意目录下运行CMD窗口,输入yan或yan -v,出现以下提示信息表示环境配置正确
```cmd
C:\yan -v
Welcome to the folder processing tool from yanyan.site
Version 1.1.0
Java version must be greater than 1.8

```
## 运行机制
以Windows为例，配置好环境变量后，在任意路径CMD窗口中输入：yan -v，系统会在环境变量中找到yan.bat文件并执行。在yan.bat
文件中主要是一句运行jar文件的命令，在CMD窗口下跟随的参数会被转入java执行文件的参数列表里，如此便运行起了一个jar文件，
java文件顺理成章的收到了用户的参数信息，于是在java代码中通过逻辑控制等一系列操作完成对整条命令的执行。

##命令解读

#### 文件夹处理
```cmd
 命令尾部都可加上 grep [regex]做正则筛选

 -a | --append [pre|suf] <constName> 修改文件前缀或后缀
 
 -c | --create [total] <constName> [进值+步长+位数] <a/d> 创建及命名文件夹
 
 -c | --create -l [dictionaryName...] 创建文件夹以常量的方式
 
 -r | --replace [regex] [replacement] 正则修改文件名
 
 -s | --Substr <beginIndex> [endIndex] 截取文件名
```


#### 摘要算法
```cmd
 -f | --finger <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> 以指定算法计算文件摘要

 -f | --finger -c|--compared <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> <fingerPrint> 对比摘要，文件防篡改
```

#### 下载文件
```cmd
 -d | --download <url> [文件名] url链接下载文件
```

#### 其它
```cmd
 -h | --help 命令帮助

 -v | --version 版本
```



