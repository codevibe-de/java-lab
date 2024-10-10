package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {
        List<Cat> cats = List.of(Cat.instance);
        List<Cat> destination = new ArrayList<>();
        Cat c = copyItems(cats, destination);
        Mammal m = copyItems(cats, destination);
        Animal a = copyItems(cats, destination);
    }


    static <T> T copyItems(List<? extends T> inputList, List<? super T> outputList) {
        outputList.addAll(inputList);
        return inputList.get(0);
    }


    public static class Animal {
        static Animal instance = new Animal();
    }

    public static class Mammal extends Animal {
        static Mammal instance = new Mammal();
    }

    public static class Cat extends Mammal {
        static Cat instance = new Cat();
    }

}
