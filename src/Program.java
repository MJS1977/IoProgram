
import methods.*;  // do the imports
import java.util.Scanner;
import io.Inputhandler;
import io.Outputhandler;
public class Program {
    

    public static void main(String[] args) {

        Listfilenames lst = new Listfilenames();  //initiate classes
        Inputhandler i = new Inputhandler();
        Outputhandler o = new Outputhandler();

        int selection = 0;
        
        Scanner reader = new Scanner(System.in);
        

        do {

        System.out.println("Select one of the following:"); //Print menutext
        System.out.println("");
        System.out.println("1. List filenames");
        System.out.println("2. Get filenames by filetype");
        System.out.println("3. Get info from file and log");
        System.out.println("4. Exit");
        
        selection = i.getChoise(reader);    //get the selection from the user

        switch (selection) {  //menu

            case 1:
            lst.GetFiles();
            break;
            case 2:
            menu2();
            
            break;
            case 3:
            lst.query();

            break;
            case 4:

            default:

            break;


            }
        } while (selection != 4); //keep menu rotating until number 4 is pressed



    } 



    public static void menu2() {   //sub menu

        Listfilenames lst = new Listfilenames();
        Inputhandler i = new Inputhandler();
        Outputhandler o = new Outputhandler();

        String str1 = ".txt";  //initiate variables
        String str2 = ".jpeg";
        String str3 = ".jpg";
        String str4 = ".png";
        String str5 = ".jfif";

        int selection = 0;

        Scanner reader = new Scanner(System.in);

        do {

            System.out.println("Select one of the following:"); //Give options
            System.out.println("");
            System.out.println("1. .txt");
            System.out.println("2. .jpeg");
            System.out.println("3. .jpg");
            System.out.println("4. .png");
            System.out.println("5. .jfif");
            System.out.println("5. exit");
                
            //selection = reader.nextInt();
            selection = i.getChoise(reader);

    switch (selection) {        

        case 1:
        lst.GetFilesByType(str1); // Gets a corresponding variable and sends it to the method
        break;

        case 2:
        lst.GetFilesByType(str2);
        break;

        case 3:
        lst.GetFilesByType(str3);
        break;

        case 4:
        lst.GetFilesByType(str4);
        break;

        case 5:
        lst.GetFilesByType(str5);
        break;

        case 6:
        return;

        default:
        break;

        }
    } while (selection != 5);  //keep menu rotating until number 5 is pressed
}
}
    

