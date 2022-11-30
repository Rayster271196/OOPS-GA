package GA_Factories;

import GA_Crossover.Crossover;
// import GA_Main.Population;
import GA_Mutation.Mutation;
import GA_Selection.Selection;



public interface GAFactory{
    enum SELECTION{
        ELITE,
        TWOFITTEST
    }
    
    enum CROSSOVER{
        ONEPOINT,
        TWOPOINT
    }
    
    enum MUTATION{
        INVERSION,
        SWAP
    }

    Selection selectionChoice();
    Crossover crossoverChoice();
    Mutation mutationChoice();
}