package GA_Selection;

import GA_Runner.GeneticAlgorithm;

/**
 * This is the interface for Selection. It has two subclasses Elite selection and TwoFittest selection.
 * Uses the instance that was previously created by the GeneticAlgortithm class
 * selection() : method that is used to define the selection type as per the subclass.
 * Here Strategy Pattern is implemented with this being the interface and EliteSelection, TwoFittest being the modified as per the functionality using method selection().
 * 
 */
public interface Selection {
    public GeneticAlgorithm demo = GeneticAlgorithm.getInstance();
    public void selection();
}
