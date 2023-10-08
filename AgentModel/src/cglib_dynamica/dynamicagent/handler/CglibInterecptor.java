package cglib_dynamica.dynamicagent.handler;

import dynamicagent.service.IStudentService;
import dynamicagent.service.impl.StudentServiceImpl;
import dynamicagent.transaction.Transaction;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterecptor implements MethodInterceptor {
    Transaction transaction = new Transaction();
    IStudentService studentService = new StudentServiceImpl();

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        transaction.before();
        Object object = method.invoke(o, objects);
        transaction.after();
        return object;
    }
}
