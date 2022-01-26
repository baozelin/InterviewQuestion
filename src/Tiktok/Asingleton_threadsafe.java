package Tiktok;

public class Asingleton_threadsafe {
    private static volatile Asingleton_threadsafe instance;
    private static Object mutex = new Object();

    private Asingleton_threadsafe() {
    }

    public static Asingleton_threadsafe getInstance() {
        Asingleton_threadsafe result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new Asingleton_threadsafe();
            }
        }
        return result;
    }

}
