package GA_Crossover;

//Context class for Crossover interface and its implementation classes. Hold crossover object's lifetime and manage it

public class CrossoverContext {
  // Context variable
  private Crossover crossover;

  /**
   * This is the constructor for the class CrossoverContext it will allocate a default crossover method if nothing is passed
   * from the GeneticAlgorithm class.
   * The default crossover method is OnePointCrossover.
   */
  public CrossoverContext(){
    setcrossover(new OnePointCrossover());
  }

  /**
   * This is the method setCrossover() which is responsible for setting the the crossover method
   * selected by the user
   * 
   * @param crossover
   */
  public void setcrossover(Crossover crossover) {
    this.crossover = crossover;
  }

  /**
   * executeStrategy() : method that is responsible for invoking the selected crossover method so the population can be cross-breeded.
   * 
  */
  public void executeStrategy() {
    crossover.crossover();
  }

  /*
   * toString method for CrossoverContext class
  */
  @Override
  public String toString() {
      return "Crossover method : "+crossover.getClass().getSimpleName();
  }
}
