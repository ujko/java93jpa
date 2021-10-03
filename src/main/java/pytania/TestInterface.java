package pytania;

@FunctionalInterface
public interface TestInterface {
    int doSth(int a, int b);

    default void doSth1() {
        System.out.println("doSth1");
    }
}
