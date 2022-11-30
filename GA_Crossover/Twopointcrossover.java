package GA_Crossover;

// import java.util.Collections;
import java.util.Random;
// import java.util.Random.*;

// import GA_Main.GeneticAlgorithm;
import GA_Main.Individual;
// import GA_Selection.EliteSelection;

public class TwoPointCrossover implements Crossover {
    public void crossover() {
        Random rn = new Random();

        Individual fittest = demo.getFittest();
        Individual secondFittest = demo.getSecondFittest();

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

        // Swap values among parents
        for (int i = 0; i < Individual.geneLength; i++) {
            if ((i >= crossOverPoint1) || (i <= crossOverPoint2)) {
                int temp = fittest.genes.get(i);
                fittest.genes.add(i, secondFittest.genes.get(i));
                secondFittest.genes.add(i, temp);
            }
        }
    }
}
