package ru.jankbyte.vacancyparser.parser.exception;

public class ParserNotFoundException extends ParserException {
    public ParserNotFoundException(String siteName) {
        super("Парсер для сайта %s не найден"
            .formatted(siteName));
    }
}
