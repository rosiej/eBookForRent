package pl.sdacademy.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Category {

    private String name;
    private Category parent = null;



    public ArrayList<Category> getChildren() {
        return children;
    }

    private ArrayList <Category> children = new ArrayList<Category>();

    public int getId() {
        return id;
    }

    private int id;


    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void addChildCategory(Category category){
//        Category newSubcategory = new Category(name);
//        newSubcategory.setParent(this);
        this.children.add(category);
    }

    public String getName() {
        return name;
    }


    public Category getChild(int index) {
        return this.children.get(index);
    }

    public int size() {
        return this.children.size();
    }
}