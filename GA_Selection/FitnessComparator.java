package GA_Selection;

import java.util.*;

import GA_Population.Individual;

//Concrete class for Comparator that compare each Individual's fitness
public class FitnessComparator implements Comparator<Individual> {
    @Override
    public int compare(Individual individualOne, Individual individualTwo) {
        if (individualOne.fitness == individualTwo.fitness) {
            return 0;
        } else if (individualOne.fitness < individualTwo.fitness) {
            return 1;
        } else {
            return -1;
        }
    }
}