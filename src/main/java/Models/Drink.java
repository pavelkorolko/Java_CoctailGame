package Models;

public class Drink {
    public String idDrink;
    public String strDrink;
    public Object strDrinkAlternate;
    public Object strTags;
    public Object strVideo;
    public String strCategory;
    public Object strIBA;
    public String strAlcoholic;
    public String strGlass;
    public String strInstructions;
    public String strInstructionsES;
    public String strInstructionsDE;
    public Object strInstructionsFR;
    public String strInstructionsIT;
    public String strDrinkThumb;
    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public Object strIngredient5;
    public Object strIngredient6;
    public Object strIngredient7;
    public Object strIngredient8;
    public Object strIngredient9;
    public Object strIngredient10;
    public Object strIngredient11;
    public Object strIngredient12;
    public Object strIngredient13;
    public Object strIngredient14;
    public Object strIngredient15;
    public String strMeasure1;
    public String strMeasure2;
    public String strMeasure3;
    public String strMeasure4;
    public Object strMeasure5;
    public Object strMeasure6;
    public Object strMeasure7;
    public Object strMeasure8;
    public Object strMeasure9;
    public Object strMeasure10;
    public Object strMeasure11;
    public Object strMeasure12;
    public Object strMeasure13;
    public Object strMeasure14;
    public Object strMeasure15;
    public Object strImageSource;
    public Object strImageAttribution;
    public String strCreativeCommonsConfirmed;
    public String dateModified;

    public String getInstructions(Language lang) {
        switch (lang) {
            case IT:
                return this.strInstructionsIT;
            case DE:
                return this.strInstructionsDE;
            default:
                return this.strInstructions;
        }
    }

    public String getInitialDrinkName() {
        return strDrink;
    }
}
