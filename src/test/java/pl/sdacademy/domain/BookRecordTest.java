//package pl.sdacademy.domain;
//
//import org.junit.Test;
//import pl.sdacademy.communication.Response;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//
//import static org.junit.Assert.*;
//
//public class BookRecordTest {
//
//    @Test
//    public void shouldAddNewBook() throws FileNotFoundException {
//        File BookList = new File("BookList.txt");
//        EBook book = new EBook("Biografia", "Mateusz", "Cokolwiek", 1);
//
//        Response result = new BookRecord().addBook(book);
//
//        assertEquals(true, result.isSuccess());
//        assertEquals("Udało się dodać książkę "+ book.title + "; " + book.author, result.getMessage());
//    }
//
//    @Test
//    public void shouldReadCategory() {
//        File bookList = new File("BookList.txt");
//        EBook book = new EBook("Biografia", "Marcin", "Cośtam", 1);
//        Category category = new Category("Biografia", 1);
//
////        Response result = new BookRecord().categoryReader(category);
//    }
//}