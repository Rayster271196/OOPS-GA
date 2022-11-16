import java.util.Random;
import java.util.ArrayList;

public class Individual {

    int fitness = 0;
    static int geneLength = 10; // Example gene : [0100011010]
    ArrayList<Integer> genes= new ArrayList<Integer>();

    public Individual() {
        Random rn = new Random();

        //Set genes randomly for each individual
        for (int i = 0; i < geneLength; i++) {
            genes.add(Math.abs(rn.nextInt() % 2));
        }
        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < geneLength; i++) {
            if (genes.get(i) == 1) {
                ++fitness;
            }
        }
    }

}