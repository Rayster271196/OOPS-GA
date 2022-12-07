package GA_Selection;

import java.util.*;

// The implementation of the interface Seelction in the subclass EliteSelection as per the algorithm. 

/**
 * This is the subclass EliteSelection of the interface Selection. It modfies the selection() method as per the logic of EliteSelection
 * 
 */
public class EliteSelection implements Selection {

/**
 * This is the selection() method of EliteSelection.
 * In this we first sort the population as per their fitness and then we randomly pick two of the individuals and make them the 
 * fittest and the second-fittest
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
