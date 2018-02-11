package pl.sdacademy.domain;

public interface BookStorage {

     void add(String title, String author);

     boolean checkExistBook(String isbn);

    EBook searchBy(String isbn);

}
