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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login/student", method = RequestMethod.POST)
    public String student(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "/print.jsp";
    }

    @RequestMapping(value = "/login/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") Login login, ModelMap model) {
        model.addAttribute("FirstName", login.getFirstName());
        model.addAttribute("lastName", login.getLastName());
        model.addAttribute("user", login.getUser());
        model.addAttribute("pass", login.getPass());
        model.addAttribute("quota", login.getQuota());
        model.addAttribute("student", login.isStudent());
        model.addAttribute("admin", login.isAdmin());

        if (login.isStudent() || login.isAdmin()) {
            return "/print";
        } else {
            return "redirect:print";
        }
    }

    @RequestMapping(value = "/login/admin", method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute("SpringWeb") Login login, ModelMap model) {
        model.addAttribute("FirstName", login.getFirstName());
        model.addAttribute("lastName", login.getLastName());
        model.addAttribute("user", login.getUser());
        model.addAttribute("pass", login.getPass());
        model.addAttribute("quota", login.getQuota());
        model.addAttribute("student", login.isStudent());
        model.addAttribute("admin", login.isAdmin());

        model.addAttribute("message", "Hello Spring MVC Framework!");

        if (login.isAdmin()) {
            return "/admin/index";
        } else {
            return "index";
        }
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }
}