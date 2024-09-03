package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Logger log = LogManager.getLogger(Main.class);//LOGGER CREATED

        log.info("This is an INFO log");
        String res="";

        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            int i=0;

            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
                res+=(char)i;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            log.error("Create your Source file");
        }

        FileOutputStream outputStream=null;

        try{
            byte[]arr=res.getBytes();
            outputStream = new FileOutputStream("./Output.txt");
            outputStream.write(arr);
//            while ((j = outputStream.write(arr)) != -1) {
//                System.out.print((char) j);
//                res+=j;
//            }


        }
        catch (FileNotFoundException e){
            log.error("error while creating output text file");
        }


        outputStream.close();
    }
}