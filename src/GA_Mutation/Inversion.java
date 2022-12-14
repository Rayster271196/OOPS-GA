package GA_Mutation;

import java.util.Random;
import GA_Population.Individual;

/**
 * The subclass inversion of the interface Mutation, this implements the Inversion algorithm by inverting the genes of an individual
 * by flipping at randomn points as per the gene length. 
 */
public class Inversion implements Mutation {

    /**
     * This is the mutation() method of Inversion subclass.
     * In this method we mutate the individuals by randomly getting a mutation point
     * as per the gene length then we flip the values of the genes of the
     * fittest and second fittest.
     * We then use setFittest() and setSecondFittest() to change the fittest and the
     * second fittest of the instance.
     */
    public void mutation() {
        Random rn = new Random();

        Individual<Integer> fittest = demo.population.getFittest();
        Individual<Integer> secondFittest = demo.population.getSecondFittest();

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

        demo.setFittest(fittest);
        demo.setSecondFittest(secondFittest);
    }
}
