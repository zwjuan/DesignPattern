import java.util.ArrayList;
import java.util.List;

public class HanFeizi implements Observable, Subject{
    List<Observer> list = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notofityObservers(String context) {
        list.forEach(observer1 -> observer1.update(context));
    }

    @Override
    public void haveBreadfase() {
        System.out.println("韩非子：开始吃饭");
        this.notofityObservers("开始吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：开始娱乐");
        this.notofityObservers("开始娱乐");
    }
}
