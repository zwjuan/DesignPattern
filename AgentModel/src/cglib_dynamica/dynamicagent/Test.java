package cglib_dynamica.dynamicagent;

import dynamicagent.domain.Student;
import dynamicagent.handler.CglibInterecptor;
import dynamicagent.service.IStudentService;
import dynamicagent.service.impl.StudentServiceImpl;
import dynamicagent.transaction.Transaction;
import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

        //得到方法拦截器
        CglibInterecptor cglibInterecptor = new CglibInterecptor();

        //使用cglib框架生成目标类的子类（代理类）实现增强
        Enhancer enhancer = new Enhancer();
        //设置父类字节码
        enhancer.setSuperclass(StudentServiceImpl.class);
        enhancer.setCallback(cglibInterecptor);

        IStudentService studentService1  = (IStudentService)enhancer.create();
        studentService1.save(new Student());
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
