/**
 * 观察者实现类
 */
public interface Observable {

    /**
     * 增加一个观察者者
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 删除一个观察者
     * @param observer
     */
    void delObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    void notofityObservers(String context);
}
