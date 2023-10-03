import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试单例模式
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton_hungry singleton_hungry1 = Singleton_hungry.getInstance();
        Singleton_hungry singleton_hungry2 = Singleton_hungry.getInstance();

        // 饿汉模式
        //System.out.println(singleton_hungry1 == singleton_hungry2);

        // 枚举
        //System.out.println(Singleton_enum.SINGLETON_ENUM == Singleton_enum.SINGLETON_ENUM);

        // 利用反射破坏单例模式
        Constructor<Singleton_hungry> constructor = Singleton_hungry.class.getDeclaredConstructor();
        // 可访问私有构造器
        constructor.setAccessible(true);
        // 利用反射构造新对象
        Singleton_hungry singleton_hungry = constructor.newInstance();
        System.out.println(singleton_hungry == singleton_hungry1);

    }
}
