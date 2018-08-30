package by.chmut.catalog.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.*;

@Data
@NoArgsConstructor
@XmlRootElement(name = "CATALOG")
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

    @XmlElement(name = "CATEGORY")
    private List<Categories> categories;

    public Catalog(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public Set<News> getAllNews() {
        Set<News> news = new HashSet<>();
        for (Categories categories: categories) {
            news.addAll(categories.getNews());
        }
        return news;
    }

}
