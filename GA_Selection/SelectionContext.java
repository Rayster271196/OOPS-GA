package GA_Selection;

// Context class for Selection interface and its implementation classes
// Hold Selection object's lifetime and manage it

/**
 * This is the class SelectionContext where we decide which selection choice should be used 
 */
public class SelectionContext {
// Context variable
  private Selection selection;
  
/**
 * This is the constructor for the class SelectionContext it will allocate a default selection method if nothing is passed
 * from the GeneticAlgorithm class.
 * the default selection method is EliteSelection.
 */
// Default behaviour will use EliteSelection if selection method is not set.
  public SelectionContext(){
    setSelection(new EliteSelection());
  }

/**
 * This is the method setSelection() which is responsible for determining the the selection method
 * and prints the name of the selection method used to the user.
 * 
 * @param selection
 */
  public void setSelection(Selection selection) {
    System.out.println("Selection method used is : "+selection.getClass().getSimpleName());
    this.selection = selection;
  }

/**
 * executeStrategy() : method that is responsible for calling the selection method so the population can be filtered.
 * 
 */
  public void executeStrategy() {
    selection.selection();
  }

}
