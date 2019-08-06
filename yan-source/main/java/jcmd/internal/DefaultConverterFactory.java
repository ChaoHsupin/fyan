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

package jcmd.internal;

import jcmd.IStringConverter;
import jcmd.IStringConverterFactory;
import jcmd.converters.BigDecimalConverter;
import jcmd.converters.BooleanConverter;
import jcmd.converters.DoubleConverter;
import jcmd.converters.FileConverter;
import jcmd.converters.FloatConverter;
import jcmd.converters.ISO8601DateConverter;
import jcmd.converters.IntegerConverter;
import jcmd.converters.LongConverter;
import jcmd.converters.StringConverter;
import jcmd.converters.PathConverter;
import jcmd.converters.URIConverter;
import jcmd.converters.URLConverter;

import java.io.File;
import java.lang.NoClassDefFoundError;
import java.math.BigDecimal;
import java.util.Date;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;

public class DefaultConverterFactory implements IStringConverterFactory {
  /**
   * A map of converters per class.
   */
  private static Map<Class, Class<? extends IStringConverter<?>>> classConverters;

  static {
    classConverters = Maps.newHashMap();
    classConverters.put(String.class, StringConverter.class);
    classConverters.put(Integer.class, IntegerConverter.class);
    classConverters.put(int.class, IntegerConverter.class);
    classConverters.put(Long.class, LongConverter.class);
    classConverters.put(long.class, LongConverter.class);
    classConverters.put(Float.class, FloatConverter.class);
    classConverters.put(float.class, FloatConverter.class);
    classConverters.put(Double.class, DoubleConverter.class);
    classConverters.put(double.class, DoubleConverter.class);
    classConverters.put(Boolean.class, BooleanConverter.class);
    classConverters.put(boolean.class, BooleanConverter.class);
    classConverters.put(File.class, FileConverter.class);
    classConverters.put(BigDecimal.class, BigDecimalConverter.class);
    classConverters.put(Date.class, ISO8601DateConverter.class);
    classConverters.put(URI.class, URIConverter.class);
    classConverters.put(URL.class, URLConverter.class);

    try {
      classConverters.put(Path.class, PathConverter.class);
    } catch (NoClassDefFoundError ex) {
      // skip if class is not present (e.g. on Android)
    }
  }

  public Class<? extends IStringConverter<?>> getConverter(Class forType) {
    return classConverters.get(forType);
  }

}
