package ru.jankbyte.vacancyparser.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

import ru.jankbyte.vacancyparser.parser.site.*;

import ru.jankbyte.vacancyparser.parser.exception.ParserNotFoundException;

public class ParserFactoryTest {
    @Test
    public void testGettingHeadHunterParser() throws Exception {
        var url = "https://hh.ru/";
        var parser = ParserFactory.getParser(url);
        Assertions.assertTrue(parser instanceof HeadHunterParser);
    }

    @Test
    public void testGettingJobLabParser() throws Exception {
        var url = "https://joblab.ru";
        var parser = ParserFactory.getParser(url);
        Assertions.assertTrue(parser instanceof JobLabParser);
    }

    @Test
    public void testThrowingParserNotFoundException() {
        var exp = Assertions.assertThrows(
            ParserNotFoundException.class,
                () -> ParserFactory.getParser("http://not-exists-site.test"),
                    "Expected throw ParserNotFoundException, but it didn't");
    }
}
