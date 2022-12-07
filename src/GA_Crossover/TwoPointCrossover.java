package GA_Crossover;

import java.util.Random;
import GA_Population.Individual;

// One concrete class that implements Crossover interface, crossovers two points at a time

/**
 * This is the subclass TwoPointCrossover of Crossover interface. It modifies the method crossover() as per the logic of the crossover method 
 * that is used.
 */
public class TwoPointCrossover implements Crossover {

/**
 * This is the crossover() method of TwoPointCrossover.
 * This is the crossover method where we use two crossover point in the gene of the individual by determining two randomn points in the gene length.
 * We also check to make sure the points are different, and also that point one is lower than point 2.
 * If the gene length is greater than point one and lower than point two then we swap
 * We swap the genes of the second fittest to the fittst inn the population.
 */
    public void crossover() {
        Random rn = new Random();

        Individual<Integer> fittest = demo.getFittest();
        Individual<Integer> secondFittest = demo.getSecondFittest();

        // Select a random crossover point
        int crossOverPoint1 = rn.nextInt(Individual.geneLength);
        int crossOverPoint2 = rn.nextInt(Individual.geneLength);

        // Ensure the points are different
        if (crossOverPoint1 == crossOverPoint2) {
            if (crossOverPoint1 == 0) {
                crossOverPoint2++;
            } else {
                crossOverPoint1--;
            }
        }

        // and crosspoint1 is lower than crosspoint2
        if (crossOverPoint2 < crossOverPoint1) {
            int temp = crossOverPoint1;
            crossOverPoint1 = crossOverPoint2;
            crossOverPoint2 = temp;
        }

        // Swap values among the individuals
        for (int i = 0; i < Individual.geneLength; i++) {
            if ((i >= crossOverPoint1) || (i <= crossOverPoint2)) {
                int temp = fittest.genes.get(i);
                fittest.genes.add(i, secondFittest.genes.get(i));
                secondFittest.genes.add(i, temp);
            }
        }
    }
}
