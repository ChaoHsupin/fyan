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

import jcmd.internal.Maps;

import java.util.Map;

/**
 * Helper class to perform fuzzy key look ups: looking up case insensitive or
 * abbreviated keys.
 */
public class FuzzyMap {
  interface IKey {
    String getName();
  }

  public static <V> V findInMap(Map<? extends IKey, V> map, IKey name,
      boolean caseSensitive, boolean allowAbbreviations) {
    if (allowAbbreviations) {
      return findAbbreviatedValue(map, name, caseSensitive);
    } else {
      if (caseSensitive) {
        return map.get(name);
      } else {
        for (IKey c : map.keySet()) {
          if (c.getName().equalsIgnoreCase(name.getName())) {
            return map.get(c);
          }
        }
      }
    }
    return null;
  }

  private static <V> V findAbbreviatedValue(Map<? extends IKey, V> map, IKey name,
      boolean caseSensitive) {
    String string = name.getName();
    Map<String, V> results = Maps.newHashMap();
    for (IKey c : map.keySet()) {
      String n = c.getName();
      boolean match = (caseSensitive && n.startsWith(string))
          || ((! caseSensitive) && n.toLowerCase().startsWith(string.toLowerCase()));
      if (match) {
        results.put(n, map.get(c));
      }
    }

    V result;
    if (results.size() > 1) {
      throw new ParameterException("Ambiguous option: " + name
          + " matches " + results.keySet());
    } else if (results.size() == 1) {
      result = results.values().iterator().next();
    } else {
      result = null;
    }

    return result;
  }


}
