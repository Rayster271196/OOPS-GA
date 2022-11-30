package GA_Selection;

public class SelectionContext {
  /**
   * Context variable
   */
  private Selection selection;

  public void setSelection(Selection selection) {
    this.selection = selection;
  }

  public void executeStrategy() {
    selection.selection();
  }
}
