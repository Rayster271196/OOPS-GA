package GA_Selection;

import java.util.ArrayList;

import GA_Main.GeneticAlgorithm;
import GA_Main.Individual;

//import GA_Main.Individual;

public interface Selection {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    // static public Individual fittest = new Individual();
    // static public Individual secondFittest = new Individual();
    public ArrayList<Individual> selection();
}
