package GA_Selection;

import java.util.*;
// import java.io.*;
// import GA_Main.*;

import GA_Main.Individual;

public class EliteSelection implements Selection {
    public ArrayList<Individual> selection() {
        ArrayList<Individual> selected = new ArrayList<Individual>();
        Collections.sort(demo.population.individuals, new FitnessComparator());

        Random rn = new Random();
        int randomIndexOne = rn.nextInt(10);
        int randomIndexTwo = rn.nextInt(10);
        if (randomIndexOne == randomIndexTwo) {
            randomIndexOne++;
            randomIndexOne = randomIndexOne % 10;
        }

        selected.add(demo.population.individuals.get(randomIndexOne));
        selected.add(demo.population.individuals.get(randomIndexTwo));

        return selected;
    }
    // private Individual fittest;
    // private Individual secondFittest;
    // GeneticAlgorithm demo = GeneticAlgorithm.getInstance();

    // public Individual getFittest() {
    // return fittest;
    // }

    // public void setFittest(Individual fittest) {
    // fittest = demo.population.getFittest();
    // }

    // public Individual getSecondFittest() {
    // return secondFittest;
    // }

    // public void setSecondFittest(Individual secondFittest) {
    // secondFittest = demo.population.getSecondFittest();
    // }

    // public EliteSelection() {
    // selection();
    // }

    // public void selection() {
    // setFittest(fittest);
    // setSecondFittest(secondFittest);
    // }

}
