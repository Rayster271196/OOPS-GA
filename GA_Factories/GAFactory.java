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

  Selection selectionChoice(SELECTION selection);
  Crossover crossoverChoice(CROSSOVER crossover);
  Mutation mutationChoice();
}
