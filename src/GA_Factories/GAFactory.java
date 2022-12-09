package GA_Factories;

import GA_Crossover.Crossover;
import GA_Mutation.Mutation;
import GA_Selection.Selection;

/**
 * GAFactory is responsible for creation of Selection, Crossover, Mutation objects.
 */

public interface GAFactory {

  /*
   * Types of selections supported
   */
  enum SELECTION {
    ELITE,
    TWOFITTEST
  }

  /*
   * Types of crossovers supported
   */
  enum CROSSOVER {
    ONEPOINT,
    TWOPOINT
  }

  /*
   * Types of mutations supported
   */
  enum MUTATION {
    INVERSION,
    SWAP
  }

  /**
   * Decides the type of selection to be used.
   *
   * @param selection
   * @return Selection object
   */
  abstract Selection selectionChoice(SELECTION selection);

  /**
   * Decides the type of crossover to be used
   *
   * @param crossover
   * @return Crossover object
   */
  abstract Crossover crossoverChoice(CROSSOVER crossover);

  /**
   * Decides the type of Mutation to be used
   * @param mutation
   * @return Mutation object
   */
  abstract Mutation mutationChoice(MUTATION mutation);
}
