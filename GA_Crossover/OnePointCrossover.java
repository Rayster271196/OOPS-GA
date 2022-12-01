package GA_Crossover;

import java.util.Random;

import GA_Population.Individual;

public class OnePointCrossover implements Crossover {
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
