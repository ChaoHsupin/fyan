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

package fyan.cmd_secr;


import fyan.FyanApplication;
import fyan.base.CommandBase;

import java.io.*;
import java.security.MessageDigest;

//      -f | --finger <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName>
//      -f | --finger -c|--compared <MD5|SHA-1|SHA-256|SHA-384|SHA-512> <fileName> <fingerPrint>
public class Fingerprint implements CommandBase {
    public int resInfo(String[] args) throws IOException {

        return (args[1].equals("-c") || args[1].startsWith("--c")) ? CompareFinger(args) : createFinger(args);

    }

    private static int CompareFinger(String[] args) {

        String Arith = args[2];
        String fileName = args[3];

        String countResult=count(Arith, fileName);
        String inputCount=args[4];

        System.out.print("\t校验"+(countResult.equals(inputCount)?"正确":"错误") );

        return 0;
    }

    private static int createFinger(String[] args) {
        String Arith = args[1];
        String fileName = args[2];

        System.out.print(count(Arith, fileName));
        return 0;
    }

    private static String count(String Arith, String fileName) {

        String[] ariths = {"MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"};
        boolean has = false;
        for (String arit : ariths)
            if (arit.equals(Arith)) {
                has = true;
                break;
            }
        if (!has) {
            System.out.print("\t指纹算法名称不正确，MD5|SHA-1|SHA-256|SHA-384|SHA-512");
            return null;
        }
        File file = new File(FyanApplication.LOCAL_PATH + fileName);
        if (!file.exists()) {
            System.out.print("\t文件 " + fileName + " 不存在");
            return null;
        }
        try {
            byte[] fileBytes = readFileToByteArray(file);
            MessageDigest messageDigest = MessageDigest.getInstance(Arith);
            messageDigest.update(fileBytes);
            System.out.print("指纹:  " + fileBytes.length);
            String result = byteArrayToHexString(messageDigest.digest());
            return result;
        } catch (Exception e) {
            System.out.print("\t计算失败");
            return null;
        }

    }

    private static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream in = null;

        byte[] var2;
        try {
            in = openInputStream(file);
            var2 = toByteArray(in);
        } finally {
            closeQuietly(in);
        }

        return var2;
    }

    private static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            } else {
                return new FileInputStream(file);
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }

    private static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy((InputStream) input, (OutputStream) output);
        return output.toByteArray();
    }

    private static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        return count > 2147483647L ? -1 : (int) count;
    }

    private static long copyLarge(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];
        long count = 0L;

        int n;
        for (boolean var5 = false; -1 != (n = input.read(buffer)); count += (long) n) {
            output.write(buffer, 0, n);
        }

        return count;
    }

    private static void closeQuietly(InputStream input) {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException var2) {
        }

    }

    private static String byteArrayToHexString(byte[] aData) {
        final char[] hexChars = "0123456789abcdef".toCharArray();
        // 一个字节用两个 16 进制字符表示
        StringBuilder stringBuilder = new StringBuilder(aData.length * 2);
        for (byte b : aData) {
            // 高 4 位转换为 16 进制
            stringBuilder.append(hexChars[(b >>> 4) & 0x0f]);
            // 低 4 位转换为 16 进制
            stringBuilder.append(hexChars[b & 0x0f]);
        }
        return stringBuilder.toString();
    }
}
