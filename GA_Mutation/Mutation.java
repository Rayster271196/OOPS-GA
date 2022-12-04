package GA_Mutation;

import GA_Runner.GeneticAlgorithm;

//Mutation interface with GeneticAlgorithm instance to allow concrete 
//classes to access GeneticAlgorithm object
public interface Mutation {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void mutation();
}
