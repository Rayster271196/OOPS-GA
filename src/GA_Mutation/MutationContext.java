package GA_Mutation;

// Context class for Mutation interface and its implementation classes. Hold Mutation object's lifetime and manage it
// MutationContext class is the class where the context of the Mutation is tracked.

public class MutationContext {
// Context variable
  private Mutation mutation;
  
/**
 * This is the constructor for the class MutationContext it will allocate a default mutation method if nothing is passed
 * from the GeneticAlgorithm class.
 * The default mutation method is Inversion.
 */
  public MutationContext(){
    setMutation(new Inversion());
  }

/**
 * This is the method setMutation() which is responsible for setting the mutation method
 * selected by the user.
 * 
 * @param mutation
 */
  public void setMutation(Mutation mutation) {
    this.mutation = mutation;
  }

/**
 * executeStrategy() : method that is responsible for invoking the selected mutation method so the population can be mutated.
 * 
 */  
  public void executeStrategy() {
    mutation.mutation();
  }

  /*
   * toString method for MutationContext class
   */
  @Override
  public String toString() {
      return "Mutation method : "+mutation.getClass().getSimpleName();
  }
}
