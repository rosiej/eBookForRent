package pl.sdacademy.domain;

import org.junit.Test;
import pl.sdacademy.communication.Response;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class BookRecordTest {

    @Test
    public void shouldAddNewBook() throws FileNotFoundException {
        File bookList = new File("BookList.txt");
        Book book = new Book("Biografia", "Mateusz", "Cokolwiek", 1);

        Response result = new BookRecord().addBook(book);

        assertEquals(true, result.isSuccess());
        assertEquals("Udało się dodać książkę "+ book.title + "; " + book.author, result.getMessage());
    }

    @Test
    public void shouldReadCategory() throws FileNotFoundException{
        File bookList = new File("BookList.txt");
        Book book = new Book("Biografia", "Marcin", "Cośtam", 1);
        Category category = new Category("Biografia", 1);

        Response result = new BookRecord().categoryReader(category);
    }
}