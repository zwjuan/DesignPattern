package cglib_dynamica.dynamicagent.service;

import dynamicagent.domain.Student;

public interface IStudentService {

    /**
     * 保存
     * @param student
     */
    void save(Student student);

    /**
     * 查询
     * @param id
     */
    Student query(Integer id);
}
