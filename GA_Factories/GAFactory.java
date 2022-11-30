package GA_Factories;

import GA_Crossover.Crossover;
// import GA_Main.Population;
import GA_Mutation.Mutation;
import GA_Selection.Selection;
import GA_Selection.SelectionContext;

public interface GAFactory {
  SelectionContext selctionContext = new SelectionContext();

  enum SELECTION {
    ELITE,
    TWOFITTEST,
  }

  enum CROSSOVER {
    ONEPOINT,
    TWOPOINT,
  }

  enum MUTATION {
    INVERSION,
    SWAP,
  }

  Selection selectionChoice(SELECTION selection);
  Crossover crossoverChoice();
  Mutation mutationChoice();
}
