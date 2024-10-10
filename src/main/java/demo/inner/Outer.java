package demo.inner;

public class Outer {

    private String name;

    void blah() {
        new Inner();
    }

    static class InnerStatic {
        void foo() {
            System.out.println("name???");
        }
    }

    class Inner {
        void foo() {
            System.out.println(name);
        }
    }

}
