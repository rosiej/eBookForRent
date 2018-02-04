package pl.sdacademy.domain;

import java.io.*;
import java.util.Scanner;

public class UsersRecord {
    public File getUsersList() {
        return usersList;
    }

    File usersList = new File("UsersRecord.txt");

    public UsersRecord() throws FileNotFoundException {
    }

    Scanner scanner = new Scanner(usersList);



    public void addingRecord(User user) throws FileNotFoundException {

        PrintWriter addingToFile = new PrintWriter(new FileOutputStream(usersList, true));

        BufferedWriter bw = new BufferedWriter(addingToFile);

        String record = user.login + " ; " + user.password;

            try {
                bw.write(record + '\n');
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void readingRecord() {
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
