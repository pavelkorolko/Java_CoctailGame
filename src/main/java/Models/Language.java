package Models;

public enum Language {
    EN(1),
    DE(2),
    IT(3);

    private int value;

    Language(int value) {
        this.value = value;
    }

    public static Language convert(int value) throws IllegalArgumentException {
        for (Language lang : Language.values()) {
            if (lang.value == value) {
                return lang;
            }
        }

        throw new IllegalArgumentException("Invalid language code!");
    }
}
