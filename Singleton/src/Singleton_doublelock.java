/**
 * 双重检索模式
 */
public class Singleton_doublelock {
    private Singleton_doublelock() {}

    // 使用volatile防止指令重排序
    private static volatile Singleton_doublelock singleton_doublelock;


    public static Singleton_doublelock getInstace() {
        if (singleton_doublelock == null) {// 线程A和线程B同时看到singleton = null，如果不为null，则直接返回singleton
            synchronized (Singleton_doublelock.class) { // 线程A或线程B获得该锁进行初始化
                if (singleton_doublelock == null) { // 其中一个线程进入该分支，另外一个线程则不会进入该分支
                    return new Singleton_doublelock();
                }
            }
        }
        return singleton_doublelock;
    }
}
