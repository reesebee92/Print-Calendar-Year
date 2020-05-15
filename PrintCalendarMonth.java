/** PrintMonthCalendar
 * 
 * This class will print any given calendar for a specific month and year
 * A scanner input will be used to prompt the user for the year and month
 * 
 * Once a year and month is entered the following methods will be used to 
 * print the calendar:
 * printMonthCalendar, printMonthHeader, printMonthBody, getMonthName,
 * getStartDay, getNumDaysInMonth
 * 
 */

import java.util.Scanner;

public class PrintCalendarMonth {

   public static void main(String[] args) {
      
      //create a new scanner and prompt the user for year and month
      Scanner input = new Scanner(System.in);

      System.out.println("Enter full year (e.g. 2012): ");
      int year = input.nextInt();

      System.out.println("Enter month as a number between 1 and 12: ");
      int month = input.nextInt();

      //call the printMonthCalendar for inputed year and month
      printMonthCalendar(year, month);
   }//end main method

   /**printMonthCalendar
    * 
    * This method will print the calendar for the inputed month and year 
    * 
    * precondition: the year needs to be a full year (e.g. 2012), 
    * the month needs to be a number from 1 to 12, and the 
    * printMonthHeader and printMonthBody need to be correct
    * postcondition: The month calendar for the inputed year is displayed
    * 
    * @param year
    * @param month
    */
   public static void printMonthCalendar(int year, int month) {
      printMonthHeader(year, month);

      printMonthBody(year, month);
   }//end printMonthCalendar

   /**printMonthHeader
    * 
    * This method will print the header with the month and year
    * a line separator and days of the week below the line
    * 
    * precondition: the year needs to be a full year (e.g. 2012), 
    * and the month needs to be a number from 1 to 12
    * 
    * @param year
    * @param month
    */
   public static void printMonthHeader(int year, int month) {
      System.out.println("        " + getMonthName(month) + " " + year);
      System.out.println("----------------------------");
      System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
   }//end printMonthHeader method

   /** getMonthName
    * 
    * This method will return the actual month name given the numeric
    * value of the month
    * 
    * precondition: The month value needs to be a value from 1 to 12
    * postcondition: The month name is returned, based on the value
    * 
    * @param month
    * @return monthName
    */
   public static String getMonthName(int month) {
      String monthName = "";
      switch (month) {
         case 1:
            monthName = "January";
            break;
         case 2:
            monthName = "February";
            break;
         case 3:
            monthName = "March";
            break;
         case 4:
            monthName = "April";
            break;
         case 5:
            monthName = "May";
            break;
         case 6:
            monthName = "June";
            break;
         case 7:
            monthName = "July";
            break;
         case 8:
            monthName = "August";
            break;
         case 9:
            monthName = "September";
            break;
         case 10:
            monthName = "October";
            break;
         case 11:
            monthName = "November";
            break;
         case 12:
            monthName = "December";
            break;
      }
      return monthName;
   }

   /**printMonthBody
    * 
    * This method will return the calendar body for the month entered
    * 
    * precondition: the year needs to be a full year (e.g. 2012), 
    * the month needs to be a number from 1 to 12, and the number
    * of days from the method getNumbOfDays needs to be (28, 29, 30, or 31)
    * postcondtion: The calendar will be returned with the correct days
    * per line (7 day max per line)
    * 
    * @param year
    * @param month
    */
   public static void printMonthBody(int year, int month) {
      int startDay = getStartDay(month, year);

      int numberOfDaysInMonth = getNumOfDaysInMonth(year, month);

      int spaceCount, calendarLoop;
      if (startDay != 7) {
         for (spaceCount = startDay; spaceCount < 2 * startDay; spaceCount++) {
            System.out.print("    ");
         }
      }

      for (calendarLoop = 1; calendarLoop <= numberOfDaysInMonth; calendarLoop++) {
         System.out.printf("%4d", calendarLoop);

         if ((calendarLoop + startDay) % 7 == 0) {
            System.out.println();
         }
      }

   }//end PrintMonthBody method

   /**getStartDay
    * 
    * The method getStartDay() implements Zeller's Algorithm for determining the
    * day of the week the first day of a month is. The method adjusts Zeller's
    * numbering scheme for day of week ( 0=Saturday, ..., 6=Friday ) to conform
    * to day of week number that corresponds to ISO conventions (i.e.,
    * 1=Monday, ..., 7=Sunday)
    *
    * Pre-Conditions: The month value, m, is 1-12 The day value, d, is 1-31, or
    * 1-28, 1-29 for February The year value, y, is the full year (e.g., 2012)
    *
    * Post-Conditions: A value of 1-7 is returned, representing the first day of
    * the month 1 = Monday, ..., 7 = Sunday
    * 
    * Reference: https://codereview.stackexchange.com/questions/67722/
    * its-friday-zellers-congruence-revisited
    * 
    * @param year
    * @param month
    * @return dayNum (1 = Mon, ... , 7 = Sun )
    * 
    * precondition: month, year, and day are integer types
    * 
    * @author: rolfl, modified by Josh Lafond
    */
   public static int getStartDay(int month, int year) {
      // Adjust month number & year to fit Zeller's numbering system
      if (month < 3) {
         month += 12;
         year -= 1;
      }

      int centuryYear = year % 100;    // Calculate year within century
      int centuryTerm = year / 100;    // Calculate century term
      int firstDayInMonth = 0;         // Day number of first day in month 'm'

      firstDayInMonth = ((1 + // to shift index 0 to the 1-7 return range
         ((13 * (month + 1)) / 5)
         + centuryYear +
         (centuryYear / 4) +
         (centuryTerm / 4) +
         (5 * centuryTerm))) % 7;

      // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
      int dayNum = ((firstDayInMonth + 5) % 7) + 1;

      return dayNum;
   }//end getStartDay

   /**getNumOfDaysInMonth
    * 
    * This method will return the total number of days per month
    * The method will call isLeapYear to determine the days in February
    * 
    * precondition: the year needs to be a full year (e.g. 2012) and
    * the month needs to be a number from 1 to 12
    * postcondition: the number of days will be returned for that month
    * based on the year
    * 
    * @param year
    * @param month
    * @return days in the month (28, 29, 30, or 31)
    */
   public static int getNumOfDaysInMonth(int year, int month) {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12) {
         return 31;
      }
      if (month == 4 || month == 6 || month == 9 || month == 11) {
         return 30;
      }
      if (month == 2) {
         return isLeapYear(year) ? 29 : 28;
      }
      return 0;
   }//end getNumOfDaysInMonth

   /** isLeapYear
    * 
    * This method will return whether true or false for a leap year
    * 
    * precondition: the year needs to be a full year (e.g. 2012)
    * postcondition: a boolean value is returned representing
    * whether or not this is a leap year or not
    * 
    * @param year
    * @return boolean value true or false
    */
   public static boolean isLeapYear (int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
   } //end isLeapYear method
}//end class PrintMonthCalendar
