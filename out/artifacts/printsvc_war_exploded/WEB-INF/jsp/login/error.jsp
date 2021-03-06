<%@ page import="java.net.http.HttpRequest" %>
<%@ page import="org.springframework.web.bind.annotation.RequestAttribute" %><%--
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
    <style>
        .accordion {
            background-color: #eee;
            color: #444;
            cursor: pointer;
            padding: 18px;
            width: 100%;
            border: none;
            text-align: left;
            outline: none;
            font-size: 15px;
            transition: 0.4s;
        }

        .active, .accordion:hover {
            background-color: #ccc;
        }

        .panel {
            padding: 0 18px;
            display: none;
            background-color: white;
            overflow: hidden;
        }
    </style>
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
            <td><form:label path="pass">Password</form:label></td>
            <td><form:password path="pass"/></td>
        </tr>

        <tr>
            <td colspan="2" class="accordion">${error}</td>
            <div class="panel">
                <p>
                        ${errorDetails}
                </p>
            </div>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Log In"/>
            </td>
        </tr>
    </table>
</form:form>

<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        });
    }
</script>
</body>
</html>
