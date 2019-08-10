
<H1>Fyan command line tool</H1>
<div >
 <img alt="GitHub release" src="https://img.shields.io/badge/java-%3E%3D1.8-red">&nbsp;
  <img alt="GitHub release" src="https://img.shields.io/github/release/BegoniaGit/fyan">&nbsp;
<img alt="GitHub All Releases" src="https://img.shields.io/github/downloads/BegoniaGit/fyan/total">&nbsp;
<a href="https://github.com/BegoniaGit/fyan/blob/master/LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/BegoniaGit/fyan"></a>
</div>

**language choice**
- [简体中文](#中文文档)

# English Document


## Brief
- The commonly used file name batching gadget has only been written a bit today, and there are still many shortcomings.
- The source code has been passed to GitHub. Everyone can point out code defects, post an issue, and submit their own code.


## Operating environment
- Windows or Linux
- Java runtime environment (jre) version 1.8 and above

## Installation
1. First download the distribution package on GitHub
2. Unzip the file and configure the unzipped file bin path into the user environment variable.
3. Run the CMD window in any directory and enter yan or yan -v. The following message appears indicating that the environment is configured correctly.
```cmd
C:\yan -v
Welcome to the folder processing tool from yanyan.site
Version 1.1.0
Java version must be greater than 1.8

```
## Operating mechanism
Take Windows as an example. After configuring the environment variable, enter yan -v in the CMD window of any path. The system will find the yan.bat file in the environment variable and execute it. In yan.bat
The file is mainly a command to run the jar file. The parameters that follow in the CMD window will be transferred to the parameter list of the java executable file, so that a jar file is run.
The java file logically receives the user's parameter information, so in the java code through a series of operations such as logic control to complete the execution of the entire command.

##Command Interpretation

#### Folder Processing
```cmd
	 Modify the end of the statement to add grep <regex> to do regular filtering
     
         Modify file prefix or suffix
         append <pre|suf> <constName>

         Create and name folders
         create <total> [constName] <input + step + digits> [asc|desc]

         Create a folder in a constant way
         create <-l|--list> <name...>

         Regularly modify the file name
         rplace <regex> <replacement>

         Intercept file name
         substr <beginIndex> [endIndex]

         Calculate the file summary with the specified algorithm
         finger <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName>

         Comparative summary, document tampering
         finger <-c|--compared> <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> <fingerPrint>

         Url link download file, can be renamed, recommended not renamed
         down <url> [fileName]

         Command help
         help

         lookup version
         version

```
# 中文文档
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
```cmd
	 修改语句尾部可添加 grep <regex> 做正则筛选
    
    修改文件前缀或后缀
    append <pre|suf> <constName>

    创建及命名文件夹
    create <total> [constName] <进值+步长+位数> [asc|desc]

    创建文件夹以常量的方式
    create <-l|--list> <name...>

    正则修改文件名
    replace <regex> <replacement>

    截取文件名
    substr <beginIndex> [endIndex]

    以指定算法计算文件摘要
    finger <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName>

    对比摘要，文件防篡改
    finger <-c|--compared> <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> <fingerPrint>

    url链接下载文件,可重命名,推荐不重命名
    down <url> [fileName]

    命令帮助
    help

    版本
    version
```



