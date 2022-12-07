package GA_Factories;

import GA_Crossover.*;
import GA_Mutation.*;
import GA_Selection.*;

public class GAConfig implements GAFactory {

  /**
   * selectionChoice() will create a new class as per the mentioned type if
   * nothing is mentioned it takes the default choice that was given.
   *
   * @param selection
   * @return corresponeded object according to SELECTION
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

  /**
   * 
   * crossoverChoice() will create a new class as per the mentioned type if
   * nothing is mentioned it takes the default choice that was given.
   *
   * @param crossover
   * @return corresponeded object according to CROSSOVER
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
   * 
   * mutationChoice() will create a new class as per the requested mutation type,
   * if incorrect mutation is passed IllegalArgumentException will be thrown.
   * 
   * mutationChoice() decides the mutation choice based on the probabilty.
   *@param mutation
   * @return corresponeded object according to Mutation
   */
  @Override
  public Mutation mutationChoice(MUTATION mutation) {
    if (mutation == MUTATION.INVERSION) {
      return new Inversion();
    } else if (mutation == MUTATION.SWAP) {
      return new SwapMutation();
    } else {
      throw new IllegalArgumentException("Illegal Argument: " + mutation.name());
    }
  }
}
