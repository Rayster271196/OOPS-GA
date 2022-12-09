package GA_Selection;

/* 
 * Context class for Selection interface and its implementation classes, hold Selection object's lifetime and manage it
 * SelectionContext class is the class where the context of the Selection is tracked.
*/ 


public class SelectionContext {
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
   * Overriding toString method for SelectionContext class
   * Prints out the class chosen for selection
   */
  @Override
  public String toString() {
      return "Selection method : "+selection.getClass().getSimpleName();
  }

}
