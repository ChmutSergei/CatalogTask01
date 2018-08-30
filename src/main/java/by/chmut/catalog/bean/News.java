package by.chmut.catalog.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class News {

    @XmlTransient
    private String categoryName;

    @XmlElement(name = "SUBCATEGORY_NAME")
    private String subcategoryName;

    @XmlElement(name = "NEWS_NAME")
    private String nameNews;

    @XmlElement(name = "PROVIDER_AUTHOR_AUTHORS")
    private String provider;

    @XmlElement(name = "DATE_OF_ISSUE")
    private String date;

    @XmlElement(name = "NEWS_BODY")
    private String body;

    public News(String categoryName, String subcategoryName, String nameNews, String provider, String date, String body) {
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.nameNews = nameNews;
        this.provider = provider;
        this.date = date;
        this.body = body;

    }

    public News(String subcategoryName, String nameNews, String provider, String date, String body) {
        this.subcategoryName = subcategoryName;
        this.nameNews = nameNews;
        this.provider = provider;
        this.date = date;
        this.body = body;

    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null ) {
            return false;
        }
        if (this.getClass() != object.getClass()){
            return false;
        }
        News news = (News) object;

        if (this.categoryName == null) {
            if (news.categoryName != null) {}
            return false;
        } else if (!this.categoryName.equals(news.categoryName)) {
            return false;
        }
        if (this.subcategoryName == null) {
            if (news.subcategoryName != null) {}
            return false;
        } else if (!this.subcategoryName.equals(news.subcategoryName)) {
            return false;
        }
        if (this.nameNews == null) {
            if (news.nameNews != null) {}
            return false;
        } else if (!this.nameNews.equals(news.nameNews)) {
            return false;
        }
        if (this.provider == null) {
            if (news.provider != null) {}
            return false;
        } else if (!this.provider.equals(news.provider)) {
            return false;
        }
        if (this.date == null) {
            if (news.date != null) {}
            return false;
        } else if (!this.date.equals(news.date)) {
            return false;
        }
        if (this.body == null) {
            if (news.body != null) {}
            return false;
        } else if (!this.body.equals(news.body)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result*37 + (categoryName == null ? 0 : categoryName.hashCode())*result;
        result = result*37 + (subcategoryName == null ? 0 : subcategoryName.hashCode())*result;
        result = result*37 + (nameNews == null ? 0 : nameNews.hashCode())*result;
        result = result*37 + (provider == null ? 0 : provider.hashCode())*result;
        result = result*37 + (date == null ? 0 : date.hashCode())*result;
        result = result*37 + (body == null ? 0 : body.hashCode())*result;
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "categoryName='" + categoryName + '\'' +
                ", subcategoryName='" + subcategoryName + '\'' +
                ", nameNews='" + nameNews + '\'' +
                ", provider='" + provider + '\'' +
                ", date='" + date + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
