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

public class BinaryConver {
    public static String transform(int num, int n) {

        int array[] = new int[100];
        int count = 0;
        int location = 0;

        while (num != 0) {//当输入的数不为0时循环执行求余和赋值
            int remainder = num % n;
            num = num / n;
            array[location] = remainder;//将结果加入到数组中去
            location++;
            count++;
        }
        return show(array, location - 1, count);
    }

    private static String show(int[] arr, int n, int count) {

        StringBuilder res = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            if (arr[i] < 0) {
                for (int j = 0; j < count - 1; j++) {
                    arr[j] = Math.abs(arr[j]);
                }
            }

            if (arr[i] > 9 || arr[i] < -9) {
                res.append((char) (arr[i] + 55));
            } else
                res.append(arr[i] + "");
        }
        return res.toString();
    }

    public static String transform(int num, int n, int bit) {

        String res = transform(num, n);

        System.out.println(res.length());
        int len=res.length();
        if (len > bit) return res;
        else for (int i = 0; i < bit - len; i++)
            res = "0" + res;
        return res;
    }
}
