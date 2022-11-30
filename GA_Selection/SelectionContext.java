package GA_Selection;

public class SelectionContext {
  /**
   * Context variable
   */
  // Default behaviour will use EliteSelection if not selection method is set.
  private Selection selection;

  public SelectionContext(){
    setSelection(new EliteSelection());
  }

  public void setSelection(Selection selection) {
    System.out.println("Selection method used is : "+selection.getClass().getSimpleName());
    this.selection = selection;
  }

  public void executeStrategy() {
    selection.selection();
  }

}
