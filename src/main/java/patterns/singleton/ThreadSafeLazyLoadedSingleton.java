package patterns.singleton;

public final class ThreadSafeLazyLoadedSingleton {

/**
 * Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism.
 *
 * Note: if created by reflection then a singleton will not be created but multiple options in the
 * same classloader
 */
private static ThreadSafeLazyLoadedSingleton instance;

    private ThreadSafeLazyLoadedSingleton() {
        // protect against instantiation via reflection
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * The instance gets created only when it is called for first time. Lazy-loading
     */
    public static synchronized ThreadSafeLazyLoadedSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazyLoadedSingleton();
        }

        return instance;
    }

}
