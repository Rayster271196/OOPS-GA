package GA_Mutation;

import java.util.Random;
import GA_Population.Individual;

// One concrete class that implements Mutation interface, it swap genes based on the rule

/**
 * This is the subclass SwapMutation of Mutation interface. It modifies the method mutation() as per the logic of the mutation method 
 * that is used.
 */
public class SwapMutation implements Mutation
{

/**
 * This is the mutation() method of SwapMuation subclass.
 * In this method we mutate the individuals by randomly getting two mutation points as per the gene length then we flip the values of the genes of the 
 * fittest and second fittest in both the mutation points.
 * We then use setFittest() to change the fittest of the instance.
 */
    public void mutation()
    {
        Random rn = new Random();
        int mutationPointone = rn.nextInt(Individual.geneLength);
        int mutationPointtwo = rn.nextInt(Individual.geneLength);

        Individual fittest = demo.population.getFittest();

        //Make sure the points are not the same 
        if (mutationPointone == mutationPointtwo) {
            mutationPointone++;
            mutationPointone = mutationPointone % 10;
        }
        // System.out.println(mutationPointone+" "+mutationPointone);

        if ((fittest.genes.get(mutationPointone)==fittest.genes.get(mutationPointtwo))
                && (fittest.genes.get(mutationPointone)==0 ))
        {
            fittest.genes.add(mutationPointone, 1);
            fittest.genes.add(mutationPointtwo, 1);
        }
        else if ((fittest.genes.get(mutationPointone)==fittest.genes.get(mutationPointtwo))
                && (fittest.genes.get(mutationPointone)==1 ))
        {
            fittest.genes.add(mutationPointone, 0);
            fittest.genes.add(mutationPointtwo, 0);
        }
        else if ((fittest.genes.get(mutationPointone) == 0 ) && (fittest.genes.get(mutationPointtwo)==1)) 
        {
            fittest.genes.add(mutationPointone, 1);
            fittest.genes.add(mutationPointtwo, 0);
        }
        else
        {
            fittest.genes.add(mutationPointone, 0);
            fittest.genes.add(mutationPointtwo, 1);
        }

        demo.setFittest(fittest);
    }    
}
