package com.epam.string.logic.impl;

import com.epam.string.logic.TextProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTextProcessor implements TextProcessor {

    private final static String REGEX_PROCESS = "(^|[^a-zA-Z])+([a-zA-Z]+)";

    @Override
    public String process(String text, int lengthWord, String replacement) {

        Pattern pattern = Pattern.compile(REGEX_PROCESS);
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {

            StringBuffer buffer = new StringBuffer();
            String groupOne = matcher.group(1);
            String groupTwo = matcher.group(2);

            buffer.append(groupOne);

            if (groupTwo.length() == lengthWord) {
                buffer.append(replacement);
            } else {
                buffer.append(groupTwo);
            }

            matcher.appendReplacement(result, new String(buffer));

        }

        matcher.appendTail(result);

        return new String(result);
    }

}