package demo.inner;

public class InnerApp {

    public static void main(String[] args) {
        new Outer.InnerStatic();  // geht, weil Inner "static" ist
    }
}
