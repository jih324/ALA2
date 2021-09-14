/***
 * Class that contains the main method
 * @author Daniel Han
 * @version 1.60.0
 * Date of creation: September 9, 2021
 * Last Date Modified: September 13, 2021
 */

package ALA2;

import java.util.Scanner;

public class SeatReservation {
    public static void main(String[] args){
        Airplane myAirplane = new Airplane("seatmap.txt");
        int operation = 0;
        Scanner keyboard = new Scanner(System.in);
        do{
            System.out.println(myAirplane.toString());
            printMenu();
            operation = keyboard.nextInt();
            String number;
            switch(operation){
                case 1:
                    System.out.println("Enter a seat number [1-9][A-H]: ");
                    number = keyboard.next();
                    try{
                        if (myAirplane.reserveSeat(number)){
                            System.out.println("Seat " + number + " reserved successfully.");
                        }
                        else{
                            System.out.println("Seat " + number + " already reserved.");
                        }
                    }
                    catch (InvalidSeatException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter a seat number [1-9][A-H]:");
                    number = keyboard.next();
                    try{
                        if(myAirplane.freeSeat(number)){
                            System.out.println("Seat " + number + " freed successfully.");
                        }
                        else{
                            System.out.println("Seat " + number + " already freed.");
                        }
                    }
                    catch (InvalidSeatException e){
                        System.out.println(e.getMessage());
                    }
                case 3:
                    System.out.println("Thank you for using my airplane seat reservation program.");
                    myAirplane.saveMap("seatmap.txt");
                    break;
                default: System.out.println("Invalid operation. Must be 1 to 3.");
            }
        } while(operation != 3);
    }
    /***
     * Method that prints the menu options
     * No parameters
     * No return value
     */
    public static void printMenu(){
        System.out.println("Please select an operation:\n1: Reserve a seat\n2: Free a seat\n3: Quit");
    }
}
