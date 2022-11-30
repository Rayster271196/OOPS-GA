package GA_Factories;

import GA_Crossover.*;
import GA_Main.Population;
import GA_Mutation.*;
import GA_Selection.*;

public class GAConfigOne implements GAFactory {

  @Override
  public Selection selectionChoice(String type) {
    if (type.equals("elite")) {
      return new EliteSelection();
    } else if (type.equals("twoFittest")) {
      return new TwoFittest();
    } else {
      throw new IllegalArgumentException(
        "Illegal argument" + type + "Use elite or twoFittest"
      );
    }
  }

  @Override
  public Crossover crossoverChoice(String type) {
    if (type.equals("onePoint")) {
      return new OnePointCrossover();
    } else if (type.equals("twoPoint")) {
      return new TwoPointCrossover();
    } else {
      throw new IllegalArgumentException(
        "Illegal argument" + type + "Use onePoint or twoPoint"
      );
    }
  }

  @Override
  public Mutation mutationChoice(String type) {
    double num = Math.random() * 2;
    if (num <= 0.2) {
      return new Inversion();
    } else {
      return new SwapMutation();
    }
  }
}
