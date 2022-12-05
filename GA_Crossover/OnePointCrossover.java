package GA_Crossover;

import java.util.Random;

import GA_Population.Individual;

// One concrete class that implements Crossover interface, crossover one point at a time

/**
 * This is the subclass OnePointCrossover of Crossover interface. It modifies the method crossover() as per the logic of the crossover method 
 * that is used.
 */
public class OnePointCrossover implements Crossover {

/**
 * This is the crossover() method of OnePointCrossover.
 * This is the crossover method where we use one crossover point in the gene of the individual by determining a randomn point in the gene length.
 * We swap the gene of the second fittest to the fittst inn the population.
 */
    public void crossover() {
        Random rn = new Random();

        Individual fittest = demo.getFittest();
        Individual secondFittest = demo.getSecondFittest();

        // Select a random crossover point
        int crossOverPoint = rn.nextInt(Individual.geneLength);

        // Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.genes.get(i);
            fittest.genes.add(i, secondFittest.genes.get(i));
            secondFittest.genes.add(i, temp);

        }
    }
}
