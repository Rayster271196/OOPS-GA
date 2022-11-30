package GA_Mutation;

public class MutationContext {
    /**
   * Context variable
   */
  // Default behaviour will use Inversion if not selection method is set.
  private Mutation mutation;

  public MutationContext(){
    setMutation(new Inversion());
  }

  public void setMutation(Mutation mutation) {
    System.out.println("Mutation method used is : "+mutation.getClass().getSimpleName());
    this.mutation = mutation;
  }

  public void executeStrategy() {
    mutation.mutation();
  }
}
