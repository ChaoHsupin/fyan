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

/**
 * A formatter for help messages.
 */
public interface IUsageFormatter {

    /**
     * Display the usage for this command.
     */
    void usage(String commandName);

    /**
     * Store the help for the command in the passed string builder.
     */
    void usage(String commandName, StringBuilder out);

    /**
     * Store the help in the passed string builder.
     */
    void usage(StringBuilder out);

    /**
     * Store the help for the command in the passed string builder, indenting every line with "indent".
     */
    void usage(String commandName, StringBuilder out, String indent);

    /**
     * Stores the help in the passed string builder, with the argument indentation.
     */
    void usage(StringBuilder out, String indent);

    /**
     * @return the description of the argument command
     */
    String getCommandDescription(String commandName);
}
