package GA_Factories;

import GA_Crossover.*;
// import GA_Main.Population;
import GA_Mutation.*;
import GA_Selection.*;

public class GAConfigTwo implements GAFactory {

  @Override
  public Selection selectionChoice(SELECTION selection) {
    return new TwoFittest();
  }

  @Override
  public Crossover crossoverChoice() {
    return new TwoPointCrossover();
  }

  @Override
  public Mutation mutationChoice() {
    double num = Math.random();
    if (num <= 0.5) {
      return new Inversion();
    } else {
      return new SwapMutation();
    }
  }
}
