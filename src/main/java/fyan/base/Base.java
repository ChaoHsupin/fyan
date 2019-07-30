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

package fyan.base;

import fyan.base.CommandBase;
import fyan.cmd_sys.Version;

import java.util.HashMap;
import java.util.Map;

public class Base {

    public static Map<String, Class> primList = new HashMap<String, Class>();

    public static void handle(String[] args) {

        System.out.println(args.length);
        try {
            Class filterClass;
            if (args.length == 0)
                filterClass = Version.class;
            else filterClass = primList.get(args[0]);
            CommandBase filterBase = (CommandBase) filterClass.newInstance();
            int resCode = filterBase.resInfo(args);
            System.out.print("\n"+(resCode == 0 ? "success" : (resCode == -1 ? "fault" : "warning")));
        } catch (Exception e) {
            System.out.print("\t命令或参数错误, -help 查看命令详细");
        } finally {
            System.exit(0);
        }
    }
}
