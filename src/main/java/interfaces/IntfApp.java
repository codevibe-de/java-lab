package interfaces;

public class IntfApp {

    public static void main(String[] args) {
        Transformer uppercaseTransformer = (s) -> s.toUpperCase();
        Transformer first10CharsTransformer = (s) -> s.substring(0, 10);

        var output = uppercaseTransformer.andThen(first10CharsTransformer).transform("hello dear passengers");
        System.out.println(output);
    }
}


@FunctionalInterface
interface Transformer {

    String transform(String input);

    default Transformer andThen(Transformer other) {
        return null;
    }

}


interface Device {

    boolean isOn();

    default boolean isOff() {
        return !isOn();
    }

}


class Fridge implements Device {

    private boolean on = false;

    @Override
    public boolean isOn() {
        return this.on;
    }
}