package GA_Crossover;

public class CrossoverContext {
  // Context variable
  private Crossover crossover;
  
  // Default behaviour will use OnePointCrossover if crossover method is not set.
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