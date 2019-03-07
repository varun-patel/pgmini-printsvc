package org.pgmini.miniprint;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<Login> {
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
        Login login = new Login();
        login.setFirstName(rs.getString("firstName"));
        login.setLastName(rs.getString("lastName"));
        login.setPass(rs.getString("pass"));
        login.setQuota((int[]) rs.getArray("quota").getArray());
        login.setUser(rs.getInt("studentNumber"));
        login.setStudent(rs.getBoolean("student"));
        login.setAdmin(rs.getBoolean("admin"));

        return login;
    }
}