package org.pgmini.miniprint;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class LoginSQL {


    private final String JDBCURL = "jdbc:postgresql://localhost:5432/printsvc";
    private final String DBUser = "printsvcrunner";
    private final String DBPass = "asdf";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private String error;
    private String rawError;

    public boolean authenticate(Login l) {
        boolean output = false;
        try {
            runSQL("SELECT password, uuid FROM users WHERE studentnumber = " + l.getUser() + ";");
            if (getRs().next()) {
                String passFromDB = getRs().getString("password");
                String uuidFromDB = getRs().getString("uuid");
                l.setPass(l.hashPass(l.getPass(), UUID.fromString(uuidFromDB)));
                if (l.getPass().equals(passFromDB)) {
                    output = true;
                } else {
                    setError("Password Mismatch");
                    setRawError("The provided password did not match the password on database.\nPlease try again or reset your password by speaking to an administrator.");
                }
            } else {
                setError("Invalid Username");
                setRawError("The provided username did not match any record on the database.\nMake sure you are using your student number and try again, if this issue continues to occur, contact an administrator.");
            }

        } catch (SQLException e) {
            parseSQLException(e);
        } finally {
            closeConn();
        }
        return output;
    }

    public String getJDBCURL() {
        return JDBCURL;
    }

    public String getDBUser() {
        return DBUser;
    }

    public String getDBPass() {
        return DBPass;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRawError(String rawError) {
        this.rawError = rawError;
    }

    public String getRawError() {
        return rawError;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    private void runSQL(String query) {
        try {
            setConn(DriverManager.getConnection(getJDBCURL(), getDBUser(), getDBPass()));
            setStmt(conn.createStatement());
            setRs(stmt.executeQuery(query));
        } catch (SQLException e) {
            parseSQLException(e);
        }
    }

    private void closeConn() {
        try {
            if (getStmt() != null) {
                stmt.close();
            }
            if (getRs() != null) {
                rs.close();
            }
            if (getConn() != null) {
                rs.close();
            }
        } catch (SQLException e) {
            parseSQLException(e);
        }
    }

    private void parseSQLException(SQLException e) {
        rawError = e.getSQLState();
        error = "A Database Error Occurred";
    }


    /*
    JdbcTemplate jdbctemplate;
    public Login referenceDataFromDB(String user) {
        Login output = jdbctemplate.query("SELECT * FROM users WHERE studentnumber = ?",
                new Object[] {user},
                (rs, rowNum) -> new Login(
                        rs.getInt("studentnumber"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        (int[]) rs.getArray("quota").getArray(),
                        (UUID) rs.getObject("uuid"),
                        rs.getBoolean("student"),
                        rs.getBoolean("admin")
                )
        ).get(0);
        return output;
    }

    public boolean authenticated(String user, String pass) {
        String output =
    }
    */
}
