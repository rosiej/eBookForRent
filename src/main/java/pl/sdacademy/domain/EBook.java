package pl.sdacademy.domain;

public class EBook {
    private final String title;
    private final String author;
    private final String isbn;

    public EBook(String title, String author, String isbn) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    public String asJson() {
        return
                "{" + "isbn: " + isbn +
                " title: " + title + ", " +    // to jest JSON (Google!) bedziemy tego kiedys bardzo duzo uzywac
                "author: " + author +
                "}";
    }
}
