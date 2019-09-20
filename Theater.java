
/**
 * File: Theater.java
 * Description: Theater.java contains the constructor
 * and methods for the Theater object. A Theater contains
 * 5 Screens and total tickets sold for all 5 screens.
 *
 * @author Audrey Rovero
 */

public class Theater {
    Screen[] screens = new Screen[5]; //total screens
    private int total_tickets; // total number of tickets

    public Theater(){

    }

    /**
     * Returns the total number of tickets
     * sold from all 5 screens.
     * @return
     */
    public int getTotal_tickets() {
        for (int i =0; i < screens.length; i++){
            total_tickets+= screens[i].getTickets_sold();
        }
        return total_tickets;
    }

    /**
     *  Returns the Screen object from the
     *  given index in Screens.
     * @param index
     * @return
     */
    public Screen getScreen(int index){
        return screens[index];
    }

    /**
     * Prints out a Screen's number and current movie
     * based on the given index in Screens[].
     * @param index
     */
    public void printScreen(int index){
        System.out.println("Screen "+ (screens[index].getScreen_num()+1)+
                " is playing "+ screens[index].getMovie_name());
    }

    /**
     * Prints all the current Screens, in order, at the Theater
     */
    public void printScreens(){
        for (int i =0; i < screens.length; i++){
            System.out.println("   Screen "+ (screens[i].getScreen_num()+1)+
            " is playing "+ screens[i].getMovie_name());
        }
    }

    /**
     * Adds a new Screen object to the Screen[].
     * @param s
     */
    public void addScreen(Screen s){
        int index = s.getScreen_num();
        screens[index] = s;
    }
}
