package GA_Factories;

import GA_Crossover.Crossover;
import GA_Main.Population;
import GA_Mutation.Mutation;
import GA_Selection.Selection;

public interface GAFactory{

    Selection selectionChoice(String type);
    Crossover crossoverChoice(String type);
    Mutation mutationChoice(String type);
}