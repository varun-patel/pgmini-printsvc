<%@ page import="java.net.http.HttpRequest" %><%--
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
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>${Title}</title>
</head>
<body>
    <h2>Student Information</h2>
    <form:form method="POST" action="/login/addLogin" modelAttribute="Login">
        <table>
            <tr>
                <td><form:label path="user">Student Number</form:label></td>
                <td><form:input path="user"/></td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="user" cssStyle="color: #ff0000;"/></td>
            </tr>
            <tr>
                <td><form:label path="pass">Password</form:label></td>
                <td><form:password path="pass"/></td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="pass" cssStyle="color: #ff0000;"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Log In"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
