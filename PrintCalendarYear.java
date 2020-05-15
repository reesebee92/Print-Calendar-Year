
/** PrintCalendarYear 
 * 
 * This class is an add on of the PrintCalendarMonth
 * 
 * The user is prompted to enter a year for which the
 * printCalendarYear is called to print the entire year
 * The printCalendarMonth method is called 12 times for each month
 * and voila a calendar is available!
 * 
 */

import java.util.Scanner;

public class PrintCalendarYear {

   public static void main(String[] args) {

      // Create a scanner and prompt the user to enter year
      Scanner input = new Scanner(System.in);

      System.out.println("Enter full year (e.g. 2012)");
      int year = input.nextInt();

      // call the printCalendarYear method to display full year calendar
      printCalendarYear(year);

   }// end main method

   /**
    * printCalendarYear
    * 
    * This method will return a full calendar year for the year provided
    * 
    * precondition: The year needs to be a full year postcondition: The calendar
    * needs to include the days for each month
    * 
    * @param year
    */
   public static void printCalendarYear(int year) {

      int monthLoop;
      for (monthLoop = 1; monthLoop <= 12; monthLoop++) {
         PrintCalendarMonth.printMonthCalendar(year, monthLoop);
         System.out.println("\n\n");
      } // end month loop

   }// end printCalendarYear method

}// end PrintCalendarYear class
