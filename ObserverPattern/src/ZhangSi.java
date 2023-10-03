/**
 * 观察者: ZhangSi
 */
public class ZhangSi implements Observer{
    @Override
    public void update(String context) {
        System.out.println("zhangsi: " + context);

    }
}
