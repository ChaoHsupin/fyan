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

package fyan.cmd_file;

import fyan.FyanApplication;
import fyan.base.CmdBase;
import fyan.units.BinaryConver;
import fyan.units.ProgressBar;

import java.io.File;
import java.io.IOException;

//      -c | --create [total] <constName> [进值+步长+位数] <a/d>
//      -c | --create <-l|--list> [dictionaryName...]
public class Create implements CmdBase {
    public int resInfo(String[] args) throws IOException {


        return args[1].startsWith("-l") || args[1].startsWith("--list") ? createList(args) : create(args);
    }

    private int createList(String[] args) {

        ProgressBar progressBar = ProgressBar.builder()
                .setCapacity(args.length - 2)
                .build();

        for (int i = 2; i < args.length; i++) {
            File file = new File(FyanApplication.LOCAL_PATH + args[i]);
            file.mkdir();
            progressBar.update(i - 1);
        }
        return 0;
    }

    private int create(String[] args) {

        String sort = args[args.length - 1];
        int len = sort.matches("[(asc)|(desc)]") ? args.length - 1 : args.length;
        sort = sort.matches("[(asc)|(desc)]") ? sort : "asc";

        int fileTotal = Integer.valueOf(args[1]);

        String constName = "";
        if (len == 4)
            constName = args[2];
        //进制+步长+位数
        int[] namingRules = new int[3];
        int index = 0;
        for (String str : args[3].trim().split("\\+"))
            namingRules[index++] = Integer.valueOf(str);

        ProgressBar progressBar = ProgressBar.builder()
                .setCapacity(fileTotal)
                .build();

        for (int i = 0; i < fileTotal; i++) {
            String name = sort == "desc" ? BinaryConver.transform(i * namingRules[1], namingRules[0], namingRules[2]) + constName
                    : constName + BinaryConver.transform(i * namingRules[1], namingRules[0], namingRules[2]);
            File file = new File(FyanApplication.LOCAL_PATH + name);
            file.mkdir();
            progressBar.update(i+1);
        }

        return 0;
    }
}
