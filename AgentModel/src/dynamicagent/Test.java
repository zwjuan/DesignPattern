package dynamicagent;

import dynamicagent.domain.Student;
import dynamicagent.handler.TrancationHandler;
import dynamicagent.service.IStudentService;
import dynamicagent.service.impl.StudentServiceImpl;
import dynamicagent.transaction.Transaction;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * 测绘类
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 增强类
         */
        Transaction transaction = new Transaction();
        /**
         * 目标类
         */
        IStudentService studentService = new StudentServiceImpl();
        /**
         * 方法拦截器
         */
        TrancationHandler trancationHandler = new TrancationHandler(transaction, studentService);
        /**
         * 获取代理实例对象
         */
        IStudentService proxyInstance = (IStudentService) Proxy.newProxyInstance(studentService.getClass().getClassLoader(), studentService.getClass().getInterfaces(), trancationHandler);
        proxyInstance.save(new Student());
        proxyInstance.query(0);

        saveProxyClass("/Users/weijuanzhang/code/DesignPattern/AgentModel/src/dynamicagent");
    }

    /**
     * 生成字节码用去学习
     */
    private static void saveProxyClass(String path)  {
        byte[] $proxy = ProxyGenerator.generateProxyClass("$proxy1", StudentServiceImpl.class.getInterfaces() );

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(path + "$proxy1.class"));
            outputStream.write($proxy);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
