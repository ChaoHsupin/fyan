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

package jcmd.converters;

import jcmd.ParameterException;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Convert a string into a path.
 *
 * @author samvv
 */
public class PathConverter extends BaseConverter<Path> {

  public PathConverter(String optionName) {
    super(optionName);
  }

  public Path convert(String value) {
    try {
      return Paths.get(value);
    } catch (InvalidPathException e) {
      String encoded = escapeUnprintable(value);
      throw new ParameterException(getErrorString(encoded, "a path"));
    }
  }

  private static String escapeUnprintable(String value) {
    StringBuilder bldr = new StringBuilder();
    for (char c: value.toCharArray()) {
        if (c < ' ') {
            bldr.append("\\u").append(String.format("%04X", (int) c));
        } else {
            bldr.append(c);
        }
    }
    return bldr.toString();
  }
}
