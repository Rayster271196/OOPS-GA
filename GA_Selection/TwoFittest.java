package GA_Selection;

import java.util.ArrayList;
// import java.util.Random;

import GA_Main.*;

public class TwoFittest implements Selection {

    public ArrayList<Individual> selection() {
        ArrayList<Individual> selected = new ArrayList<Individual>();
        selected.add(demo.population.getFittest());
        selected.add(demo.population.getSecondFittest());

        return selected;

    }

}
