package GA_Factories;

import GA_Crossover.*;
// import GA_Main.Population;
import GA_Mutation.*;
import GA_Selection.*;

public class GAConfigOne implements GAFactory {

  @Override
  public Selection selectionChoice(SELECTION selection) {
    // if( selection == SELECTION.ELITE) {
    //   // selectionContext.
    // }
    return null;
  }

  @Override
  public Crossover crossoverChoice() {
    return new OnePointCrossover();
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
