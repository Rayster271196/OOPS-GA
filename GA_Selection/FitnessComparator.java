package GA_Selection;

import java.util.*;
import GA_Main.Individual;

public class FitnessComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Individual individualOne = (Individual) o1;
        Individual individualTwo = (Individual) o2;

        if (individualOne.fitness == individualTwo.fitness) {
            return 0;
        } else if (individualOne.fitness < individualTwo.fitness) {
            return 1;
        } else {
            return -1;
        }
    }
}