package lambdas;

import java.util.Optional;

public class Lambdas2App {

    public static void main(String[] args) {
        optionalDemo(Optional.of("hello mario"));
    }

    private static void optionalDemo(Optional<String> optionalString) {
        String s2 = optionalString.orElseGet(() -> megaComplexDatabaseCall());

        String defaultValue = megaComplexDatabaseCall();
        String s1 = optionalString.orElse(defaultValue);
    }

    private static String megaComplexDatabaseCall() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return "asdasd";
    }

}











