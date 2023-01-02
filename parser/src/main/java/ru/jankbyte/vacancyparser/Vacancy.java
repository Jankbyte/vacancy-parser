package ru.jankbyte.vacancyparser;

import java.util.Objects;

public class Vacancy {
    private String companyName;
    private String title;
    private String url;

    protected Vacancy() {
    }

    protected void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    protected void setURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, companyName, url);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object instanceof Vacancy vacancy) {
            return Objects.equals(title, vacancy.title) &&
                    Objects.equals(companyName, vacancy.companyName) &&
                    Objects.equals(url, vacancy.url);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vacancy[title=%s, companyName=%s, url=%s]"
            .formatted(title, companyName, url);
    }

    public static class Builder {
        private String companyName, title, url;

        public Builder(String title) {
            this.title = title;
        }

        public Builder() {}

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Vacancy build() {
            var vacancy = new Vacancy();
            vacancy.setTitle(title);
            vacancy.setCompanyName(companyName);
            vacancy.setURL(url);
            return vacancy;
        }
    }
}