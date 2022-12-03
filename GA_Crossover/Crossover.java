package GA_Crossover;

import GA_Runner.GeneticAlgorithm;

//Crossover interface with GeneticAlgorithm instance to allow concrete 
//classes to access GeneticAlgorithm object
public interface Crossover {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void crossover();
}
