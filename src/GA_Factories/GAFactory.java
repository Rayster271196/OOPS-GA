package GA_Factories;

import GA_Crossover.Crossover;
import GA_Mutation.Mutation;
import GA_Selection.Selection;

/**
 * * This is the interface for Factory. It is implemented by GAConfig class.
 * GAFactory is responsible for creation of Selection, Crossover, Mutation objects.
 * Here Abstract Factory Pattern is implementeted with this being the Factory interface and GAConfig being the concrete class
 */

public interface GAFactory {

  /*
   * This is an ENUM for the types of selections supported
   * Here we demonstrate the use of enums to achieve type safety
   * In our case we implement Elite Selection and TwoFittest Selection
   */
  enum SELECTION {
    ELITE,
    TWOFITTEST
  }

  /*
   * This is an ENUM for the types of crossovers supported
   * In our case we implement OnePoint crossover and TwoPoint crossover
   */
  enum CROSSOVER {
    ONEPOINT,
    TWOPOINT
  }

  /*
   * This is an ENUM for the types of Mutations supported
   * In our case we implement Inversion mutation and Swap mutation
   */
  enum MUTATION {
    INVERSION,
    SWAP
  }

  /**
   * selectionChoice() : abstract method to set the Selection type 
   * during Runtime
   *
   * @param selection
   * @return Selection object
   */
  abstract Selection selectionChoice(SELECTION selection);

  /**
   * crossoverChoice() : abstract method to set the Crossover type 
   * During Runtime
   *
   * @param crossover
   * @return Crossover object
   */
  abstract Crossover crossoverChoice(CROSSOVER crossover);

  /**
   * mutationChoice() : abstract method to set the Mutation type 
   * During Runtime
   * @param mutation
   * @return Mutation object
   */
  abstract Mutation mutationChoice(MUTATION mutation);
}
