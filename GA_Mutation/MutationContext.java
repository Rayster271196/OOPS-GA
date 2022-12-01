package GA_Mutation;

public class MutationContext {
   // Context variable
  private Mutation mutation;
  
  // Default behaviour will use Inversion if mutation method is not set.
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
