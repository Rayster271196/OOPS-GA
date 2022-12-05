package GA_Mutation;

// Context class for Mutation interface and its implementation classes
// Hold Mutation object's lifetime and manage it

/**
 * This is the class MutationContext where we decide which mutation choice should be used.
 */
public class MutationContext {
// Context variable
  private Mutation mutation;
  
/**
 * This is the constructor for the class MutationContext it will allocate a default mutation method if nothing is passed
 * from the GeneticAlgorithm class.
 * The default mutation method is Inversion.
 */
// Default behaviour will use Inversion if mutation method is not set.
  public MutationContext(){
    setMutation(new Inversion());
  }

/**
 * This is the method setMutation() which is responsible for determining the the mutation method
 * and prints the name of the mutation method used to the user.
 * 
 * @param mutation
 */
  public void setMutation(Mutation mutation) {
    System.out.println("Mutation method used is : "+mutation.getClass().getSimpleName());
    this.mutation = mutation;
  }

/**
 * executeStrategy() : method that is responsible for calling the mutation method so the population can be mutated.
 * 
 */  
  public void executeStrategy() {
    mutation.mutation();
  }
}
