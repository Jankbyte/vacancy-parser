package ru.jankbyte.vacancyparser.parser;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import ru.jankbyte.vacancyparser.Vacancy;

public abstract class SiteParser implements Parser {
    private Document doc;

    protected final List<Vacancy> vacancies = new ArrayList<>();

    public SiteParser(String url) throws IOException {
        doc = Jsoup.connect(url).get();
    }

    protected abstract void parsePage(Document page,
        List<Vacancy> vacancies);

    @Override
    public List<Vacancy> getVacancies() {
        parsePage(doc, vacancies);
        return vacancies;
    }
}
