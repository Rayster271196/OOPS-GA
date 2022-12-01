package GA_Factories;

import GA_Crossover.Crossover;
import GA_Mutation.Mutation;
import GA_Selection.Selection;

public interface GAFactory {

  enum SELECTION {
    ELITE,
    TWOFITTEST
  }

  enum CROSSOVER {
    ONEPOINT,
    TWOPOINT
  }

  enum MUTATION {
    INVERSION,
    SWAP
  }

  Selection selectionChoice(SELECTION selection);
  Crossover crossoverChoice(CROSSOVER crossover);
  Mutation mutationChoice();
}
