public class PopulationFactory implements AbstractFactory<PopulationInterface> {

    @Override
    public PopulationInterface create(String type) {
        if ("Fitness".equalsIgnoreCase(type)) {
            return new PopulationByFitness();
        } 
		//else if ("GenLength".equalsIgnoreCase(type)) {
        //    return new PopulationByGenLength();
        //}

        return null;
    }

}