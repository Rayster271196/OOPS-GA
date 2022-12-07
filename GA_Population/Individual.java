package GA_Population;

import java.util.Random;
import java.util.ArrayList;

/**
 * This is the Individual class which is responsible for creating the an individual where a collection of them will be in a population.
 * It has a constructor where the genes are added and the fitness is intialized.
 */
public class Individual<T extends Integer> {

    public int fitness = 0;
    public static int geneLength = 10; // Example gene : [0100011010]
    public ArrayList<T> genes= new ArrayList<T>(); //ArrayList to store random generated genes

// A list of genes randomly generated when Individual object initialized

/**
 * This is the constructor of Individual where the genes are added and the fitness is intialized.
 */
    public Individual() {
        Random rn = new Random();

        //Set genes randomly for each individual
        for (int i = 0; i < geneLength; i++) {
            genes.add((T)new Integer(Math.abs(rn.nextInt() % 2)));
            // genes.add(1, null);
        }
        fitness = 0;
    }

// Calculate fitness

/**
 * This is the method that is used to calculate the fitness of the given individual.
 */
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < geneLength; i++) {
            if (genes.get(i) == 1) {
                ++fitness;
            }
        }
    }

}