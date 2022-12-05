package GA_Factories;

import GA_Crossover.Crossover;
import GA_Mutation.Mutation;
import GA_Selection.Selection;

/**
 * This is the Genetic Algorithm factory which is responsible for what method to
 * be used for Selection, Crossover, Mutation.
 * This includes three methods where the type of process can be changed.
 * enumeration is done for the available choices.
 * 
 * @return sum of two operands
 */

// Interface for Abstractory Factory Pattern
public interface GAFactory {

  // Available choices for selection
  enum SELECTION {
    ELITE,
    TWOFITTEST
  }

  // Available choices for crossover
  enum CROSSOVER {
    ONEPOINT,
    TWOPOINT
  }

  // Available choices for mutation
  enum MUTATION {
    INVERSION,
    SWAP
  }

  /**
   * Decides the type of selection to be used.
   *
   * @param selection
   * @return Selection
   */
  abstract Selection selectionChoice(SELECTION selection);

  /**
   * Decides the type of crossover to be used
   *
   * @param crossover
   * @return Crossover
   */
  abstract Crossover crossoverChoice(CROSSOVER crossover);

  /**
   * Decides the type of Mutation to be used based on a probabilty value
   * 
   * @return Mutation
   */
  abstract Mutation mutationChoice();
}
