package GA_Population;
import java.util.ArrayList;

public class Population {
	//ArrayList to store Individual objects
    public ArrayList<Individual> individuals = new ArrayList<Individual>();
    public int fittest = 0;

    //Initialize population
    public void initializePopulation(int size) {
        individuals = new ArrayList<Individual>(size);
        for (int i = 0; i < size; i++) {

            individuals.add(new Individual());
        }
    }

    //Get the fittest individual
    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.size(); i++) {
			//Only replace previous value if new value is larger
            if (maxFit <= individuals.get(i).fitness) {
                maxFit = individuals.get(i).fitness;
                maxFitIndex = i;
            }
        }
		//Assign the max fitness value
        fittest = individuals.get(maxFitIndex).fitness;
		//return the fittest individual
        return individuals.get(maxFitIndex);
    }

    //Get the second most fittest individual
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.size(); i++) {
			//Only execute this clause if new value is larger the largest previous one
            if (individuals.get(i).fitness > individuals.get(maxFit1).fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            }//Only enter this clause if new value is smaller than the largest one but larger than the second largest one 
			else if (individuals.get(i).fitness > individuals.get(maxFit2).fitness) {
                maxFit2 = i;
            }
        }
		//return the second most fitness individual
        return individuals.get(maxFit2);
    }

    //Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.size(); i++) {
			//Only enter this clause if new value smaller than the previous smallest one
            if (minFitVal >= individuals.get(i).fitness) {
                minFitVal = individuals.get(i).fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each individual
    public void calculateFitness() {
        
        for (int i = 0; i < individuals.size(); i++) {
            individuals.get(i).calcFitness();
        }
		//Run this method to assign the max fitness value to fitness variable
        getFittest();
    }

}