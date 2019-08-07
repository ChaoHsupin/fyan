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

package fyan;

import fyan.base.CmdBase;
import fyan.base.CmdFactory;
import fyan.cmd_sys.Version;

public class FyanApplication {


    //用户执行命令的路径
    public static String LOCAL_PATH;

    //命令中的正则表达式
    public static String REGEX;

    public static void main(String... args) {

        handle(filterCommand(args));
    }


    //提取命令中的路径和正则信息
    private static String[] filterCommand(String... args) {

        LOCAL_PATH = args[0] + "\\";
        String[] command;
        if (args.length >= 2 && "grep".equals(args[args.length - 2])) {
            REGEX = args[args.length - 1];
            command = new String[args.length - 3];
        } else
            command = new String[args.length - 1];

        for (int i = 0; i < command.length; i++)
            command[i] = args[i + 1];
        return command;

    }

    public static void handle(String... args) {

        try {
            CmdBase cmd;

            //命令判误
            if (args.length == 0)
                cmd = new Version();
            else cmd = CmdFactory.builder(args[0]);

            //执行命令
            int resCode = cmd.resInfo(args);

        } catch (Exception e) {
            System.out.print("\t命令或参数错误, -help 查看命令详细");
        } finally {
            System.exit(0);
        }
    }
}
