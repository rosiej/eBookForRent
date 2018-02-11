package pl.sdacademy.domain;

import pl.sdacademy.communication.Response;

public class BookController {

    private final BookStorage bookStorage;

    public BookController (BookStorage bookStorage){

        this.bookStorage = bookStorage;
    }

    public Response addBook(String title, String author, String isbn) {
        if (bookStorage.checkExistBook(isbn)){
            return Response.isNotSuccessful("Book already exist");
        }

        bookStorage.add(title, author);
        return Response.isSuccessful();
    }

    public Response getInformationAbout(String isbn) {

        if (bookStorage.checkExistBook(isbn)){
            EBook eBook = bookStorage.searchBy(isbn);

            Response successful = Response.isSuccessful();
            successful.setMessage(eBook.asJson());
        return successful;
        }
        return Response.isSuccessful();
    }
}
