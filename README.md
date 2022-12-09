# OOPS-GA
This is the group project submitted by: 
1. 22251833 Rayster Fernandes 
2. 22251836 Savio Fernandes
3. 21250188 Soorya
4. 21250758 Qing Liu

This program exctues the basic working of a Genetic Algorithm.
The idea of a GA is:
1. Create an intial population
2. Evaluate the individuals of population (i.e calcluate the fitness)
3. Select indiviuals for mating by using a selection method
4. Mate the selected individuals by using a suitable crossover method.
5. Apply mutation to the select individuals
6. Check if the genes if converted to all 1's (the stopping condition by getting the max fitness with all genes as 1's)
7. Stop if criteria is satisfied or repeat steps 2-6 again untill criteria is satisfied.

Below is the sample output:

Default parameters:
Selection method : EliteSelection   
Crossover method : OnePointCrossover
Mutation method : Inversion
****************************************************************************************************
Starting Genetic Algorithm.....

Enter gene length:
10
Enter size of population: 
250

New Parameters used :
Selection method : TwoFittest
Crossover method : TwoPointCrossover
Mutation method : Inversion


Generation: 0 Fittest: 9
Mutating.....
Generation: 1 Fittest: 9
Generation: 2 Fittest: 10

Solution found in generation 2
Fitness: 10
Genes: 1111111111
****************************************************************************************************

The explanation of the sample o/p:
First thing that occurs is the creation of the instance of Genetic Algorithm, where the default selection, crossover, mutation methods are intialised.
Then the the gentic algorithm then proceeds to tell the user to enter the gene length, then the size of the population.
With the intialized parameters, a config file is intialized with new methods for selection, crossover, mutation methods. The used method can be changed in the GeneticAlgorithm.java file as per the user needs. 
Then the calculation is carried forward where it uses the given mehtods for the selection, crossover, mutation. With each completed cycle the generation and the fittest in the 
population is displayed. 
When the solution is found which is the max fitness the program displays the genes of that individual and tells in which generation it was found. 

*****************************************************************************************************
This program was designed around the core of GA and also the patterns and concepts that was thought in the CS613 class.

Firstly, the eager implementation of the Singleton pattern is used in the Genetic Algorithm class this makes sure that there is only one given instance of the GAclass and also making it thread-safe.

Then abstract factory method is used as the GAFactory interface which has abstract methods such as selectionChoice, crossoverChoice, mutationChoice which are the deciding methods for which choosing what should be used for that instance of the program. Enumeration is aslo used for denoting what is the type of process that is used in each of the methods such as ELITE, TWOFITTEST, ONEPOINT, TWOPOINT, INVERSION,SWAP. the subclasses of GAFactory which the is the GAConfig class decides before hand what should be used this can be further extended with changing the choices of the selction, crossover, mutation as needed by creating a another config file using the methods in GAFactory. the config file has a default method which will be selected.

Next we have the implemented Strategy Method Pattern which is used to implement the various methods 
(i.e) Selection, Crossover, Mutation. Each of the methods are interfaces themselves which is then implemented as different verison of the methods that can be used. In each process we have two different methods such as Selection has Elite and TwoFittst which are concrete implementation of the selection methods. 

Mutation is also done by using a random probability between the two mutation methods Inversion and SwapMutation. 
Encapsulation is done in the places where it is neccessary by using getters and setters to access the variables if needed in any other modules.
Data Abstraction is implemented throught the program by ensuring that the given module performs its own function.
Open-Close principle is ensurd in the program where the configuration of the GA can be modifed by changing the subclasses and not the superclass itself. 
Generics is used in the class Individual<T extends Integer> for when the population is created it can be created by using any suitable type of collections. The use of generics here allow the user to populate the population by using any suitable collections type of integer. In this case we have choosen ArrayList. 
the process such as Selection, Crossover, Mutation work on the population. this enables the user to change the logic of the program by altering the method used and work on population. 
The code is properly packaged as per the methods, the gentic algorithm and the runner. Import statments will be use when neccessary to use the revlevant packages.
Error handling is also done to ensure that the wrong paramenters will not be passed. 

*****************************************************************************************************
At the last step, we also have done enough times tests to this program, as software testing identifies bugs and issues in the development process 
so they're fixed prior to product launch. Also this approach ensures that quality program is delivered, which in turn meets project requirements  
and specification.