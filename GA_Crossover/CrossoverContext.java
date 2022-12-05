package GA_Crossover;

//Context class for Crossover interface and its implementation classes
//Hold crossover object's lifetime and manage it

/**
 * This is the class CrossoverContext where we decide which crossover choice should be used.
 */
public class CrossoverContext {
// Context variable
private Crossover crossover;
  
// Default behaviour will use OnePointCrossover if crossover method is not set.

/**
 * This is the constructor for the class CrossoverContext it will allocate a default crossover method if nothing is passed
 * from the GeneticAlgorithm class.
 * The default crossover method is OnePointCrossover.
 */
  public CrossoverContext(){
    setcrossover(new OnePointCrossover());
  }

/**
 * This is the method setCrossover() which is responsible for determining the the crossover method
 * and prints the name of the crossover method used to the user.
 * 
 * @param crossover
 */
  public void setcrossover(Crossover crossover) {
    System.out.println("Crossover method used is : "+crossover.getClass().getSimpleName());
    this.crossover = crossover;
  }

/**
 * executeStrategy() : method that is responsible for calling the crossover method so the population can be cross-breeded.
 * 
 */
  public void executeStrategy() {
    crossover.crossover();
  }
}
