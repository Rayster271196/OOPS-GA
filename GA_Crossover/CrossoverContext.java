package GA_Crossover;

public class CrossoverContext {
  /**
   * Context variable
   */
  // Default behaviour will use OnePointCrossover if not selection method is set.
  private Crossover crossover;
  
  public CrossoverContext(){
    setcrossover(new OnePointCrossover());
  }

  public void setcrossover(Crossover crossover) {
    System.out.println("Crossover method used is : "+crossover.getClass().getSimpleName());
    this.crossover = crossover;
  }

  public void executeStrategy() {
    crossover.crossover();
  }
}
