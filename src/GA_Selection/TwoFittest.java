package GA_Selection;

/**
 * This is the concrete TwoFittest of the interface Selection. It modifies the selection() method as per the logic of TwoFittest
 *
 */
public class TwoFittest implements Selection {

/**
 * This is the selection() method of TwoFittest.
 * in this we use the functions getFittest() and getSecondFittest() and set them using the setters setFittest() and setSecondFittest()
 * Here we choose the individuals which has the first and the second highest fitness levels
 * 
 * @return void 
 */
    public void selection() {
        demo.setFittest(demo.population.getFittest());
        demo.setSecondFittest(demo.population.getSecondFittest());
    }

}
