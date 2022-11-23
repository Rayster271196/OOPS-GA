public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){
        
        if("Population".equalsIgnoreCase(choice)){
            return new PopulationFactory();
        }
        //else if("Individual".equalsIgnoreCase(choice)){
        //    return new IndividualFactory();
        //}
        
        return null;
    }
}