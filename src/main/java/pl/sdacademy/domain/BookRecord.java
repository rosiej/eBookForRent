package pl.sdacademy.domain;

import pl.sdacademy.communication.Response;

import java.io.*;
import java.util.Scanner;

public class BookRecord {

    File bookList = new File("BookList.txt");

    public BookRecord() throws FileNotFoundException {


    }
    Response response = new Response();

    Scanner scanner = new Scanner(bookList);

    public Response addBook (Book book) throws FileNotFoundException {
        PrintWriter addingBook = new PrintWriter(new FileOutputStream(bookList, true));
        BufferedWriter bw = new BufferedWriter(addingBook);

        String record = book.id + "; " + book.author + "; " + book.title + "; " + book.content;

        try {
            bw.write(record + '\n');
            bw.close();
            response.setSuccess(true);
            response.setMessage("Udało się dodać książkę "+ book.title + "; " + book.author);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
//    public Response categoryReader (Category category) {
//        ArrayList<String> books = new ArrayList<String>();
//        while (scanner.hasNext()){
//            String [] book = scanner.nextLine().split("; ");
//            if (category.getId() == 1) {
//                if (Integer.parseInt(book [0])== 1 || Integer.parseInt(book[0])==11 || Integer.parseInt(book[0])== 12)
//                books.add("Autor: "+book[1]+ "Tytuł: "+ book[2]);
//                response.setSuccess(true);
//                response.setMessage(books.);
//            }
//        }
//        return response;
//    }
}
