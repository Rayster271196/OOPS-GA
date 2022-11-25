import java.util.ArrayList;

public interface PopulationInterface {
	public ArrayList<Individual> individuals = new ArrayList<Individual>();
    public void initializePopulation(int size)();
}