package enums;

public enum Weekdays implements Formattable {

    MONDAY("ab", "cd") {
        @Override
        public String format() {
            return "";
        }
    };

    Weekdays(String key, String value) {
        System.out.println("Constructing a Weekday");
    }

    public String foo() {
        return "foo";
    }

}
