package ru.jankbyte.vacancyparser.parser.site;

import java.io.IOException;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import ru.jankbyte.vacancyparser.parser.SiteParser;

import ru.jankbyte.vacancyparser.Vacancy.Builder;
import ru.jankbyte.vacancyparser.Vacancy;

import java.util.List;

public final class HeadHunterParser extends SiteParser {
    public HeadHunterParser(String url) throws IOException {
        super(url);
    }

    @Override
    protected void parsePage(Document doc, List<Vacancy> vacancies) {
        var divs = doc.getElementsByClass("vacancy-serp-item__layout");
        for (var div : divs) {
            var link = div.getElementsByClass("serp-item__title");
            var href = link.attr("href");
            var text = link.text();

            var company = div.getElementsByAttributeValue(
                "data-qa", "vacancy-serp__vacancy-employer").get(0).text();

            var vacancy = new Builder().title(text).url(href)
                .companyName(company).build();

            vacancies.add(vacancy);
        }
    }

    private void setTitleAndHref(Element title, Builder builder) {
        var text = title.text();
        var url = title.attr("href");
        builder.url(url).title(text);
    }
}