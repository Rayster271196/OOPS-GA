package GA_Main;
import java.util.Random;

import GA_Selection.*;
import GA_Crossover.*;
import GA_Mutation.*;
import GA_Factories.*;

public class Main {
    public static void main(String[] args) {

        Random rn = new Random();

        GeneticAlgorithm demo = GeneticAlgorithm.getInstance();

        //Initialize population
        demo.population.initializePopulation(12);

        //Calculate fitness of each individual
        demo.population.calculateFitness();

        System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);

        GAFactory factoryConfigOne = new GAConfigTwo();

        //While population gets an individual with maximum fitness
        while (demo.population.fittest < Individual.geneLength) {
            ++demo.generationCount;

            // factoryConfigOne.selectionChoice().selection();
            factoryConfigOne.crossoverChoice().crossover();

            //Do mutation under a random probability
            if (rn.nextInt()%10 > 5){
                factoryConfigOne.mutationChoice().mutation();
            }

            //Add fittest offspring to population
            demo.addFittestOffspring();

            //Calculate new fitness value
            demo.population.calculateFitness();

            System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
        }

        System.out.println("\nSolution found in generation " + demo.generationCount);
        System.out.println("Fitness: "+demo.population.getFittest().fitness);
        System.out.print("Genes: ");
        for (int i = 0; i < Individual.geneLength; i++) {
            System.out.print(demo.population.getFittest().genes.get(i));
        }

        System.out.println("");

    }
}
