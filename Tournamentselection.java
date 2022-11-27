import java.util.Random;

public class Tournament implements Selection {

    public Individual selection() {
        Population pop = new Population();
        Individual x;
        Individual best;
        Random r = new Random();
        best = pop.getFittest();

        int size = 10;
        int index = r.nextInt(size);

        for (int i = 0; i < size; i++) {
            x = pop.individuals.get(index);
            x.calcFitness();
            if ((best == null) || (x.fitness > best.fitness)) {
                best = x;
            }
        }
        return best;

    }

}
