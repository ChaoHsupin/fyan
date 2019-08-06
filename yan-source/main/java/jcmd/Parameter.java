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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import jcmd.converters.CommaParameterSplitter;
import jcmd.converters.IParameterSplitter;
import jcmd.converters.NoConverter;
import jcmd.validators.NoValidator;
import jcmd.validators.NoValueValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
public @interface Parameter {

  /**
   * An array of allowed command line parameters (e.g. "-d", "--outputdir", etc...).
   * If this attribute is omitted, the field it's annotating will receive all the
   * unparsed options. There can only be at most one such annotation.
   */
  String[] names() default {};

  /**
   * A description of this option.
   */
  String description() default "";

  /**
   * Whether this option is required.
   */
  boolean required() default false;

  /**
   * The key used to find the string in the message bundle.
   */
  String descriptionKey() default "";

  /**
   * How many parameter values this parameter will consume. For example,
   * an arity of 2 will allow "-pair value1 value2".
   */
  public static int DEFAULT_ARITY = -1;
  int arity() default DEFAULT_ARITY;

  /**
   * If true, this parameter is a password and it will be prompted on the console
   * (if available).
   */
  boolean password() default false;

  /**
   * The string converter to use for this field. If the field is of type <tt>List</tt>
   * and not <tt>listConverter</tt> attribute was specified, JCommander will split
   * the input in individual values and convert each of them separately.
   */
  Class<? extends IStringConverter<?>> converter() default NoConverter.class;

  /**
   * The list string converter to use for this field. If it's specified, the
   * field has to be of type <tt>List</tt> and the converter needs to return
   * a List that's compatible with that type.
   */
  Class<? extends IStringConverter<?>> listConverter() default NoConverter.class;

  /**
   * If true, this parameter won't appear in the usage().
   */
  boolean hidden() default false;

  /**
   * Validate the parameter found on the command line.
   */
  Class<? extends IParameterValidator>[] validateWith() default NoValidator.class;

  /**
   * Validate the value for this parameter.
   */
  Class<? extends IValueValidator>[] validateValueWith() default NoValueValidator.class;

  /**
   * @return true if this parameter has a variable arity. See @{IVariableArity}
   */
  boolean variableArity() default false;

  /**
   * What splitter to use (applicable only on fields of type <tt>List</tt>). By default,
   * a comma separated splitter will be used.
   */
  Class<? extends IParameterSplitter> splitter() default CommaParameterSplitter.class;
  
  /**
   * If true, console will not echo typed input
   * Used in conjunction with password = true
   */
  boolean echoInput() default false;

  /**
   * If true, this parameter is for help. If such a parameter is specified,
   * required parameters are no longer checked for their presence.
   */
  boolean help() default false;
  
  /**
   * If true, this parameter can be overwritten through a file or another appearance of the parameter
   * @return nc
   */
  boolean forceNonOverwritable() default false;

  /**
   * If specified, this number will be used to order the description of this parameter when usage() is invoked.
   * @return
   */
  int order() default -1;
  
}
