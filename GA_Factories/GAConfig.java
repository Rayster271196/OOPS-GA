package GA_Factories;

import GA_Crossover.*;
import GA_Mutation.*;
import GA_Selection.*;

public class GAConfig implements GAFactory {

  // Return corresponeded object according to SELECTION
  /**
   * selectionChoice() will create a new class as per the mentioned type if
   * nothing is mentioned it takes the default choice that was given.
   *
   * @param selection
   * @return Selection
   */
  @Override
  public Selection selectionChoice(SELECTION selection) {
    if (selection == SELECTION.ELITE) {
      return new EliteSelection();
    } else if (selection == SELECTION.TWOFITTEST) {
      return new TwoFittest();
    } else {
      throw new IllegalArgumentException("Illegal Argument: " + selection.name());
    }
  }

  // Return corresponeded object according to CROSSOVER
  /**
   * 
   * crossoverChoice() will create a new class as per the mentioned type if
   * nothing is mentioned it takes the default choice that was given.
   *
   * @param crossover
   * @return Crossover
   */
  @Override
  public Crossover crossoverChoice(CROSSOVER crossover) {
    if (crossover == CROSSOVER.ONEPOINT) {
      return new OnePointCrossover();
    } else if (crossover == CROSSOVER.TWOPOINT) {
      return new TwoPointCrossover();
    } else {
      throw new IllegalArgumentException("Illegal Argument: " + crossover.name());
    }
  }

  /**
   * mutationChoice() decides the mutation choice based on the probabilty.
   *
   * @return Mutation
   */
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
