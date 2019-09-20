
/**
 * File: Screen.java
 * Description: Screen.java contains the
 *  constructor and methods for the Screen object.
 *  A Screen object is used to represent an available
 *  screen at a movie theater. A Screen has a designated
 *  screen number, the movie it is showing, and a limited
 *  amount of tickets to purchase for it.
 *
 *  @author Audrey Rovero
 *
 */


public class Screen {
    private int screen_num; // screen number
    private String movie_name; //name of movie
    private int num_tickets = 50; // number of tickets available for purchase
    private int tickets_sold = 0;

    /**
     * The Screen constructor is used to initialize a
     * a Screen object. The designated number of the screen,
     * passed in as a int, as well as the movie playing at the screen
     * are needed to construct Screen object.
     * @param screen_num
     * @param movie_name
     */
    public Screen(int screen_num, String movie_name) {
        this.screen_num = screen_num;
        this.movie_name = movie_name;
    }

    /**
     * Sets the screen_num to the given screen_num
     * @param screen_num
     */
    public void setScreen_num(int screen_num) {
        this.screen_num = screen_num;
    }

    /**
     * Sets the movie_name to the given movie_name
     * @param movie_name
     */
    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    /**
     * Returns the current number of tickets
     * available for sale
     * @return
     */
    public int getNum_tickets() {
        return num_tickets;
    }

    /**
     * Returns the screen number
     * @return
     */
    public int getScreen_num() {
        return screen_num;
    }

    /**
     * Returns the name of the movie currently
     * playing at the Screen
     * @return
     */
    public String getMovie_name() {
        return movie_name;
    }

    /**
     * Returns the number of tickets sold
     * @return
     */
    public int getTickets_sold() {
        return tickets_sold;
    }

    /**
     * Takes in a amount of tickets to be bought
     * for the screening and processes it. If not
     * enough tickets are available, the ticket purchase
     * will not go through.
     * @param ticket_amt
     */
    public void buy_tickets(int ticket_amt ) {
        if (ticket_amt > num_tickets) {
            System.out.println("Sorry we only have " + num_tickets + " tickets " +
                    " available.");
        } else {
            tickets_sold += ticket_amt;
            num_tickets -= ticket_amt;
            System.out.println(ticket_amt + " tickets purchased out of " + (num_tickets + ticket_amt)
                    + " available tickets for screening.");
        }
    }

}
