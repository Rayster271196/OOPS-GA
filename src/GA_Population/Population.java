package GA_Population;

import java.util.ArrayList;

/**
 * This is the Population class. This class is solely responsible for maintaing the individuals into one group. 
 * this class contains the following methods:
 * intializePopulation(): used to add the individuals into a population.
 * getFittest(): used to get the fittest of the population.
 * getSecondFittest(): used to get the second fittest of the population.
 * getLeastFittestIndex(): used to get the least fittest of the population so it can be used to be replaced later. 
 * calculateFitness(): used to calculate the fitness of the individual.
 */
public class Population {
    // ArrayList to store Individual objects
    public ArrayList<Individual<Integer>> individuals = new ArrayList<Individual<Integer>>();
    public int fittest = 0;

// This function is used to add the individuals into a population.

/**
 * This is the method intializePopulation() which is used to initialize the individuals into the population in the ArrayList Individuals.
 * 
 * @param size
 */
    public void initializePopulation(int size) {
        individuals = new ArrayList<Individual<Integer>>();
        for (int i = 0; i < size; i++) {
            individuals.add(new Individual<Integer>());
        }
    }

// Get the fittest individual

/**
 * Method getFittest() :  to get the fittest individual of the population.
 * 
 * @return Individual<Integer>
 */
    public Individual<Integer> getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.size(); i++) {
			//Only replace previous value if new value is larger
            if (maxFit <= individuals.get(i).fitness) {
                maxFit = individuals.get(i).fitness;
                maxFitIndex = i;
            }
        }
		//Assign the max fitness value
        fittest = individuals.get(maxFitIndex).fitness;
		//return the fittest individual
        return individuals.get(maxFitIndex);
    }

// Get the second most fittest individual

/**
 * Method getSecondFittest() :  to get the second fittest of the population.
 * 
 * @return Individual<Integer>
 */
    public Individual<Integer> getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.size(); i++) {
			
            if (individuals.get(i).fitness > individuals.get(maxFit1).fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            }
			else if (individuals.get(i).fitness > individuals.get(maxFit2).fitness) {
                maxFit2 = i;
            }
        }
		
        return individuals.get(maxFit2);
    }

// Get index of least fittest individual

/**
 * Method getLeastFittestIndex() : to get the least fittest index of the population.
 * 
 * @return int
 */
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.size(); i++) {
			
            if (minFitVal >= individuals.get(i).fitness) {
                minFitVal = individuals.get(i).fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

// Calculate fitness of each individual

/**
 * Method calculateFitness() : to calculate the fitness of the individuals.
 * The method invokes class calcFitness from class individual to implement DRY.
 */
    public void calculateFitness() {
        
        for (int i = 0; i < individuals.size(); i++) {
            individuals.get(i).calcFitness();
        }
		
        getFittest();
    }

}