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

import fyan.base.CommandBase;
import fyan.cmd_down.Down;
import fyan.cmd_file.Append;
import fyan.cmd_file.Create;
import fyan.cmd_file.Replace;
import fyan.cmd_file.Substr;
import fyan.cmd_secr.Fingerprint;
import fyan.cmd_sys.Help;
import fyan.cmd_sys.Version;


//工厂模式创建命令执行对象
public class CommandFactory {

    public static CommandBase builder(String cmdPre) {

        CommandBase cmd = null;

        //注册指令
        switch (cmdPre) {
            case "-h":
            case "--help":
                cmd = new Help();
                break;
            case "-c":
            case "-create":
                cmd = new Create();
                break;
            case "-s":
            case "-substr":
                cmd = new Substr();
                break;
            case "-r":
            case "--replace":
                cmd = new Replace();
                break;
            case "-a":
            case "--append":
                cmd = new Append();
                break;
            case "-f":
            case "--finger":
                cmd = new Fingerprint();
                break;
            case "-d":
            case "--down":
                cmd = new Down();
                break;
            case "-v":
            case "--version":
                cmd = new Version();
                break;
        }
        return cmd;
    }
}
