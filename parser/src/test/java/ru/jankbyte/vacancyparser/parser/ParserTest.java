package ru.jankbyte.vacancyparser.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

import ru.jankbyte.vacancyparser.parser.site.*;

import ru.jankbyte.vacancyparser.parser.exception.ParserNotFoundException;

public class ParserTest {
    @Test
    public void testParserHeadHunter() throws Exception {
        var parser = ParserFactory.getParser(
            "https://hh.ru/search/vacancy?search_field=name&search_field=company_name&search_field=description&text=java&from=suggest_post&page=1&hhtmFrom=vacancy_search_list");
        int size = parser.getVacancies().size();
        System.out.println("Найдено вакансий: " + size);
        parser.getVacancies().forEach(System.out::println);
        //
        //Assertions.assertEquals(50, size);
    }
}
