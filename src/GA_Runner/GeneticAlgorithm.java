package GA_Runner;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import GA_Selection.*;
import GA_Mutation.*;
import GA_Crossover.*;
import GA_Factories.*;
import GA_Population.*;

/**
 * This is the GeneticAlgorithm class which is responsible for creating the instance.
 * This is where the Singleton Pattern is implemented. There is only a need of one instance where that instance parameters should be modifed to get the result.
 * This allows better consisitency and makes sure all the function are working on the same data.
 * It is responsible for creating the context of each of the methods. 
 * It also holds the run() function which is where the user interacts and can change the choice in the class for the methods and enters the input for the gene-length and population
 * You can also change the type of methods use by using the appropriate enumerations
 * The fittest and second fittest which are used by the process can be accessed the setters and getters 
 */

// Logical codes where GeneticAlgorithm really works
public class GeneticAlgorithm {

    public Population population = new Population();
    private Individual<Integer> fittest;
    private Individual<Integer> secondFittest;
    int generationCount = 0;

	//Context objects for Selection, Crossover and Mutation objects
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

    public Individual<Integer> getFittest() {
        return fittest;
    }

    public void setFittest(Individual<Integer> fittest) {
        this.fittest = fittest;
    }


    public Individual<Integer> getSecondFittest() {
        return secondFittest;
    }

    public void setSecondFittest(Individual<Integer> secondFittest) {
        this.secondFittest = secondFittest;
    }

/**
 * getFittestOffspring() finds the fittest offspring in the population
 *
 * @return the fittest offspring in the population
 */
    //Get fittest offspring
    Individual<Integer> getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }

/**
 * method addFittestOffspring(): Replaces the least-fit member with the most fittest membr in the population
 *
 * @return void
 */
// Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.individuals.add(leastFittestIndex, getFittestOffspring());
    }

/**
 * method run(): In this method the user can enter the gene length and the population limit.
 * We can also change the choice of the methods in this function to suit our needs.
 * It is also responsible for displaying the number if generations that it took and the results of the GA.
 */
    static void run(GeneticAlgorithm geneticAlgorithm){
        Scanner scan = new Scanner(System.in);
        Random rn = new Random();
        try{
            System.out.println("Default parameters:");
            System.out.println(geneticAlgorithm.selectionContext);
            System.out.println(geneticAlgorithm.crossoverContext);
            System.out.println(geneticAlgorithm.mutationContext);


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
            geneticAlgorithm.selectionContext.setSelection(factoryConfig.selectionChoice(GAFactory.SELECTION.TWOFITTEST));
            geneticAlgorithm.crossoverContext.setcrossover(factoryConfig.crossoverChoice(GAFactory.CROSSOVER.TWOPOINT));
            geneticAlgorithm.mutationContext.setMutation(factoryConfig.mutationChoice(GAFactory.MUTATION.INVERSION));
            
            System.out.println("New Parameters used :");
            System.out.println(geneticAlgorithm.selectionContext);
            System.out.println(geneticAlgorithm.crossoverContext);
            System.out.println(geneticAlgorithm.mutationContext);
            
            System.out.println("\n\nGeneration: " + geneticAlgorithm.generationCount + " Fittest: " + geneticAlgorithm.population.fittest);
            //While population gets an individual with maximum fitness
            while (geneticAlgorithm.population.fittest < Individual.geneLength) {
                ++geneticAlgorithm.generationCount;

                // Once selection, crossover and mutation objects are set we can then call executeStrategy.
                geneticAlgorithm.selectionContext.executeStrategy();
                geneticAlgorithm.crossoverContext.executeStrategy();

                //Do mutation under a random probability
                if (rn.nextInt()%10 > 3){
                    System.out.println("Mutating.....");
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
			appendToFile(e);
        }
        finally{
            scan.close();
        }
    }
    public static void appendToFile(Exception e) {
        try {
            FileWriter New_File = new FileWriter("Error-log.txt", true);
            BufferedWriter Buff_File = new BufferedWriter(New_File);
            PrintWriter Print_File = new PrintWriter(Buff_File, true);
            e.printStackTrace(Print_File);
        }
        catch (Exception ie) {
            throw new RuntimeException("Cannot write the Exception to file", ie);
        }
    }	

}