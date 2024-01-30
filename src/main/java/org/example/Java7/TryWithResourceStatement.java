package org.example.Java7;

import java.io.*;

public class TryWithResourceStatement  {

    public static void main(String[] args) throws Exception{
        beforeJava7();
        withJava7();
        withCustomResInJava7();
    }

//    Previously, try catch must have catch or finally block but after java 7, we can use try block without having
//    catch or finally blocks. We can do that by creating objectes of some classes or custom class which implements
//    AutoCloseable interface.

//    try(BufferedReader br =.....){
//        //work with br
//    }

//    try block execution completes the br.close() method will be automatically called by the JVM

//      BufferedReader extends Reader:-
//      Reads text from a character-input stream, buffering characters so as to provide for the efficient
//      reading of characters, arrays, and lines.

//      CustomResource is custom defined class


    public static void beforeJava7() throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("C:/eazybytes.txt"));
            String sCurrentLine;
            while((sCurrentLine = br.readLine()) != null){
                System.out.println(sCurrentLine);
            }

        } finally {
            br.close();
        }

    }

    public static void withJava7() throws FileNotFoundException, IOException {

        try(BufferedReader bufferedReader= new BufferedReader(new FileReader("eazybytes.txt"))){
        String sCurrentline;
            while((sCurrentline = bufferedReader.readLine()) != null){
                System.out.println(sCurrentline);
            }

        }
    }

    public static void withCustomResInJava7() throws Exception {
        try(CustomResource cr= new CustomResource();){
            cr.readFromResource();
        }

    }





}
