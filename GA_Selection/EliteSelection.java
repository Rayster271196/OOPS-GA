package GA_Selection;

import java.util.*;

public class EliteSelection implements Selection {
    public void selection() {
        Collections.sort(demo.population.individuals, new FitnessComparator());

        // System.out.println()
        Random rn = new Random();
        int randomIndexOne = rn.nextInt(10);
        int randomIndexTwo = rn.nextInt(10);
        if (randomIndexOne == randomIndexTwo) {
            randomIndexOne++;
            randomIndexOne = randomIndexOne % 10;
        }

        demo.setFittest(demo.population.individuals.get(randomIndexOne));
        demo.setSecondFittest(demo.population.individuals.get(randomIndexTwo));
    }
}
