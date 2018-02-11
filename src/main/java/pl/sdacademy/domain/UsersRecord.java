package pl.sdacademy.domain;

import java.io.*;
import java.util.Scanner;

public class UsersRecord {

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

}
