package GA_Crossover;

import java.util.Random;
import GA_Population.Individual;

/**
 * This is the concrete class TwoPointCrossover which implements Crossover interface.
 */
public class TwoPointCrossover implements Crossover {

/**
 * In this type of crossover, we take any two random crossover point in the gene of the fittest and second fittest individual
 * We swap the genes between crossoverpoint1 and crossoverpoint2 with the second fittest and the fittest in the population.
 */
    public void crossover() {
        Random rn = new Random();

        Individual<Integer> fittest = demo.getFittest();
        Individual<Integer> secondFittest = demo.getSecondFittest();

        // Select two random crossover points
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

        // Swap values among fittest and second fittest individuals
        for (int i = 0; i < Individual.geneLength; i++) {
            if ((i >= crossOverPoint1) || (i <= crossOverPoint2)) {
                int temp = fittest.genes.get(i);
                fittest.genes.add(i, secondFittest.genes.get(i));
                secondFittest.genes.add(i, temp);
            }
        }
    }
}
