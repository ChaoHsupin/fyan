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

package jcmd.defaultprovider;

import jcmd.IDefaultProvider;
import jcmd.ParameterException;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * A default provider that reads its default values from a property file.
 * 
 * @author cbeust
 */
public class PropertyFileDefaultProvider implements IDefaultProvider {
  public static final String DEFAULT_FILE_NAME = "jcommander.properties";
  private Properties properties;

  public PropertyFileDefaultProvider() {
    init(DEFAULT_FILE_NAME);
  }

  public PropertyFileDefaultProvider(String fileName) {
    init(fileName);
  }

  private void init(String fileName) {
    try {
      properties = new Properties();
      URL url = ClassLoader.getSystemResource(fileName);
      if (url != null) {
        properties.load(url.openStream());
      } else {
        throw new ParameterException("Could not find property file: " + fileName
            + " on the class path");
      }
    }
    catch (IOException e) {
      throw new ParameterException("Could not open property file: " + fileName);
    }
  }
  
  public String getDefaultValueFor(String optionName) {
    int index = 0;
    while (index < optionName.length() && ! Character.isLetterOrDigit(optionName.charAt(index))) {
      index++;
    }
    String key = optionName.substring(index);
    return properties.getProperty(key);
  }

}
