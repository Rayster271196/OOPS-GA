package GA_Selection;

import java.util.*;

import GA_Population.Individual;

/**
 * This is the modified version of the Comparator class where we modify the the compare() method which permits us to later sort
 * the population based on their fitness levels.
 * FitnessCompartor uses the Comparator class  
 */
public class FitnessComparator implements Comparator<Individual<Integer>> {

/**
 * This is the method compare() which is being modifed to compare the individuals based on their fitness
 * 
 * @param individualOne
 * @param individualTwo
 * 
 * @return 0 if equal
 * @return 1 if one > two in terms of fitness
 * @return -1 if one < two in terms of fitness 
 */
    @Override
    public int compare(Individual<Integer> individualOne, Individual<Integer> individualTwo) {
        if (individualOne.fitness == individualTwo.fitness) {
            return 0;
        } else if (individualOne.fitness < individualTwo.fitness) {
            return 1;
        } else {
            return -1;
        }
    }
}