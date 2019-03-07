package org.pgmini.miniprint;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public interface LoginDAO {

    public void setDataSource(DataSource ds);
    public void create(String firstName,
                       String lastName,
                       int studentNumber,
                       String password,
                       int[] quota,
                       boolean student,
                       boolean admin,
                       UUID uuid);
    public Login getLogin(int studentNumber, String password);
    public List<Login> listStudents();
    public void delete(int studentNumber);
    public void update(int oldStudentNumber,
                       String firstName,
                       String lastName,
                       int studentNumber,
                       String password,
                       int[] quota,
                       boolean student,
                       boolean admin,
                       UUID uuid);
}
