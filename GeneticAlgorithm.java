import java.util.Random;

public class GeneticAlgorithm {

    //Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;

	AbstractFactory populationFactory = FactoryProvider.getFactory("Population");
	PopulationInterface populationByFitness = populationFactory.create("Fitness");
    // This is the eagerly created implementation of the GeneticAlgorithm class. It is thread-safe. 
	private static GeneticAlgorithm instance_ = new GeneticAlgorithm();

    // Private constructor. It can not be envoked by another class
    private GeneticAlgorithm(){}

    public static GeneticAlgorithm getInstance(){
        return instance_;
    }
    
    //Selection
    void selection() {

        //Select the most fittest individual
        fittest = populationByFitness.getFittest();

        //Select the second most fittest individual
        secondFittest = populationByFitness.getSecondFittest();
    }

    //Crossover
    void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(Individual.geneLength);

        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.genes.get(i);
            fittest.genes.add(i, secondFittest.genes.get(i));
            secondFittest.genes.add(i, temp);

        }

    }

    //Mutation
    void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(populationByFitness.individuals.get(0).geneLength);

        //Flip values at the mutation point
        if (fittest.genes.get(mutationPoint) == 0) {
            fittest.genes.add(mutationPoint,1);
        } else {
            fittest.genes.add(mutationPoint, 0);
        }

        mutationPoint = rn.nextInt(populationByFitness.individuals.get(0).geneLength);

        if (secondFittest.genes.get(mutationPoint) == 0) {
            secondFittest.genes.add(mutationPoint,1);
        } else {
            secondFittest.genes.add(mutationPoint, 0);
        }
    }

    //Get fittest offspring
    Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = populationByFitness.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        populationByFitness.individuals.add(leastFittestIndex, getFittestOffspring());
    }

}