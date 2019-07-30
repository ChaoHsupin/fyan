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

package fyan.cmd_down;

import fyan.FyanApplication;
import fyan.base.CommandBase;
import fyan.units.DownUnits;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

//      -d | --download <url> [文件名]
public class Down implements CommandBase {

    @Override
    public int resInfo(String[] args) throws IOException, NoSuchAlgorithmException {

        String url = args[1];
        String fileName = url.substring(url.lastIndexOf('/'), url.length());

        fileName =args.length > 2?args[2]:fileName;

        DownUnits.downloadByNIO2(url, FyanApplication.LOCAL_PATH, fileName);

        return 0;
    }
}
