
/**
 * File: BoxOffice.java
 * Description: BoxOffice is the main program.
 * The program is designed to be used on the commandline
 * and can be used to change the movies that are showing and
 * by customers to purchase tickets.
 *
 * @author Audrey Rovero
 */

import java.util.Scanner;

public class BoxOffice {


    /**
     * The main method creates the Theater with default movies in
     * each of it's 5 screens and handles processing the user's
     * responses on the commandline.
     * @param args
     */
    public static void main(String[] args) {
        // Create default movies
        Screen s1 = new Screen(0,"Lilo & Stitch");
        Screen s2 = new Screen(1,"Spirited Away");
        Screen s3 = new Screen(2,"Toy Story" );
        Screen s4 = new Screen(3,"Castle in the Sky");
        Screen s5 = new Screen(4,"Double Indemnity");

     // Create Theater
        Theater theater = new Theater();
        theater.addScreen(s1);
        theater.addScreen(s2);
        theater.addScreen(s3);
        theater.addScreen(s4);
        theater.addScreen(s5);

        int curr = 0; // tracks current menu
        String choice = "5";
        Scanner scanner = new Scanner(System.in);
     // Start while loop to handle UI
       while (curr != -1 ) {

           if (choice.equals("C") || curr == 1){ //change movies
               curr = 1;
               System.out.println();
               System.out.println("Current Screenings Today:");
               theater.printScreens();
               System.out.print("Please enter Screen number of movie to change or 0 to" +
                       " go back: ");
               choice = scanner.nextLine();
               if (choice.equals("0")){
                   curr = 0;
               } else{
                   try {
                       int index = Integer.parseInt(choice);
                       if (index < 6 && index > 0) {
                           String newMovie;
                           System.out.print("Please enter new movie: ");
                           newMovie = scanner.nextLine();
                           theater.screens[index - 1].setMovie_name(newMovie);
                           theater.printScreen(index - 1);
                       } else {
                           System.out.println("Not a valid Screen number");
                       }
                   } catch (NumberFormatException e){
                       System.out.println("Not a valid Screen number.");
                   }
               }
           }
           if (choice.equals("T") || curr == 2){ //start ticket sales
               curr = 2;
               System.out.println("Welcome to the Theater!");
               System.out.println("What would you like to do?");
               System.out.println("   [B] Buy Tickets");
               System.out.println("   [E] End Ticket Sales");
               System.out.print("Please enter your choice[B,E]: ");
               choice = scanner.nextLine();
               if (choice.equals("B")){ // buy tickets
                   System.out.println();
                   System.out.println("Welcome! Here are our Screening for today:");
                   theater.printScreens();
                   System.out.print("Please enter Screen number of movie you would like to purchase" +
                           " tickets for: ");
                   choice = scanner.nextLine();
                   try {
                       int index = Integer.parseInt(choice);
                       if (index < 6 && index > 0) {
                           System.out.println(theater.screens[index - 1].getMovie_name() +
                                   " has " + theater.screens[index - 1].getNum_tickets() + " tickets available.");
                           System.out.print("How many tickets would you like to purchase for " +
                                   theater.screens[index - 1].getMovie_name() + "? ");
                           choice = scanner.nextLine();
                           int tickets = Integer.parseInt(choice);
                           if (tickets > 0) {
                           theater.screens[index - 1].buy_tickets(tickets);
                           System.out.println();
                         } else {
                           System.out.println("Not a vailid amount.");
                         }
                       } else {
                           System.out.println("Not a valid Screen number.");
                       }
                   } catch (NumberFormatException e){
                       System.out.println("Not a valid number.");
                   }
               }
               if (choice.equals("E")){ // end day
                   curr = -1;
                   Screen m1 = theater.screens[0];
                   Screen m2 = theater.screens[1];
                   Screen m3 = theater.screens[2];
                   Screen m4 = theater.screens[3];
                   Screen m5 = theater.screens[4];
                   System.out.println();
                   System.out.println("Ticket Sales have closed for today");
                   System.out.println("Let's see how we did...");
                   System.out.println("Total tickets sold: "+ theater.getTotal_tickets());
                   System.out.println(" ||| SCREEN 1 |||");
                   System.out.println("Screen 1 played "+ m1.getMovie_name());
                   System.out.println(m1.getMovie_name() + " sold "+m1.getTickets_sold()
                   + " tickets out of 50 total tickets");
                   System.out.println(" ||| SCREEN 2 |||");
                   System.out.println("Screen 2 played "+ m2.getMovie_name());
                   System.out.println(m2.getMovie_name() + " sold "+m2.getTickets_sold()
                           + " tickets out of 50 total tickets");
                   System.out.println(" ||| SCREEN 3 |||");
                   System.out.println("Screen 3 played "+ m3.getMovie_name());
                   System.out.println(m3.getMovie_name() + " sold "+m3.getTickets_sold()
                           + " tickets out of 50 total tickets");
                   System.out.println(" ||| SCREEN 4 |||");
                   System.out.println("Screen 4 played "+ m4.getMovie_name());
                   System.out.println(m4.getMovie_name() + " sold "+m4.getTickets_sold()
                           + " tickets out of 50 total tickets");
                   System.out.println(" ||| SCREEN 5 |||");
                   System.out.println("Screen 5 played "+ m5.getMovie_name());
                   System.out.println(m5.getMovie_name() + " sold "+m5.getTickets_sold()
                           + " tickets out of 50 total tickets");
                   System.out.println("Reporting Complete");
                   System.out.println("Goodnight!");
               }
           }

           if (curr == 0){ // default start screen
               System.out.println("Welcome to the Theater!");
               System.out.println("What would you like to do?");
               System.out.println("   [C] Change Movies");
               System.out.println("   [T] Start Ticket Sales");
               System.out.println("   [Q] Quit");
               System.out.print("Please enter your choice[C,T,Q]: ");
               choice = scanner.nextLine();
           }

           if (choice.equals("Q")){ //quit
               System.out.println("Goodbye!");
               curr = -1;
           }
       }
        System.exit(0);

     }
}
