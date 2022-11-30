package GA_Factories;

import GA_Crossover.*;
// import GA_Main.Population;
import GA_Mutation.*;
import GA_Selection.*;

public class GAConfig implements GAFactory {

  
  @Override
  public Selection selectionChoice(SELECTION selection) {
    if( selection == SELECTION.ELITE) {
      return new EliteSelection();
    }
    else if(selection == SELECTION.TWOFITTEST){
      return new TwoFittest();
    }
    else{
      throw new IllegalArgumentException("Illegal Argument: " + selection.name());
    }
  }

  @Override
  public Crossover crossoverChoice(CROSSOVER crossover) {
    if( crossover == CROSSOVER.ONEPOINT) {
      return new OnePointCrossover();
    }
    else if(crossover == CROSSOVER.TWOPOINT){
      return new TwoPointCrossover();
    }
    else{
      throw new IllegalArgumentException("Illegal Argument: " + crossover.name());
    }
  }

  @Override
  public Mutation mutationChoice() {
    double num = Math.random() * 2;
    if (num <= 0.5) {
      return new Inversion();
    } else {
      return new SwapMutation();
    }
  }
}
