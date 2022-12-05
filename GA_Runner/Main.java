package GA_Runner;

/**
 * Runner class of the Genetic Algorithm
 * 
 * This uses the package GA_Runner to call the function run() to execute the GA
 * 
 */

//Starter class
public class Main {
    public static void main(String[] args) {
        System.out.println("Default params:");
        GeneticAlgorithm.run(GeneticAlgorithm.getInstance());
    }
}
