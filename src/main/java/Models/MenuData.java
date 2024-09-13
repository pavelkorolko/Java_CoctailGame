package Models;

public class MenuData {
    private StringBuilder menu;
    private int attempts;
    private int score = 0;
    private Language lang;

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
        }
    }

    public String getData(int index) {
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
        //Input prompt
        System.out.print(getData(2));
    }
}
