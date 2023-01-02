package ru.jankbyte.vacancyparser.parser;

import java.util.List;

import ru.jankbyte.vacancyparser.Vacancy;

public interface Parser {
    public List<Vacancy> getVacancies();
}
