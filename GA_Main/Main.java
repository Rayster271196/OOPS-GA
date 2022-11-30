package GA_Main;
import java.util.Random;

import GA_Selection.*;
import GA_Crossover.*;
import GA_Mutation.*;
import GA_Factories.*;

public class Main {
    public static void main(String[] args) {
        GeneticAlgorithm.run(GeneticAlgorithm.getInstance());
    }
}
