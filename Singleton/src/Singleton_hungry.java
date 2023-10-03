/**
 * 饿汉式:
 * 在类加载时，已经创建好该单例对象，等待被程序使用
 */
public class Singleton_hungry {

    //私有方式被创建
    private Singleton_hungry() {

    }

    //类在加载时会在堆内存中创建一个Singleton对象，当类被卸载时，Singleton对象也随之消亡了。
    private static final Singleton_hungry singleton_hungry = new Singleton_hungry();


    public static Singleton_hungry getInstance() {
        return singleton_hungry;
    }

}
