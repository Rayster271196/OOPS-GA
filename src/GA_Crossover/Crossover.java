package GA_Crossover;

import GA_Runner.GeneticAlgorithm;

/**
 * This is the interface for Crossover. It is implemented by OnePointCrossover and TwoPointCrossover class.
 * crossover() : executes the crossover which is set.
 * Here Strategy Pattern is implemented with this being the interface and OnePointCrossover, TwoPointCrossover being
 * the concrete classes.
 */
public interface Crossover {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void crossover();
}
