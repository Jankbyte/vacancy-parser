package ru.jankbyte.vacancyparser.parser;

import ru.jankbyte.vacancyparser.parser.site.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.IOException;

import ru.jankbyte.vacancyparser.parser.exception.ParserNotFoundException;

public final class ParserFactory {
    public static Parser getParser(String url)
            throws ParserNotFoundException, IOException {
        var siteName = getSiteNameFromURL(url);
        return switch (siteName) {
            case "hh.ru" -> new HeadHunterParser(url);
            case "joblab.ru" -> new JobLabParser(url);
            default -> throw new ParserNotFoundException(siteName);
        };
    }

    private static String getSiteNameFromURL(String url) {
        var matcher = Pattern.compile(
            "^(http|https){1}://(?<name>((\\w+).(\\w+)))")
                .matcher(url);
        if (matcher.find()) {
            return matcher.group("name");
        }
        throw new IllegalArgumentException("Строка не является ссылкой");
    }
}
