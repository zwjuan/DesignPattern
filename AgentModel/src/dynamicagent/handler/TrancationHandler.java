package dynamicagent.handler;

import dynamicagent.transaction.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrancationHandler implements InvocationHandler {
    /**
     * 增强方法
     */
    private Transaction transaction;
    /**
     * 目标方法
     */
    private Object object;

    public TrancationHandler(Transaction transaction, Object object) {
        this.transaction =transaction;
        this.object = object;
    }

    /**
     * 实现invoke方法
     * @param proxy  代理实例，可以通过newProxyInstance实现
     * @param method 执行目标方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("save".equals(method.getName())) {
            transaction.before();
            method.invoke(object, args);
            transaction.after();
        } else {
            method.invoke(object, args);
        }
        return null;
    }
}
