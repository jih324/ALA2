/***
 * Class that contains the extension of the Exception class
 * @author Daniel Han
 * @version 1.60.0
 * Date of creation: September 9, 2021
 * Last Date Modified: September 13, 2021
 */

package ALA2;

public class InvalidSeatException extends Exception {
    /***
     * Default constructor
     * No parameters
     * Calls the superclass Exception to initialize the exception
     */
    public InvalidSeatException() {
        super();
    }
    /***
     * Default constructor
     * @param       message that is displayed once the exception occurs
     * Calls the superclass with the message passed in as the parameter
     */
    public InvalidSeatException(String message) {
        super(message);
    }
}
