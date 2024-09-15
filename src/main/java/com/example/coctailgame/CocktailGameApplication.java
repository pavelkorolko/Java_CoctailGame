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
<<<<<<< HEAD
        int result = -1;
=======
        int result;
>>>>>>> b5c7482 (Amendmends for first commit)

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
<<<<<<< HEAD
=======
                scn.nextLine();
>>>>>>> b5c7482 (Amendmends for first commit)
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
<<<<<<< HEAD
        Set<String> uniqueDrinkNames = new HashSet<>();
        MenuData menuData = new MenuData();
        Language lang = Language.convert(result);
        menuData.setData(lang, attempts);
        menuData.initialize();
        System.out.println("first" + menuData.getScore());
=======

        Set<String> uniqueDrinkNames = new HashSet<>();
        Language lang = Language.convert(result);
        MenuData menuData = new MenuData(lang, attempts);
>>>>>>> b5c7482 (Amendmends for first commit)

        try {
            do {
                CocktailDB_API api = new CocktailDB_API();
                StringBuilder jsonResults = api.getContent();

                Root data = new Gson().fromJson(jsonResults.toString(), Root.class);
<<<<<<< HEAD
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
=======
                DrinkInfoManager drinkInfo = new DrinkInfoManager(data, lang);
                //-------------------------------------------------------------------
                System.out.println("\nPROMPT FOR EVALUATION: ");
                System.out.println(drinkInfo.getInitialDrinkName());
                //-------------------------------------------------------------------
                if (uniqueDrinkNames.contains(drinkInfo.getInitialDrinkName())) {
                    flag = false;
                } else {
                    uniqueDrinkNames.add(drinkInfo.getInitialDrinkName());
                    menuData.updateAttempts(attempts);
                    booleanOption = mainMenuLogic(drinkInfo, menuData);
>>>>>>> b5c7482 (Amendmends for first commit)

                    if (booleanOption.replyFromWinning) {
                        flag = false;
                    }
<<<<<<< HEAD

=======
>>>>>>> b5c7482 (Amendmends for first commit)
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

<<<<<<< HEAD
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
=======
    public static BooleanOption mainMenuLogic(DrinkInfoManager drinkInfo, MenuData menuData) {
        String drinkHiddenName = drinkInfo.getHiddenDrinkName();
        String drinkName = drinkInfo.getInitialDrinkName();
        menuData.promptMenu(drinkHiddenName, drinkInfo.getInstructions());

        BooleanOption opt = new BooleanOption();

        int attempts = menuData.getAttempts();
        boolean flag = false;
        String guessingOption = "";
        boolean skipOption = false;

        Scanner scn = new Scanner(System.in);

        if (drinkName.length() < attempts) {
>>>>>>> b5c7482 (Amendmends for first commit)
            attempts = drinkName.length();
        }

        try {
<<<<<<< HEAD
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
=======
            do {
                guessingOption = scn.nextLine();
                if (Helper.isNumeric(guessingOption) && guessingOption.length() < 2 && guessingOption.length() > 0) {
                    switch (guessingOption) {
                        case "1":
                            opt.replyFromMainMenu = true;
                            return opt;
                        case "2":
                            skipOption = true;
                            flag = true;
                            break;
                        case "3":
                            System.out.println(menuData.getData(20));
                            Thread.sleep(3000);
                            System.exit(0);
                            break;
                    }
                } else {
                    flag = menuData.isValidInputLength(guessingOption, drinkName);
                }
            } while (!flag);

            StringBuilder strHintsAppended = new StringBuilder();
            StringBuilder strRandomLettersPrompt = new StringBuilder(drinkHiddenName);

            if (skipOption) {
>>>>>>> b5c7482 (Amendmends for first commit)
                guessingOption = "2";
            }

            do {
                --attempts;
<<<<<<< HEAD
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
=======
                menuData.updateAttempts(attempts);

                if (!guessingOption.equals(drinkName) && attempts != 0) {
                    strHintsAppended.append(menuData.showHints(drinkInfo.getRandomDrink(), attempts));
                    strRandomLettersPrompt = drinkInfo.showRandomLetters(strRandomLettersPrompt);
                    if (!guessingOption.equals("2")) {
                        while (guessingOption.length() != drinkName.length()) {
                            System.out.println(menuData.getData(8));
                            System.out.print(menuData.getData(2));
                            guessingOption = scn.nextLine();
                        }
                        flag = false;
                        System.out.println("\n'" + strRandomLettersPrompt + "'");
                        System.out.println(menuData.getData(7));
                    } else {
                        System.out.println("\n'" + strRandomLettersPrompt + "'");
                        System.out.println(menuData.getData(18));
                        System.out.println(menuData.getData(22));
                        flag = false;
                    }

                    System.out.println(strHintsAppended);
                    System.out.println(menuData.getData(6));
                    System.out.println(menuData.getData(21));
                    System.out.print(menuData.getData(2));
                    guessingOption = scn.nextLine();
                } else if (guessingOption.equals(drinkName)) {

                    int score = attempts * 2;
                    menuData.updateScore(score);
>>>>>>> b5c7482 (Amendmends for first commit)

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
<<<<<<< HEAD
=======
                } else {
                    System.out.println(menuData.getData(16) + drinkName);
                    System.out.println(menuData.getData(5));
                    System.out.println(menuData.getData(14));
                    Thread.sleep(2000);
                    opt.replyFromMainMenu = true;
                    return opt;
>>>>>>> b5c7482 (Amendmends for first commit)
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

