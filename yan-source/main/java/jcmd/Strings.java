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

package jcmd;

import java.util.List;

public class Strings {

    public static boolean isStringEmpty(String s) {
        return s == null || "".equals(s);
    }

    public static boolean startsWith(String s, String with, boolean isCaseSensitive) {
        if (isCaseSensitive)
            return s.startsWith(with);
        else {
            return s.toLowerCase().startsWith(with.toLowerCase());
        }
    }

    public static String join(String delimiter, List<String> args) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < args.size(); i++) {
            builder.append(args.get(i));

            if (i + 1 < args.size())
                builder.append(delimiter);
        }
        return builder.toString();
    }

    public static String join(String delimiter, Object[] args) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]);

            if (i + 1 < args.length)
                builder.append(delimiter);
        }
        return builder.toString();
    }
}
