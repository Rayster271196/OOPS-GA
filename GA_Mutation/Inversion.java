package GA_Mutation;

import java.util.Random;

import GA_Main.Individual;

public class Inversion implements Mutation {
    public void mutation() {
        Random rn = new Random();

        Individual fittest = demo.population.getFittest();
        Individual secondFittest = demo.population.getSecondFittest();

        // Select a random mutation point
        int mutationPoint = rn.nextInt(Individual.geneLength);

        // Flip values at the mutation point
        if (fittest.genes.get(mutationPoint) == 0) {
            fittest.genes.add(mutationPoint, 1);
        } else {
            fittest.genes.add(mutationPoint, 0);
        }

        mutationPoint = rn.nextInt(Individual.geneLength);

        if (secondFittest.genes.get(mutationPoint) == 0) {
            secondFittest.genes.add(mutationPoint, 1);
        } else {
            secondFittest.genes.add(mutationPoint, 0);
        }
    }
}
