package GA_Selection;

import GA_Runner.GeneticAlgorithm;

//Selection interface with GeneticAlgorithm instance to allow concrete 
//classes to access GeneticAlgorithm object
public interface Selection {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void selection();
}
