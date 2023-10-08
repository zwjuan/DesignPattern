package dynamicagent.transaction;

public class Transaction {

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
