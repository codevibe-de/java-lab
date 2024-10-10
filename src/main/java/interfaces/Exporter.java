package interfaces;

public interface Exporter {

    default String exportObject(Object o) {
        return o.toString();
    }

    default void xx() {
    }

}
