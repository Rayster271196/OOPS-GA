package GA_Mutation;

import GA_Runner.GeneticAlgorithm;

// Mutation interface with GeneticAlgorithm instance to allow concrete 
// classes to access GeneticAlgorithm object.

/**
 * This is the interface for Mutation. It has two subclasses Inversion and SwapMutation.
 * Uses the instance that was previously created by the GeneticAlgortithm class.
 * mutation() : method that is used to define the mutation type as per choice of mutation.
 * Here Strategy Pattern is implemented with this being the interface and Inversion, SwapMutation. being the modified as per the functionality using method mutation().
 */
public interface Mutation {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void mutation();
}
