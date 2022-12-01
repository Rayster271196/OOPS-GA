package GA_Runner;
import java.util.Random;
import java.util.Scanner;

import GA_Crossover.CrossoverContext;
import GA_Selection.SelectionContext;
import GA_Mutation.MutationContext;
import GA_Factories.*;
import GA_Population.*;

public class GeneticAlgorithm {

    public Population population = new Population();
    private Individual fittest;
    private Individual secondFittest;
    int generationCount = 0;

    SelectionContext selectionContext = new SelectionContext();
    CrossoverContext crossoverContext = new CrossoverContext();
    MutationContext mutationContext = new MutationContext();

    // This is the eagerly created implementation of the GeneticAlgorithm class. It is thread-safe. 
	private static GeneticAlgorithm instance_ = new GeneticAlgorithm();

    // Private constructor. It can not be envoked by another class
    private GeneticAlgorithm(){}

    public static GeneticAlgorithm getInstance(){
        return instance_;
    }

    public Individual getFittest() {
        return fittest;
    }

    public void setFittest(Individual fittest) {
        this.fittest = fittest;
    }


    public Individual getSecondFittest() {
        return secondFittest;
    }

    public void setSecondFittest(Individual secondFittest) {
        this.secondFittest = secondFittest;
    }

    // //Get fittest offspring
    Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.individuals.add(leastFittestIndex, getFittestOffspring());
    }

    static void run(GeneticAlgorithm geneticAlgorithm){
        Scanner scan = new Scanner(System.in);
        Random rn = new Random();
        try{
            System.out.println("*".repeat(100));
            System.out.println("Starting Genetic Algorithm.....\n");

            //Initialize population
            System.out.println("Enter gene length: ");
            Individual.geneLength = scan.nextInt();
            if(Individual.geneLength <= 1){
                throw new Exception("Gene length must be greater than one");
            }
            System.out.println("Enter size of population: ");
            int populationSize = scan.nextInt();
            if(populationSize <= 2){
                throw new Exception("Population size must be greater than two");
            }
            geneticAlgorithm.population.initializePopulation(populationSize);

            //Calculate fitness of each individual
            geneticAlgorithm.population.calculateFitness();
            System.out.println();
            

            GAFactory factoryConfig = new GAConfig();
            // Create factory object to create selection, crossover and mutation objects,
            // and send these returned objects in the respective context classes.
            System.out.println("New Parameters used :");
            geneticAlgorithm.selectionContext.setSelection(factoryConfig.selectionChoice(GAFactory.SELECTION.TWOFITTEST));
            geneticAlgorithm.crossoverContext.setcrossover(factoryConfig.crossoverChoice(GAFactory.CROSSOVER.TWOPOINT));
            geneticAlgorithm.mutationContext.setMutation(factoryConfig.mutationChoice());

            
            System.out.println("\n\nGeneration: " + geneticAlgorithm.generationCount + " Fittest: " + geneticAlgorithm.population.fittest);
            //While population gets an individual with maximum fitness
            while (geneticAlgorithm.population.fittest < Individual.geneLength) {
                ++geneticAlgorithm.generationCount;

                // Once selection, crossover and mutation objects are set we can then call executeStrategy.
                geneticAlgorithm.selectionContext.executeStrategy();
                geneticAlgorithm.crossoverContext.executeStrategy();

                //Do mutation under a random probability
                if (rn.nextInt()%10 > 3){
                    geneticAlgorithm.mutationContext.executeStrategy();
                }

                // Add fittest offspring to population
                geneticAlgorithm.addFittestOffspring();

                // Calculate new fitness value
                geneticAlgorithm.population.calculateFitness();

                System.out.println("Generation: " + geneticAlgorithm.generationCount + " Fittest: " + geneticAlgorithm.population.fittest);
            }

            System.out.println("\nSolution found in generation " + geneticAlgorithm.generationCount);
            System.out.println("Fitness: "+geneticAlgorithm.population.getFittest().fitness);
            System.out.print("Genes: ");
            for (int i = 0; i < Individual.geneLength; i++) {
                System.out.print(geneticAlgorithm.population.getFittest().genes.get(i));
            }
            System.out.println();
            System.out.println("*".repeat(100));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            scan.close();
        }
    }

}