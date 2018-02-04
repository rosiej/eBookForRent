package pl.sdacademy.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Category {

    private String name;
    private Category parent = null;
    private ArrayList <Category> children;
    private HashMap<String,String> books;

    public Category(String name) {
        this.name = name;
    }


    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void addChildCategory(Category category){
//        Category newSubcategory = new Category(name);
//        newSubcategory.setParent(this);
        this.children.add(category);
    }

}
