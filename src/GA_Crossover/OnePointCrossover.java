package GA_Crossover;

import java.util.Random;

import GA_Population.Individual;

/**
 * This is the concrete class OnePointCrossover which implements Crossover interface.
 */
public class OnePointCrossover implements Crossover {

/**
 * In this type of crossover we use a random crossover point in the gene of the individual by determining a random point in the gene length.
 * We swap the gene at the crossover point of the second fittest individual with the fittest individual in the population.
 */
    @Override
    public void crossover() {
        Random rn = new Random();

        Individual<Integer> fittest = demo.getFittest();
        Individual<Integer> secondFittest = demo.getSecondFittest();

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
