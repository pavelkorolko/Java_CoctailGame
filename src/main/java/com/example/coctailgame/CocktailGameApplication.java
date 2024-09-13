package com.example.coctailgame;

import API.CocktailDB_API;
import Models.*;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class CocktailGameApplication {

    public static void main(String[] args) {

        SpringApplication.run(CocktailGameApplication.class, args);
        startGame();
    }

    public static void startGame() {
        Scanner scn = new Scanner(System.in);
        boolean flag;
        int result = -1;

        do {
            System.out.println("\nWelcome to CocktailGame!");
            System.out.println("Choose language for begin!");
            System.out.println("'EN' ---> Press button 1");
            System.out.println("'DE' ---> Press button 2");
            System.out.println("'IT' ---> Press button 3");
            System.out.println("'Exit' ---> Press button 4");

            System.out.print("Input: ");

            if (!scn.hasNextInt()) {
                System.out.println("Input incorrect! Try once more!");
                flag = false;
                scn.next();
            } else {
                result = scn.nextInt();
                if (result == 4) {
                    System.out.println("See you again!");
                    System.exit(0);
                }
                if (result > 3 || result < 0) {
                    System.out.println("Input incorrect! Try once more!");
                    flag = false;
                } else {
                    flag = apiConnectionLogic(result);
                }
            }
        } while (!flag);
    }

    public static boolean apiConnectionLogic(int result) {
        int attempts = 5;
        boolean flag = true;
        BooleanOption booleanOption;
        Set<String> uniqueDrinkNames = new HashSet<>();
        MenuData menuData = new MenuData();
        Language lang = Language.convert(result);
        menuData.setData(lang, attempts);
        menuData.initialize();
        System.out.println("first" + menuData.getScore());

        try {
            do {
                CocktailDB_API api = new CocktailDB_API();
                StringBuilder jsonResults = api.getContent();

                Root data = new Gson().fromJson(jsonResults.toString(), Root.class);
                Drink randomDrink = data.drinks.get(0);

                String instructions = randomDrink.getInstructions(lang);
                String drinkName = randomDrink.getDrinkName();
                System.out.println(drinkName);
                if (uniqueDrinkNames.contains(drinkName)) {
                    flag = false;
                } else {
                    uniqueDrinkNames.add(drinkName);
                    menuData.setAttempts(attempts);
                    booleanOption = mainMenuLogic(drinkName, randomDrink, instructions, menuData, attempts);
                    System.out.println("Last: " + menuData.getScore());

                    if (booleanOption.replyFromWinning) {
                        flag = false;
                    }

                    if (booleanOption.replyFromMainMenu) {
                        return false;
                    }
                }
            } while (!flag);

        } catch (IOException e) {
            System.out.println(menuData.getData(9));
        }
        return true;
    }

    public static String setDrinkNameErase(String name) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            str.append("_");
        }
        return str.toString();
    }

    public static StringBuilder showRandomLetters(StringBuilder str, String actualWord) {
        Random rnd = new Random();

        while (true) {
            int randomIndex = rnd.nextInt(actualWord.length());

            if (str.charAt(randomIndex) == '_') {
                str.setCharAt(randomIndex, actualWord.charAt(randomIndex));
                break;
            }
        }

        return str;
    }

    public static boolean isInputLengthValid(MenuData menuData, String guessWord, String actualWord) {
        if (guessWord.length() != actualWord.length()) {
            System.out.println(menuData.getData(8));
            System.out.print(menuData.getData(2));
            return true;
        } else {
            return false;
        }
    }

    public static String hintsShow(MenuData menu, Drink currentDrink, int attempts) {
        StringBuilder str = new StringBuilder();

        switch (attempts) {
            case 4:
                str.append(menu.getData(11) + currentDrink.strCategory + ". ");
                break;
            case 3:
                str.append(menu.getData(12) + currentDrink.strAlcoholic + ". ");
                break;
            case 2:
                str.append(menu.getData(13) + currentDrink.strGlass + ". ");
                break;
        }

        return str.toString();
    }

    public static BooleanOption mainMenuLogic(String drinkName, Drink randomDrink,
                                              String instructions, MenuData menuData, int attempts) {
        BooleanOption opt = new BooleanOption();
        boolean flag = true;
        String guessingOption = "";
        boolean clickedOption_2 = false;

        if (drinkName.length() < 5) {
            attempts = drinkName.length();
        }

        try {
            String hiddenName = setDrinkNameErase(drinkName);
            menuData.promptMenu(hiddenName, instructions);
            Scanner scn = new Scanner(System.in);

            do {
                if (scn.hasNextInt()) {
                    int option = scn.nextInt();
                    scn.nextLine();
                    if (option == 1) {
                        opt.replyFromMainMenu = true;
                        return opt;
                    } else if (option == 2) {
                        System.out.println(menuData.getData(18));
                        clickedOption_2 = true;
                        flag = false;
                    } else {
                        System.out.println(menuData.getData(15));
                        System.out.print(menuData.getData(2));
                    }
                } else {
                    guessingOption = scn.nextLine();
                    flag = isInputLengthValid(menuData, guessingOption, drinkName);
                }
            } while (flag);

            StringBuilder str = new StringBuilder();
            StringBuilder strWord = new StringBuilder(hiddenName);

            if (clickedOption_2) {
                guessingOption = "2";
            }

            do {
                --attempts;
                if (attempts == 0) {
                    System.out.println(menuData.getData(16) + drinkName);
                    System.out.println(menuData.getData(5));
                    System.out.println(menuData.getData(14));
                    Thread.sleep(2000);
                    opt.replyFromMainMenu = true;
                    return opt;
                }
                flag = true;

                if (!guessingOption.equals(drinkName)) {
                    flag = false;
                    menuData.updateData(attempts, 0);
                    System.out.println(menuData.getData(7));
                    str.append(hintsShow(menuData, randomDrink, attempts));
                    System.out.println(str);
                    strWord = showRandomLetters(strWord, drinkName);
                    System.out.println("\n'" + strWord + "'");
                    System.out.println(menuData.getData(6));
                    System.out.print(menuData.getData(2));
                    guessingOption = scn.nextLine();

                    if (!guessingOption.equals("2")) {
                        while (guessingOption.length() != drinkName.length()) {
                            System.out.println(menuData.getData(8));
                            System.out.println(menuData.getData(6));
                            System.out.print(menuData.getData(2));
                            guessingOption = scn.nextLine();
                        }
                    } else {
                        flag = false;
                    }
                } else {
                    int score = attempts * 2;
                    menuData.setScore(score);

                    System.out.println("\n");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println(menuData.getData(17));
                    System.out.println(menuData.getData(5));
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println(menuData.getData(19));
                    System.out.println("\n");
                    Thread.sleep(2000);
                    opt.replyFromWinning = true;
                    return opt;
                }
            } while (!flag);

        } catch (NullPointerException | IllegalArgumentException | InterruptedException e) {
            if (e instanceof NullPointerException) {
                System.out.println(menuData.getData(10));
            } else if (e instanceof IllegalArgumentException) {
                System.out.println(e.getMessage());
            } else if (e instanceof InterruptedException) {
                System.out.println(e.getMessage());
            }
        }
        opt.replyFromMainMenu = false;
        return opt;
    }
}

