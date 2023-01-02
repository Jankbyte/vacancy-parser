package ru.jankbyte.vacancyparser.parser.site;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ru.jankbyte.vacancyparser.parser.SiteParser;
import ru.jankbyte.vacancyparser.Vacancy.Builder;
import ru.jankbyte.vacancyparser.Vacancy;

public final class JobLabParser extends SiteParser {
    public JobLabParser(String url) throws IOException {
        super(url);
    }

    @Override
    protected void parsePage(Document doc, List<Vacancy> vacancies) {
        var divs = doc.getElementsByClass("td-to-div");
        for (var element : divs) {
            var title = element.select(".prof a");
            var href = "https://joblab.ru" + title.attr("href");

            var vacancy = new Builder()
                .title(title.text())
                .url(href).build();
            vacancies.add(vacancy);
        }
    }

    private void setTitleAndHref(Element title, Builder builder) {
        var text = title.text();
        var url = title.attr("href");
        builder.url(url).title(text);
    }
}