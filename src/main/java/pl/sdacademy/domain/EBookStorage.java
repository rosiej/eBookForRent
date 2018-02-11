package pl.sdacademy.domain;

public interface EBookStorage {
    Category getMainCategory();

    void printTree(Category category);

    Category choseSubcategory(Category category, int id);

    void uploadBookList();

    void categoryTree();
}
