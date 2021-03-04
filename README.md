# Movie Theater Seating Challenge - 2020

## Peter Marchese

**Language: Java**  
**Version: 11.0.10**

**Description:**

This program was designed to take in requests for seating at a movie theater and to allocate seats for each customer.  
The program takes an input file as its argument and processes each request.  
Requests are in the form: "RXXX #"  
The Xs represent the request number which is the order in which it was received and the # represents the amount of seats requested.  
The program takes each request and attempts to provide the correct amount of seating to the customer, as well as accommodating for a three seat buffer between other requests.  

**Seating Algorithm**

The seating algorithm takes the number of seats requested and checks if each row can accommodate the requested amount of seats.  
    - This is done by checking if requested seats are less than or equal to the available seats per row.  
The algorithm then starts filling in each available seat until all requested seats are met.  
After finishing a request and placing the seats, the algorithm adds three buffer seats towards the right.  
    - This ensures that there are always three seats between different parties of customers.  
If there are no rows that can accomodate the request, the customer is notified that there is no seating available for a group of that size.  
The algorithm utilizes an ArrayList of Strings as well as a 2D array of Strings.  
The efficiency of the algorithm is 400 x n, where n is the number of requests.  

**Assumptions**

It is assumed that each request will have all members seated in the same row, as each party does not wish to be separated.  
It is assumed that each seat provides the same viewing experience so that each request can be placed for the most efficient distribution of seating.  
It is assumed that the input file will use the correct syntax and format.  

**How To Run**

To run this program, first compile the Movie.java file by typing "javac Movie.java" into the command line.  
To run this executable type into the command line: "java Movie [PATH_TO_INPUT]"  
Replace [PATH_TO_INPUT] with the path to the input file that will be used.  
Once run, the program will write a file named "Seating.txt" as well as return the path to this file.  
    - NOTE: This version of the program will rewrite the Seating.txt file if used consecutively. This issue will be resolved at a later date.