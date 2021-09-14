/***
 * Class that contains the functions to create and revise a map that represents seating in an airplane
 * @author Daniel Han
 * @version 1.60.0
 * Date of creation: September 9, 2021
 * Last Date Modified: September 13, 2021
 */

package ALA2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Airplane {
    //Data member
    private char[][] seatMap;
    /***
     * Method that calls the constructor from the Airplane class
     * No parameters
     * Creates and initializies the array seatMap
     */
    public Airplane(){
        seatMap = new char[9][8];
        for(int i=0; i<seatMap.length; i++){
            for(int j=0; j<seatMap[i].length; j++){
                seatMap[i][j] = '.';
            }
        }
    }
    /***
     * Method that calls the constructor from the Airplane class
     * @param       filename to name the file
     * Creates the array seatMap and stores it in a file
     */
    public Airplane(String filename){
        seatMap = new char[9][8];
        File file = new File(filename);
        readMap(filename);
    }
    /***
     * Method that reads the elements of an array stored in the file
     * @param       filename to name the file
     * no return value
     */
    private void readMap(String filename){
        File file = new File(filename);
        try{
            Scanner readFile = new Scanner(file);
            for(int i=0; i<seatMap.length; i++){
                for (int j=0; j<seatMap[i].length; j++){
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            for(int i=0; i<seatMap.length; i++){
                for(int j=0; j<seatMap[i].length; j++){
                    seatMap[i][j] = '.';
                }
            }
        }
    }
    /***
     * Method that compares the input with the elements in the array stored in a file
     * @param       seat to define the seat number the user is interested
     * @return      boolean value
     */
    private boolean checkSeat(String seat) throws InvalidSeatException{
        if(seat.matches("[1-9][A-H]")){
            return true;
        }
        else{
            throw new InvalidSeatException("Invalid seat number. Must be [1-9][A-H]");
        }
    }
    /***
     * Method that marks the seat the user wants to reserve in the map
     * @param       seat to define the seat number the user wants to reserve
     * @return      boolean value
     */
    public boolean reserveSeat(String seat) throws InvalidSeatException{
        if(checkSeat(seat)){
            int row = seat.charAt(0) - '1';
            int col = seat.charAt(1) - 'A';
            if(seatMap[row][col] == '.'){
                seatMap[row][col] = 'X';
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    /***
     * Method that deletes the mark of the seat the user once reserved
     * @param       seat to define the seat number the user wants to reserve
     * @return      boolean value
     */
    public boolean freeSeat(String seat) throws InvalidSeatException{
        if(checkSeat(seat)){
            int row = seat.charAt(0) - '1';
            int col = seat.charAt(1) - 'A';
            if(seatMap[row][col] == 'X'){
                seatMap[row][col] = '.';
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    /***
     * Method that saves the map to a file
     * @param       filename to name the file
     * no return value
     */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i=0; i<seatMap.length; i++){
                for(int j=0; j<seatMap[i].length; j++){
                    writeFile.print(seatMap[i][j] + " ");
                }
                writeFile.println();
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to " + filename);
        }

    }
    /***
     * Method that prints the map
     * @param       no parameters
     * @return      formatted string that draws the map
     */
    public String toString(){
        String output = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for (int i=0; i<seatMap.length; i++){
            output += (i+1) + "\t";
            for(int j=0; j<seatMap[i].length; j++){
                output += seatMap[i][j] + "\t";
            }
            output += "\n";
        }
        return output;
    }
    


}
