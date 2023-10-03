/**
 * 懒汉式：
 * 在真正需要使用对象是，才去创建该单例类对象
 */
public class Singleton_lazy {

    private Singleton_lazy() {}

    private static Singleton_lazy singleton_lazy;

    /**
     * 这个方法其实是存在问题的，
     * 试想一下，如果两个线程同时判断 singleton 为空，
     * 那么它们都会去实例化一个Singleton 对象，这就变成多例了。
     * 所以，我们要解决的是线程安全问题。
     *
     * @return
     */
    public static Singleton_lazy getInstance() {
        if (singleton_lazy == null) {
            return new Singleton_lazy();
        }
        return singleton_lazy;
    }
}
