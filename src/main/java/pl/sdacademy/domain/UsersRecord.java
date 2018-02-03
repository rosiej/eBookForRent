package pl.sdacademy.domain;

import java.io.*;

public class UsersRecord {
    public void addingRecord (User user) throws FileNotFoundException{
        PrintWriter addingToFile = new PrintWriter(new FileOutputStream(new File("UsersRecord.txt"), true));
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
