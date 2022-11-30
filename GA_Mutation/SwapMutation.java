package GA_Mutation;

import java.util.Random;

import GA_Main.Individual;

public class SwapMutation implements Mutation
{
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
