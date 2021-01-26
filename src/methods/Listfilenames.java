package methods;

import java.io.BufferedReader;      // do the imports
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import io.Inputhandler;
import io.Outputhandler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Listfilenames extends Outputhandler{
   

    
    public void GetFiles() {        //method to list filenames
       
        Outputhandler ou = new Outputhandler();

        String[] pathnames;

        try { 
            File f = new File("C:/codings/fileio/src/resources"); // import file
            pathnames = f.list();
 
            for (String pathname : pathnames) {  //list names
                  ou.printToConsole(pathname);
                  }   
                  
            } catch (Exception e) {
            ou.printToConsole(e.getMessage());
       }
    }

    public void GetFilesByType(String type) {   //method to list files by type

        Outputhandler ou = new Outputhandler();
        String[] pathnames;
        

        try { 
            File f = new File("C:/codings/fileio/src/resources");  //import file
            pathnames = f.list();
            
            for (String pathname : pathnames) {     //list filenames that match the query
                if (pathname.endsWith(type)){
                    ou.printToConsole(pathname);
                    }
                }   
                  
            } catch (Exception e) {
            ou.printToConsole(e.getMessage());
       }
    }

    public void query() {         // method that gets the info for logging purposes and also
                                  //does a word query
        Scanner sc = new Scanner(System.in);
        Inputhandler i = new Inputhandler();
        Outputhandler ou = new Outputhandler();
        String str;
        boolean bool = false;
        Long filesize;

        long timeElapsed, timeElapsed2, timeElapsed3;
        double time1 = 0.0;
        double time2 = 0.0;
        double time3 = 0.0;
        String formattedDate1 = "";
        String formattedDate2 = "";
        String formattedDate3 = "";
        String queryWord = "";
        int foundWords = 0;
              
        

            try { // get the filename

                LocalDateTime myDateObj = LocalDateTime.now();  //get the current date
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                formattedDate1 = myDateObj.format(myFormatObj);
                
                long startTime = System.nanoTime(); // get the precise time
                
                File f = new File("C:/codings/fileio/src/resources/Dracula.txt"); //import file
                str = f.getName();
                filesize = f.length();

                bool = f.exists();
                if (bool == true) {
                ou.printToConsole("The name of the file is " + str);
                ou.printToConsole("The filesize of the file is " + filesize.toString() + " bytes");
                }
                long endTime = System.nanoTime();   //end precise time
                timeElapsed = endTime - startTime;
                time1 = (double)timeElapsed/1000000; //calculate used time
                
                } catch (Exception e) {
                ou.printToConsole(e.getMessage());
           }

              

           try { // read lines in the file

            LocalDateTime myDateObj = LocalDateTime.now();  //get the current date
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            formattedDate2 = myDateObj.format(myFormatObj);

            long startTime = System.nanoTime(); // get the precise time
            int linecount = 0;
            BufferedReader reader = new BufferedReader(new FileReader("C:/codings/fileio/src/resources/Dracula.txt")); // read file
            while (reader.readLine() != null) linecount++; //read how many lines are there
            reader.close();

            long endTime = System.nanoTime();    //end precise time
            timeElapsed2 = endTime - startTime;
            time2 = (double)timeElapsed2/1000000; //calculate used time
            ou.printToConsole("The amount of lines in the file is " + linecount);
                             
            } catch (Exception e) {
            ou.printToConsole(e.getMessage());
       }
    
       
         try { // query word
                        
           ou.printToConsole("Give a query word");
           queryWord = i.getWord(sc);

           LocalDateTime myDateObj = LocalDateTime.now(); //get the current date
           DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
           formattedDate3 = myDateObj.format(myFormatObj);
                                 
           int wordcount = 0;
           BufferedReader reader = new BufferedReader(new FileReader("C:/codings/fileio/src/resources/Dracula.txt"));
           String line;

           long startTime = System.nanoTime(); // get the precise time
          
          while ((line = reader.readLine()) != null) {
              line.toLowerCase();
              if (line.contains(queryWord)) {
                wordcount++;
              }
          }

          foundWords = wordcount;
          long endTime = System.nanoTime();   //end precise time
          timeElapsed3 = endTime - startTime; //calculate used time
          time3 = (double)timeElapsed3/1000000;
          ou.printToConsole("the time used was " + String.valueOf(time3)+ "µs");

          if (wordcount == 0) { //check if the word was found
            ou.printToConsole("No requested word found!");
          }

          else {
            ou.printToConsole("Word was found " + wordcount + " times");
          }
          reader.close();
                                   
          } catch (Exception e) {
         ou.printToConsole(e.getMessage());
     }

     try {  //write info to the file
        FileWriter myWriter = new FileWriter("C:/codings/fileio/src/exports/logFile.txt"); //give a path
        myWriter.write(formattedDate1 + ": " + "The function to find filename took " + String.valueOf(time1) + "µs"); // write stuff
        myWriter.write("\n" + formattedDate2 + ": " + "The function to calculate lines took " + String.valueOf(time2) + "µs");
        myWriter.write("\n" + formattedDate3 + ": " + "The function to query word " + queryWord + " took " + String.valueOf(time3) + "µs");
        myWriter.write("\nand the word: " + "'" + queryWord + "'" + " was found" + foundWords + " times");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
  }
}
    
      
   

    

