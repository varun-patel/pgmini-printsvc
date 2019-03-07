package org.pgmini.miniprint;
/*
        PGMINI PRINT SERVICE
        Copyright (C) 2019  Varun Patel <varun@varunpatel.ca>

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.postgresql.Driver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Login {

    private String firstName;
    private String lastName;
    private int user;
    private String pass;
    private int[] quota;
    private boolean student;
    private boolean admin;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setUser(int user) {
        this.user = user;
    }

    public int getUser() {
        return user;
    }


    public void setPass(String pass) {
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bhash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < bhash.length; i++) {
                String hex = Integer.toHexString(0xff & bhash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.pass = hexString.toString();
    }

    public String getPass() {
        return pass;
    }


    public void setQuota(int[] quota) {
        this.quota = quota;
    }

    public int[] getQuota() {
        return quota;
    }


    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isStudent() {
        return student;
    }


    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }


    @Override
    public String toString() {
        return user + "," + pass + "," + quota + "," + student + "," + admin;
    }


    public void logged(String user, String pass) {

    }
}
