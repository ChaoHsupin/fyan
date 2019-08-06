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

import java.util.EnumSet;
import java.util.List;

/**
 * A unix-style usage formatter. This works by overriding and modifying the output of
 * {@link #appendAllParametersDetails(StringBuilder, int, String, List)} which is inherited from
 * {@link DefaultUsageFormatter}.
 */
public class UnixStyleUsageFormatter extends DefaultUsageFormatter {

    public UnixStyleUsageFormatter(JCommander commander) {
        super(commander);
    }

    /**
     * Appends the details of all parameters in the given order to the argument string builder, indenting every
     * line with <tt>indentCount</tt>-many <tt>indent</tt>.
     *
     * @param out the builder to append to
     * @param indentCount the amount of indentation to apply
     * @param indent the indentation
     * @param sortedParameters the parameters to append to the builder
     */
    public void appendAllParametersDetails(StringBuilder out, int indentCount, String indent,
            List<ParameterDescription> sortedParameters) {
        if (sortedParameters.size() > 0) {
            out.append(indent).append("  Options:\n");
        }

        // Calculate prefix indent
        int prefixIndent = 0;

        for (ParameterDescription pd : sortedParameters) {
            WrappedParameter parameter = pd.getParameter();
            String prefix = (parameter.required() ? "* " : "  ") + pd.getNames();

            if (prefix.length() > prefixIndent) {
                prefixIndent = prefix.length();
            }
        }

        // Append parameters
        for (ParameterDescription pd : sortedParameters) {
            WrappedParameter parameter = pd.getParameter();

            String prefix = (parameter.required() ? "* " : "  ") + pd.getNames();
            out.append(indent)
                    .append("  ")
                    .append(prefix)
                    .append(s(prefixIndent - prefix.length()))
                    .append(" ");
            final int initialLinePrefixLength = indent.length() + prefixIndent + 3;

            // Generate description
            String description = pd.getDescription();
            Object def = pd.getDefault();

            if (pd.isDynamicParameter()) {
                String syntax = "(syntax: " + parameter.names()[0] + "key" + parameter.getAssignment() + "value)";
                description += (description.length() == 0 ? "" : " ") + syntax;
            }

            if (def != null && !pd.isHelp()) {
                String displayedDef = Strings.isStringEmpty(def.toString()) ? "<empty string>" : def.toString();
                String defaultText = "(default: " + (parameter.password() ? "********" : displayedDef) + ")";
                description += (description.length() == 0 ? "" : " ") + defaultText;
            }
            Class<?> type = pd.getParameterized().getType();

            if (type.isEnum()) {
                String valueList = EnumSet.allOf((Class<? extends Enum>) type).toString();

                // Prevent duplicate values list, since it is set as 'Options: [values]' if the description
                // of an enum field is empty in ParameterDescription#init(..)
                if (!description.contains("Options: " + valueList)) {
                    String possibleValues = "(values: " + valueList + ")";
                    description += (description.length() == 0 ? "" : " ") + possibleValues;
                }
            }

            // Append description
            // The magic value 3 is the number of spaces between the name of the option and its description
            // in DefaultUsageFormatter#appendCommands(..)
            wrapDescription(out, indentCount + prefixIndent - 3, initialLinePrefixLength, description);
            out.append("\n");
        }
    }
}
