package GA_Crossover;

import GA_Runner.GeneticAlgorithm;

//Crossover interface with GeneticAlgorithm instance to allow concrete 
//classes to access GeneticAlgorithm object.

/**
 * This is the interface for Crossover. It has two subclasses OnePointCrossover and TwoPointCrossover.
 * Uses the instance that was previously created by the GeneticAlgortithm class.
 * crossover() : method that is used to define the crossover type as per the subclass.
 * Here Strategy Pattern is implemented with this being the interface and OnePointCrossover, TwoPointCrossover being the modified as per the functionality using method crossover().
 */
public interface Crossover {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void crossover();
}
