package by.chmut.catalog.bean.criteria;

public final class SearchCriteria {

    public static enum Category {
        CATEGORYNAME("categoryName");
        private String name;
        Category(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public static enum Subcategory {
        SUBCATEGORYNAME("subcategoryName");
        private String name;
        Subcategory(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public static enum News {
        NEWSNAME("nameNews"), PROVIDER("provider") ,DATE("date") , NEWS("body");
        private String name;
        News(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
