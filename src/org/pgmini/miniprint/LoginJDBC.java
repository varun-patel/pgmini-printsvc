package org.pgmini.miniprint;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class LoginJDBC implements LoginDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String firstName,
                       String lastName,
                       int studentNumber,
                       String password,
                       int[] quota,
                       boolean student,
                       boolean admin,
                       UUID uuid) {
        String SQL = "insert into users (firstname, lastname, studentnumber, password, quota, student, admin, uuid) values (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, firstName, lastName, studentNumber, password, quota, student, admin, uuid);
    }
    public Login getLogin(int studentNumber, String password) {
        String SQL = "select * from users where studentnumber = ? and password = ?";
        Login user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{studentNumber, password}, new LoginMapper());

        return user;
    }
    public List<Login> listStudents() {
        String SQL = "select * from users";
        List <Login> users = jdbcTemplateObject.query(SQL, new LoginMapper());
        return users;
    }
    public void delete(int studentNumber) {
        String SQL = "delete from users where id = ?";
        jdbcTemplateObject.update(SQL, studentNumber);
    }
    public void update(int oldStudentNumber,
                       String firstName,
                       String lastName,
                       int studentNumber,
                       String password,
                       int[] quota,
                       boolean student,
                       boolean admin,
                       UUID uuid) {
        String SQL = "update users set (firstname, lastname, studentnumber, password, quota, student, admin, uuid) = (?, ?, ?, ?, ?, ?, ?, ?) where studentnumber = ?";
        jdbcTemplateObject.update(SQL, firstName, lastName, studentNumber, password, quota, student, admin, uuid, oldStudentNumber);
    }
}
