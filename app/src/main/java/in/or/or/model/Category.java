package in.or.or.model;

import java.util.ArrayList;

public class Category {
    private String id;
    private String title;
    private String banner;
    private ArrayList<Category> subcategories;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBanner() {
        return banner;
    }

    public ArrayList<Category> getSubcategories() {
        return subcategories;
    }
} 