package reflection;

import java.lang.reflect.Constructor;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        // parse XML
        String className = "reflection.ProductService";

        // bean container:
        Class<?> theClass = Class.forName(className);
        Constructor<?> constructor = theClass.getConstructors()[0];
        ProductService ps = (ProductService) constructor.newInstance();
        ps.createProduct();
    }
}
