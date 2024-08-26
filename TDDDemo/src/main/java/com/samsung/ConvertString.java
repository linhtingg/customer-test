package com.samsung;

import java.util.regex.*;

/**
 * Hello world!
 *
 */
public class ConvertString
{
    public String removeBracketContent(String content)
    {
        //Refector su dung regex
        Pattern pattern = Pattern.compile("\\([\\s\\w]+\\)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        if(matcher.find())
        {
            content = content.replaceAll("\\([\\s\\w]+\\)", "");
            return removeBracketContent(content);
        }
        else
            return content.replaceAll("\\s+", " ") .trim();
    }

    public String removeContentInGroup(String content) {
        return content.replaceAll("\\s?(test)\\s?|\\s?(tst)\\s?|\\s?(st)\\s?|\\s?([app]+[application]+)\\s?", "");
    }
}
