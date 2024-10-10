package lambdas;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaDemo {

    static final int factor = 3;

    public static void main(String[] args) {
        Function<String, Integer> lengthCounter = s -> s.length();
        printStringStatistics(lengthCounter);

        Function<String, Integer> numberWithoutUs = s -> s.replace("u", "").length() * factor;
        printStringStatistics(numberWithoutUs);

        Consumer<Object> printingLambda = ding -> System.out.println(ding);
        Consumer<Object> printingLambda2 = System.out::println;
        printingLambda.accept(LocalDate.now());
    }


    public static void printStringStatistics(Function<String, Integer> f) {
        System.out.println(f.apply("Blum"));
    }

}

@FunctionalInterface
interface Addition {
    int add(int a, int b);
}

@FunctionalInterface
interface Squarer {
    int square(int n);
}