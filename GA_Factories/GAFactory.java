package GA_Factories;

import GA_Crossover.Crossover;
import GA_Mutation.Mutation;
import GA_Selection.Selection;

//Interface for Abstractory Factory Pattern
public interface GAFactory {

  //Available choices for selection
  enum SELECTION {
    ELITE,
    TWOFITTEST
  }
  
  //Available choices for crossover
  enum CROSSOVER {
    ONEPOINT,
    TWOPOINT
  }

  //Available choices for mutation
  enum MUTATION {
    INVERSION,
    SWAP
  }

  abstract Selection selectionChoice(SELECTION selection);
  abstract Crossover crossoverChoice(CROSSOVER crossover);
  abstract Mutation mutationChoice();
}
