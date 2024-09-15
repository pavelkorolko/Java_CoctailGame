package Models;

import java.util.Random;

public class DrinkInfoManager {
    private Root rootData;
    Drink randomDrink;
    private String initialDrinkName;
    private String hiddenDrinkName;
    private String  instructions;

    public DrinkInfoManager(Root data, Language lang){
        this.rootData = data;
        randomDrink = data.drinks.get(0);
        instructions = randomDrink.getInstructions(lang);
        initialDrinkName = randomDrink.getInitialDrinkName();
        hiddenDrinkName = hideInitialDrinkName();
    }

    public Drink getRandomDrink(){return randomDrink;}

    public String getInitialDrinkName() {
        return initialDrinkName;
    }

    public String getHiddenDrinkName() {
        return hiddenDrinkName;
    }

    public String getInstructions() {
        return instructions;
    }

    public StringBuilder showRandomLetters(StringBuilder str) {
        Random rnd = new Random();

        while (true) {
            int randomIndex = rnd.nextInt(initialDrinkName.length());

            if (str.charAt(randomIndex) == '_') {
                str.setCharAt(randomIndex, initialDrinkName.charAt(randomIndex));
                break;
            }
        }

        return str;
    }

    private String hideInitialDrinkName() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < initialDrinkName.length(); i++) {
            str.append("_");
        }
        return str.toString();
    }
}
