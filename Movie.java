import java.util.*;
import java.io.*;

public class Movie {
    public static void main(String[] args){
        //Create ArrayList to store requests read from the file
        ArrayList<String> requests = new ArrayList<String>();
        //Create 2D array which stores the seating information
        String[][] seats = new String[10][20];
        //Fill all seats with "U" for unnoccupied
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                seats[i][j] = "U";
            }
        }
        //Open input file and store requests in ArrayList
        try{
            File file = new File("test.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                requests.add(line);
            }
            scan.close();
        } catch (FileNotFoundException e){
            System.out.println("Error. No file was found.");
        }
        //Split each request into its request number and 
        //number of requested seats and stores it into temp as an array
        String[] temp = new String[2];
        for(int i = 0; 0 < requests.size(); i++){
            temp = requests.get(i).split(" ");
        }
    }
}