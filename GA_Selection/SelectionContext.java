package GA_Selection;

public class SelectionContext {
  // Context variable
  private Selection selection;
  
  // Default behaviour will use EliteSelection if selection method is not set.
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