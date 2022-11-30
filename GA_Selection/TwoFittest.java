package GA_Selection;

public class TwoFittest implements Selection {

    public void selection() {
        demo.setFittest(demo.population.getFittest());
        demo.setSecondFittest(demo.population.getSecondFittest());
    }

}
