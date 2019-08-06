/*
 * MIT License
 *
 * Copyright (c) 2019 xubin zhao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fyan.cmd_sys;

import fyan.base.CommandBase;

//      -h | -help
public class Help implements CommandBase {

    public int resInfo(String[] args) {
        System.out.print( "\t -a | --append [pre|suf] <constName> 修改文件前缀或后缀\n" +
                "\t \n" +
                "\t -c | --create [total] <constName> [进值+步长+位数] <asc|desc> 创建及命名文件夹\n" +
                "\t \n" +
                "\t -c | --create -l [dictionaryName...] 创建文件夹以常量的方式\n" +
                "\t \n" +
                "\t -r | --replace [regex] [replacement] 正则修改文件名\n" +
                "\t \n" +
                "\t -s | --substr <beginIndex> [endIndex] 截取文件名\n" +
                "\n" +
                "\t -f | --finger <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> 以指定算法计算文件摘要\n" +
                "\n" +
                "\t -f | --finger -c|--compared <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> <fingerPrint> 对比摘要，文件防篡改\n" +
                "\n" +
                "\t -d | --download <url> [文件名] url链接下载文件\n" +
                "\n" +
                "\t -h | --help 命令帮助\n" +
                "\n" +
                "\t -v | --version 版本");
        return 0;
    }
}
