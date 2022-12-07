package GA_Selection;

import java.util.*;

/**
 * This is a concrete class EliteSelection which implements the interface Selection.
 * It does the selection as per the logic of EliteSelection which takes randomly any two individual from the 
 * top 10 most fittest individuals.
 * 
 */
public class EliteSelection implements Selection {

    /**
     * This is the selection() method of EliteSelection.
     * In this we first sort the population as per their fitness and then we randomly pick two of the individuals from the
     * top 10 fittest individuals and then set them as fittest and secondFittest.
     *
     */
    public void selection() {
        Collections.sort(demo.population.individuals, new FitnessComparator());

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
