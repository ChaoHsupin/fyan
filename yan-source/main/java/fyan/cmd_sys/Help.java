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

import fyan.base.CmdBase;

//      -h | -help
public class Help implements CmdBase {

    public int resInfo(String[] args) {
        System.out.print(
                "\t修改语句尾部可添加 grep <regex> 做正则筛选\n" +
                        "\n" +
                        "\t修改文件前缀或后缀\n" +
                        "\tappend <pre|suf> <constName>\n" +
                        "\n" +
                        "\t创建及命名文件夹\n" +
                        "\tcreate <total> [constName] <进值+步长+位数> [asc|desc]\n" +
                        "\n" +
                        "\t创建文件夹以常量的方式\n" +
                        "\tcreate <-l|--list> <name...>\n" +
                        "\n" +
                        "\t正则修改文件名\n" +
                        "\treplace <regex> <replacement>\n" +
                        "\n" +
                        "\t截取文件名\n" +
                        "\tsubstr <beginIndex> [endIndex]\n" +
                        "\n" +
                        "\t以指定算法计算文件摘要\n" +
                        "\tfinger <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName>\n" +
                        "\n" +
                        "\t对比摘要，文件防篡改\n" +
                        "\tfinger <-c|--compared> <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> <fingerPrint>\n" +
                        "\n" +
                        "\turl链接下载文件,可重命名,推荐不重命名\n" +
                        "\tdown <url> [fileName]\n" +
                        "\n" +
                        "\t命令帮助\n" +
                        "\thelp\n" +
                        "\n" +
                        "\t版本\n" +
                        "\tversion\n");
        return 0;
    }
}
