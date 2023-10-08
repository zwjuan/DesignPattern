package cglib_dynamica.dynamicagent.service.impl;

import dynamicagent.domain.Student;
import dynamicagent.service.IStudentService;

/**
 * 实现类
 */
public class StudentServiceImpl implements IStudentService {
    @Override
    public void save(Student student) {
        System.out.println("save");
    }

    @Override
    public Student query(Integer id) {
        System.out.println("queryac");
        return null;
    }
}
