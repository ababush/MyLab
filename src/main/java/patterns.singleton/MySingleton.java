package patterns.singleton;

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 */
public final class MySingleton {

    /**
     * Private constructor so nobody can instantiate the class.
     */
    private MySingleton() {}

    /**
     * Static to class instance of the class.
     */
    private static final MySingleton INSTANCE = new MySingleton();

    /**
     * To be called by user to obtain instance of the class.
     *
     * @return instance of the singleton.
     */
    public static MySingleton getInstance() {
        return INSTANCE;
    }
}
