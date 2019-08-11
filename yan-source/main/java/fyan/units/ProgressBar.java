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

package fyan.units;

import java.util.Arrays;

public class ProgressBar {


    private int capacity = 100;
    private int barLength = 50;
    private String title = "PROCESSING：";
    private char mark = (char)62;

    private String percentage;
    private boolean start = false;
    private char[] line;
    private int scheduleLength = 0;
    private String str = "";


    public static ProgressBar builder() {
        return new ProgressBar();
    }

    public ProgressBar setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public ProgressBar setBarLength(int barLength) {
        this.barLength = barLength;
        return this;
    }

    public ProgressBar setTitle(String title) {
        this.title = title;
        return this;
    }

    public ProgressBar setMark(char mark) {
        this.mark = mark;
        return this;
    }

    public ProgressBar build() {
        line = new char[barLength];
        Arrays.fill(line, '-');
        System.out.print(title);
        return this;
    }


    public void update(int schedule) {

        StringBuilder cls = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
            cls.append('\b');

        int index = (int) (schedule * 100 / capacity);
        percentage ="  "+((index) < 10 ? (" " + index) : "" + index) + "%";

        int nowLength = schedule * barLength / capacity;

        for (int i = scheduleLength; i < nowLength; i++)
            line[i] = mark;

        scheduleLength = nowLength;

        str =  "[" + String.valueOf(line) + "]"+percentage;

        System.out.print(cls.toString());
        System.out.print(str);

        if(index==100)
            System.out.print("\nfinished!\n");
    }

}
