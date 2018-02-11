package pl.sdacademy.BookController;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.EBook;
import pl.sdacademy.domain.BookController;
import pl.sdacademy.domain.BookStorage;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BookControllerTest {
    @Test
    public void shouldAddBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = "Kamasutra";
        String author = "Vatsyayana";
        String isbn = "13:69:07";
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.addBook(title, author, isbn);

        assertTrue(response.isSuccess());
        verify(bookStorage).add(title, author);
    }

    @Test
    public void shouldNotAddTheSameBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = "Kamasutra";
        String author = "Vatsyayana";
        String isbn = "13:69:07";
        BookController bookController = new BookController(bookStorage);
        given(bookStorage.checkExistBook(isbn)).willReturn(true);

        Response response = bookController.addBook(title, author, isbn);

        assertFalse(response.isSuccess());
        verify(bookStorage, never()).add(title, author);  // never oznacza, że ta metoda nigdy się nie wydaży
    }
    @Test
    public void shouldReturnInformationAboutExistingBook (){
        String title = "Kamasutra";
        String author = "Vatsyayana";
        String isbn = "13:69:07";
        BookStorage bookStorage = mock(BookStorage.class);
        given(bookStorage.checkExistBook(isbn)).willReturn(true);
        given(bookStorage.searchBy(isbn)).willReturn(new EBook(title,author,isbn));
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.getInformationAbout(isbn);

        assertTrue(response.isSuccess());
        assertEquals(anExpectedInformation(isbn, author, title), response.getMessage());
    }
    private String anExpectedInformation(String isbn, String author, String title) {

       return "{" + "isbn: " + isbn +
               " title: " + title + ", " +    // to jest JSON (Google!) bedziemy tego kiedys bardzo duzo uzywac
                "author: " + author +
                "}";
    }
}
