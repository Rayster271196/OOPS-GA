public class Uniformcrossover implements Crossover {
    @Override
    public void crossover() {
        System.out.println("Assessing the gene and randomly selecting the genes for the child ");
        System.out.println("Using java.util.Random for select the genes from the parents");
        System.out.println("Making sure illegal offsprings are not generated");
        System.out.println("Cross over completed");
    }
}
