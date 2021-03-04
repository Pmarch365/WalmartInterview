//Peter Marchese

import java.util.*;
import java.io.*;

public class Movie {
    public static void main(String[] args) throws IOException{
        //Create ArrayList to store requests read from the file
        ArrayList<String> requests = new ArrayList<String>();
        //Create 2D array which stores the seating information
        String[][] seats = new String[10][20];
        //Path of the output file
        String outputPath;
        //Fill all seats with "U" for unnoccupied
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                seats[i][j] = "U";
            }
        }
        //Open input file and store requests in ArrayList
        try{
            File readFile = new File("test.txt");
            Scanner scan = new Scanner(readFile);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                requests.add(line);
            }
            scan.close();
        } catch (FileNotFoundException e){
            System.out.println("Error. No file was found.");
        }
        //Write to output file
        int seatsRequested;
        try {
            FileWriter writeFile = new FileWriter("Seating.txt");
            //Parses through requests
            for(int i = 0; i < requests.size(); i++){
                //Writes request number to file
                writeFile.write(requests.get(i).split(" ")[0] + " ");
                //Variable to store number of seats per request
                seatsRequested = Integer.parseInt(requests.get(i).split(" ")[1]);
                //Traverses through all seats and determines which seats can be occupied
                for(int r = 0; r < seats.length; r++){
                    //This for loop checks if the seats available per row is >= seats requested
                    int seatsAvailable = 0;
                    for(int c = 0; c < seats[r].length; c++){
                        if(seats[r][c].equals("U")){
                            seatsAvailable++;
                        }
                    }
                    //If the row has less seats available than seats requested continue to next row
                    if(seatsRequested > seatsAvailable){
                        continue;
                    }
                    //Check if seat is avaible and add them in order in a row
                    for(int c = 0; c < seats[r].length; c++){
                        if(seats[r][c].equals("U") && seatsRequested > 0){
                            seats[r][c] = "O";
                            writeFile.write(String.valueOf((char)(r + 65)) + (c+1));
                            if(!(seatsRequested == 1)){
                                writeFile.write(",");
                            }
                            seatsRequested--;
                        }
                        //Adds 3 seat buffer after all seats have been filled
                        if( seatsRequested <= 0 ){
                            if( c + 1 < 20){
                                seats[r][c+1] = "O";
                            } 
                            if( c + 2 < 20){
                                seats[r][c+2] = "O";
                            }
                            if( c + 3 < 20){
                                seats[r][c+3] = "O";
                            }
                            break;
                        }
                    }
                    //If all seats have been filled move to next request
                    if(seatsRequested <= 0){
                        break;
                    } 
                }
                if(seatsRequested > 0){
                    writeFile.write("SEATS COULD NOT BE FILLED");
                }
                //Write newline to file unless it is last line
                if(!(i == requests.size()-1)){
                    writeFile.write("\n");
                }
            }
            writeFile.close();
        } catch (IOException e) {
            System.out.println("Could not write to file.");
        }
        //Prints all seats and their occupancy to the console
        // for(int i = 0; i < seats.length; i++){
        //     for(int j = 0; j < seats[i].length; j++){
        //         System.out.print(seats[i][j]);
        //     }
        //     System.out.println();
        // }
        File f = new File("Seating.txt");
        outputPath = f.getAbsolutePath();
        System.out.println(outputPath);
        return;
    }
}