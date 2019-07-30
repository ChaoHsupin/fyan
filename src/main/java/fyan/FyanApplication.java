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

import fyan.base.Base;
import fyan.cmd_secr.*;
import fyan.cmd_file.Append;
import fyan.cmd_file.Create;
import fyan.cmd_file.Replace;
import fyan.cmd_file.Substr;
import fyan.cmd_sys.Help;

import static fyan.base.Base.primList;

public class FyanApplication {

    static {
        primList.put("-h", Help.class);
        primList.put("--help", Help.class);
        primList.put("-c", Create.class);
        primList.put("-create", Create.class);
        primList.put("-s", Substr.class);
        primList.put("-substr", Substr.class);
        primList.put("-r", Replace.class);
        primList.put("--replace", Replace.class);
        primList.put("-a", Append.class);
        primList.put("-append", Append.class);
        primList.put("-f", Fingerprint.class);
        primList.put("--finger", Fingerprint.class);
    }

    public static String LOCAL_PATH;
    public static String REGEX;

    public static void main(String[] args) {

        for (String s : args)
            System.out.println(s);

        System.out.println(args.length);
        LOCAL_PATH = args[0] + "\\";
        String[] command;
        if (args.length>=2&&"grep".equals(args[args.length - 2])) {
            REGEX = args[args.length - 1];
            command = new String[args.length - 3];
        } else
            command = new String[args.length - 1];

        for (int i = 0; i < command.length; i++)
            command[i] = args[i + 1];
        Base.handle(command);
    }
}
