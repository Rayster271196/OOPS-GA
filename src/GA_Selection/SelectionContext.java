package GA_Selection;

// Context class for Selection interface and its implementation classes
// Hold Selection object's lifetime and manage it
public class SelectionContext {
  // Context variable
  private Selection selection;
  
  /**
   * This is the constructor for the class SelectionContext it will allocate a default selection method if nothing is passed
   * from the GeneticAlgorithm class.
   * the default selection method is EliteSelection.
   */
  public SelectionContext(){
    setSelection(new EliteSelection());
  }

  /**
   * This is the method setSelection() which is responsible for setting the selection method
   * selected by the user.
   * 
   * @param selection
   */
  public void setSelection(Selection selection) {
    this.selection = selection;
  }

  /**
   * executeStrategy() : method that is responsible for calling the selection method so the population can be filtered.
   * 
   */
  public void executeStrategy() {
    selection.selection();
  }

  /*
   * toString method for SelectionContext class
   */
  @Override
  public String toString() {
      return "Selection method : "+selection.getClass().getSimpleName();
  }

}
