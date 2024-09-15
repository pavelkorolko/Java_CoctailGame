package Models;

public class MenuData {
<<<<<<< HEAD
    private StringBuilder menu;
=======
    private String[] menu;
>>>>>>> b5c7482 (Amendmends for first commit)
    private int attempts;
    private int score = 0;
    private Language lang;

<<<<<<< HEAD
    public MenuData() {
        menu = new StringBuilder();
    }

    public void setData(Language lang, int attempts) {
        this.attempts = attempts;
        this.lang = lang;
    }

    public int getScore(){
        return score;
    }

    public void setAttempts(int attempts){
        this.attempts = attempts;
    }

    public void setScore(int score) {
        this.score = score;
        updateData(attempts, score);
    }

    public void initialize() {
        switch (this.lang) {
            case IT:
                menu.append("Puoi indovinare il nome della bevanda?;");
                menu.append("Ecco la descrizione di esso:;");
                menu.append("Inserimento: ;");
                menu.append("'Torna al menu principale' ---> Premi il tasto 1;");
                menu.append("Hai " + this.attempts + " tentativi!;");
                menu.append("Il tuo punteggio attuale: " + this.score + "!;");
                menu.append("'Salta' ---> Premi il tasto 2;");
                menu.append("Purtroppo ti sbagli. Prova di nuovo! Tentativi rimasti: " + this.attempts + ". Ecco alcuni suggerimenti:;");
                menu.append("La lunghezza della parola non corrisponde a quella nascosta! Riprova!;");
                menu.append("Problemi di connessione! Riprova più tardi!;");
                menu.append("Errore interno del server!;");
                menu.append("Categoria: ;");
                menu.append("Tipo: ;");
                menu.append("Servito con: ;");
                menu.append("Hai perso! Reindirizzamento al menu principale...;");
                menu.append("Inserimento non valido! Riprova!;");
                menu.append("Risposta corretta: ;");
                menu.append("Hai vinto!;");
                menu.append("Abbiamo detto che non hai inserito un valore!");
                menu.append("Reindirizzamento...;");
                break;
            case DE:
                menu.append("Kannst du den Namen des Cocktails erraten?;");
                menu.append("Hier ist die Beschreibung davon:;");
                menu.append("Eingabe: ;");
                menu.append("'Zurück zum Hauptmenü' ---> Drücken Sie die Taste 1;");
                menu.append("Du hast " + this.attempts + " Versuche!;");
                menu.append("Dein aktueller Punktestand: " + this.score + "!;");
                menu.append("'Überspringen' ---> Drücken Sie die Taste 2;");
                menu.append("Leider liegst du falsch. Versuche es noch einmal! Verbleibende Versuche: " + this.attempts + ". Hier sind einige Hinweise:;");
                menu.append("Die Länge des Wortes stimmt nicht mit dem verborgenen überein! Versuche es noch einmal!;");
                menu.append("Verbindungsprobleme! Versuchen Sie es später noch einmal!;");
                menu.append("Interner Serverfehler!;");
                menu.append("Kategorie: ;");
                menu.append("Art: ;");
                menu.append("Serviert mit: ;");
                menu.append("Du hast verloren! Zurück zum Hauptmenü...;");
                menu.append("Ungültige Eingabe! Versuche es noch einmal!;");
                menu.append("Richtige Antwort: ;");
                menu.append("Du hast gewonnen!;");
                menu.append("Wir haben gesagt, dass du keinen Wert eingegeben hast!");
                menu.append("Weiterleitung...;");
                break;
            default:
                menu.append("Can you guess the name of the cocktail?;");
                menu.append("Here is the description of it:;");
                menu.append("Input: ;");
                menu.append("'Back to main menu' ---> Press button 1;");
                menu.append("You have " + this.attempts + " attempts!;");
                menu.append("Your current score: " + this.score + "!;");
                menu.append("'Skip' ---> Press button 2;");
                menu.append("Unfortunately you are wrong. Try once more! Remained attempts: " + this.attempts + ". Here are some hints:;");
                menu.append("The length of word is not the same with hidden one! Try once more!;");
                menu.append("Connectivity problems! Try later!;");
                menu.append("Internal server error!;");
                menu.append("Category: ;");
                menu.append("Type: ;");
                menu.append("Served with: ;");
                menu.append("You lost! Redirecting to main menu...;");
                menu.append("Invalid input! Try once more!;");
                menu.append("Right answer: ;");
                menu.append("You won!;");
                menu.append("We sad you have not entered value!;");
                menu.append("Redirecting...;");
                break;
=======
    public MenuData(Language lang, int attempts) {
        this.attempts = attempts;
        this.lang = lang;

        initialize();
    }

    public int getAttempts() {
        return this.attempts;
    }

    private void initialize() {
        switch (this.lang) {
            case IT:
                menu = new String[]{
                        "Puoi indovinare il nome della bevanda?",
                        "Ecco la descrizione di esso:",
                        "Inserimento: ",
                        "'Torna al menu principale' ---> Premi il tasto 1",
                        "Hai " + this.attempts + " tentativi!",
                        "Il tuo punteggio attuale: " + this.score + "!",
                        "'Salta' ---> Premi il tasto 2",
                        "Purtroppo ti sbagli. Prova di nuovo! Tentativi rimasti: " + this.attempts + ". Ecco alcuni suggerimenti:",
                        "La lunghezza della parola non corrisponde a quella nascosta! Riprova!",
                        "Problemi di connessione! Riprova più tardi!",
                        "Errore interno del server!",
                        "Categoria: ",
                        "Tipo: ",
                        "Servito con: ",
                        "Hai perso! Reindirizzamento al menu principale...",
                        "Inserimento non valido! Riprova!",
                        "Risposta corretta: ",
                        "Hai vinto!",
                        "Abbiamo detto che non hai inserito un valore!",
                        "Reindirizzamento...",
                        "Terminando il gioco... Si prega di attendere...",
                        "'Esci' ---> Premi il tasto 3",
                        "Tentativi rimasti: " + this.attempts + "! Ecco alcuni suggerimenti:"
                };
                break;
            case DE:

                menu = new String[]{
                        "Kannst du den Namen des Cocktails erraten?",
                        "Hier ist die Beschreibung davon:",
                        "Eingabe: ",
                        "'Zurück zum Hauptmenü' ---> Drücken Sie die Taste 1",
                        "Du hast " + this.attempts + " Versuche!",
                        "Dein aktueller Punktestand: " + this.score + "!",
                        "'Überspringen' ---> Drücken Sie die Taste 2",
                        "Leider liegst du falsch. Versuche es noch einmal! Verbleibende Versuche: " + this.attempts + ". Hier sind einige Hinweise:",
                        "Die Länge des Wortes stimmt nicht mit dem verborgenen überein! Versuche es noch einmal!",
                        "Verbindungsprobleme! Versuchen Sie es später noch einmal!",
                        "Interner Serverfehler!",
                        "Kategorie: ",
                        "Art: ",
                        "Serviert mit: ",
                        "Du hast verloren! Zurück zum Hauptmenü...",
                        "Ungültige Eingabe! Versuche es noch einmal!",
                        "Richtige Antwort: ",
                        "Du hast gewonnen!",
                        "Wir haben gesagt, dass du keinen Wert eingegeben hast!",
                        "Weiterleitung...",
                        "Das Spiel wird beendet... Bitte warten...",
                        "'Beenden' ---> Drücken Sie die Taste 3",
                        "Verbleibende Versuche: " + this.attempts + "! Hier sind einige Hinweise:"
                };

                break;
            default:
                menu = new String[]{
                        "Can you guess the name of the cocktail?",
                        "Here is the description of it:",
                        "Input: ",
                        "'Back to main menu' ---> Press button 1",
                        "You have " + this.attempts + "attempts!",
                        "Your current score: " + this.score + "!",
                        "'Skip' ---> Press button 2",
                        "Unfortunately you are wrong. Try once more! Remained attempts: " + this.attempts + ". Here are some hints:",
                        "The length of word is not the same with hidden one! Try once more!",
                        "Connectivity problems! Try later!",
                        "Internal server error!",
                        "Category: ",
                        "Type: ",
                        "Served with: ",
                        "You lost! Redirecting to main menu...",
                        "Invalid input! Try once more!",
                        "Right answer: ",
                        "You won!",
                        "We sad you have not entered value!",
                        "Redirecting...",
                        "Terminating the game...Please wait...",
                        "'Exit' ---> Press button 3",
                        "Remained attempts " + this.attempts + "! Here are some hints:"
                };
>>>>>>> b5c7482 (Amendmends for first commit)
        }
    }

    public String getData(int index) {
<<<<<<< HEAD
        String[] content = menu.toString().split(";");
        if (index <= content.length - 1) {
            return content[index];
        }
        return "No data available";
    }

    public void updateData(int attempts, int score) {
        String[] result = menu.toString().split(";");

        result[4] = result[4].replaceAll("\\d+", Integer.toString(attempts));
        result[5] = result[5].replaceAll("\\d+", Integer.toString(score));
        result[7] = result[7].replaceAll("\\d+", Integer.toString(attempts));

        menu.setLength(0);
        for (String part : result) {
            menu.append(part).append(";");
=======
        if (index <= menu.length - 1) {
            return menu[index];
        } else {
            return "No data available";
        }
    }

    public void updateAttempts(int currentAttempts) {
        this.attempts = currentAttempts;
        if (this.lang == Language.IT) {
            menu[4] = "Hai " + this.attempts + " tentativi!";
            menu[7] = "Purtroppo ti sbagli. Prova di nuovo! Tentativi rimasti: " + this.attempts + ". Ecco alcuni suggerimenti:";
            menu[22] = "Tentativi rimasti: " + this.attempts + "! Ecco alcuni suggerimenti:";
        } else if (this.lang == Language.DE) {
            menu[4] = "Du hast " + this.attempts + " Versuche!";
            menu[7] = "Leider liegst du falsch. Versuche es noch einmal! Verbleibende Versuche: " + this.attempts + ". Hier sind einige Hinweise:";
            menu[22] = "Verbleibende Versuche: " + this.attempts + "! Hier sind einige Hinweise:";
        } else {
            menu[4] = "You have " + this.attempts + " attempts!";
            menu[7] = "Unfortunately you are wrong. Try once more! Remained attempts: " + this.attempts + ". Here are some hints:";
            menu[22] = "Remained attempts " + this.attempts + "! Here are some hints:";
        }
    }

    public void updateScore(int score){
        this.score += score;
        if (this.lang == Language.IT) {
            menu[5] = "Il tuo punteggio attuale: " + this.score + "!";
        } else if (this.lang == Language.DE) {
            menu[5] = "Dein aktueller Punktestand: " + this.score + "!";
        } else {
            menu[5] = "Your current score: " + this.score + "!";
>>>>>>> b5c7482 (Amendmends for first commit)
        }
    }

    public void promptMenu(String hiddenName, String instructions) {
        System.out.println();
        //Guess the name of the cocktail prompt
        System.out.println(getData(0));
        //Attempts prompt
        System.out.println(getData(4));
        //Current score prompt
        System.out.println(getData(5));
        //Hidden name prompt
        System.out.println("\n" + "'" + hiddenName + "'");
        //Description prompt
        System.out.println(getData(1));
        //Instructions prompt
        System.out.println(instructions);
        //Back button prompt
        System.out.println("\n" + getData(3));
        //Skip prompt
        System.out.println(getData(6));
<<<<<<< HEAD
        //Input prompt
        System.out.print(getData(2));
    }
}
=======
        //Exit the program
        System.out.println(getData(21));
        //Input prompt
        System.out.print(getData(2));
    }

    public String showHints(Drink currentDrink, int currentAttempt) {
        StringBuilder str = new StringBuilder();
        switch (currentAttempt) {
            case 4:
                str.append(getData(11) + currentDrink.strCategory + ". ");
                break;
            case 3:
                str.append(getData(12) + currentDrink.strAlcoholic + ". ");
                break;
            case 2:
                str.append(getData(13) + currentDrink.strGlass + ". ");
                break;
        }
        return str.toString();
    }

    public boolean isValidInputLength(String guessWord, String actualWord) {
        if (guessWord.length() != actualWord.length()) {
            System.out.println(getData(8));
            System.out.print(getData(2));
            return false;
        } else {
            return true;
        }
    }
}


>>>>>>> b5c7482 (Amendmends for first commit)
