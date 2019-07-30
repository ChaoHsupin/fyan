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
        System.out.print( "\t-h 或 -help \n" +
                "\t\t显示命令使用帮助\n" +
                "\n" +
                "\t| grep <正则表达式>\n" +
                "\t\t以下所有命令尾部都可加上此命令做正则筛选\n" +
                "\n" +
                "\t| limit <个数> \n" +
                "\t\t以下所有命令尾部都可加上此命令做指定个数选择\n" +
                "\n" +
                "\t-c or -create <文件夹个数> [命名规则](默认以数字从0开始) \n" +
                "\t\t批量创建文件夹。命名规则:{常量}[变量][进值][位数]\n" +
                "\n" +
                "\t-m or -modify [pre/suf] [命名规则](默认以数字从0开始) \n" +
                "\t\t批量修改文件名前缀或后缀。\n" +
                "\n" +
                "\t-s or -substring <beginIndex> [endIndex] \n" +
                "\t\t切割文件名，删掉指定文件名字符索引段。endIndex缺省文件名长度\n" +
                "\n" +
                "\t-r or -replace [regex] [replacement] \n" +
                "\t\t切割文件名，删掉指定文件名字符索引段。endIndex缺省文件名长度\n" +
                "\n" +
                "\t-lc or -lower [regex] [replacement] \n" +
                "\t\t文件名转小写\n" +
                "\t\t\n" +
                "\t-uc or -up [regex] [replacement] \n" +
                "\t\t文件名转大写");
        return 0;
    }
}
