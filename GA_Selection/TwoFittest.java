package GA_Selection;

//One concrete class that implements Selection interface, set most fittest and the second fittest at a time
public class TwoFittest implements Selection {

    public void selection() {
        demo.setFittest(demo.population.getFittest());
        demo.setSecondFittest(demo.population.getSecondFittest());
    }

}
