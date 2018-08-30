package by.chmut.catalog.bean;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories {

    @XmlElement(name = "CATEGORY_NAME")
    private String categoryName;

    @XmlElement(name = "SUBCATEGORY")
    private List<News> news;

    public Categories(String categoryName, List<News> news) {
        this.categoryName = categoryName;
        this.news = news;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public void add(News freshNews) {
        news.add(freshNews);
    }
}
