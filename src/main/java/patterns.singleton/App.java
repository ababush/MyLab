package patterns.singleton;

import org.apache.log4j.Logger;

/**
 * Singleton pattern ensures that the class can have only one existing instance per Java classloader
 * instance and provides global access to it.
 * <p>
 * One of the risks of this pattern is that bugs resulting from setting a singleton up in a
 * distributed environment can be tricky to debug, since it will work fine if you debug with a
 * single classloader. Additionally, these problems can crop up a while after the implementation of
 * a singleton, since they may start out synchronous and only become async with time, so you it may
 * not be clear why you are seeing certain changes in behaviour.
 * <p>
 * There are many ways to implement the Singleton. The first one is the eagerly initialized instance
 * in Singleton. Eager initialization implies that the implementation is thread safe. If
 * you can afford giving up control of the instantiation moment, then this implementation will suit
 * you fine.
 * <p>
 * The other option to implement eagerly initialized Singleton is enum based Singleton. The example
 * is found in EnumSingleton. At first glance the code looks short and simple. However, you
 * should be aware of the downsides including committing to implementation strategy, extending the
 * enum class, serializability and restrictions to coding.
 * <p>
 * ThreadSafeLazyLoadedSingleton is a Singleton implementation that is initialized on
 * demand. The downside is that it is very slow to access since the whole access method is
 * synchronized.
 * <p>
 * Another Singleton implementation that is initialized on demand is found in
 * {ThreadSafeDoubleCheckLocking. It is somewhat faster than
 * ThreadSafeLazyLoadedSingleton since it doesn't synchronize the whole access method but
 * only the method internals on specific conditions.
 * <p>
 * Yet another way to implement thread safe lazily initialized Singleton can be found in
 * InitializingOnDemandHolderIdiom. However, this implementation requires at least Java 8
 * API level to work.
 */

public class App {
//

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {

        // eagerly initialized singleton
        MySingleton singleton1 = MySingleton.getInstance();
        MySingleton singleton2 = MySingleton.getInstance();
        System.out.println("Eagerly initialized singleton: " + singleton1.hashCode() + " = " + singleton2.hashCode());

        // lazily initialized singleton
        ThreadSafeLazyLoadedSingleton threadSafeSingleton1 = ThreadSafeLazyLoadedSingleton.getInstance();
        ThreadSafeLazyLoadedSingleton threadSafeSingleton2 = ThreadSafeLazyLoadedSingleton.getInstance();
        System.out.println("Lazily initialized singleton:  " + threadSafeSingleton1.hashCode() + " = " + threadSafeSingleton2.hashCode());

        // enum singleton
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println("Enum singleton: \t\t\t   " + enumSingleton1.hashCode() + " = " + enumSingleton2.hashCode());

        // double checked locking
        ThreadSafeDoubleCheckLocking dcl1 = ThreadSafeDoubleCheckLocking.getInstance();
        ThreadSafeDoubleCheckLocking dcl2 = ThreadSafeDoubleCheckLocking.getInstance();
        System.out.println("Double checked locking: \t   " + dcl1.hashCode() + " = " + dcl2.hashCode());

        // initialize on demand holder idiom
        InitializingOnDemandHolderIdiom demandHolderIdiom = InitializingOnDemandHolderIdiom.getInstance();
        InitializingOnDemandHolderIdiom demandHolderIdiom2 = InitializingOnDemandHolderIdiom.getInstance();
        System.out.println("Initialize on demand holder:   " + demandHolderIdiom.hashCode() + " = " + demandHolderIdiom2.hashCode());

    }
}
