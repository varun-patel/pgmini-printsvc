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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("Login", new Login());
        model.addAttribute("Title", "PG Mini Print Service");
        return "index";
    }

    @RequestMapping(value = "/login/index", method = RequestMethod.GET)
    public String login_index(ModelMap model) {
        model.addAttribute("Login", new Login());
        model.addAttribute("Title", "PG Mini Print Service");
        return "index";
    }

    @RequestMapping(value = "/login/addLogin", method = RequestMethod.POST)
    public String login_addLogin(@ModelAttribute("Login") Login login, ModelMap model) {
        model.addAttribute("Title", "PG Mini Print Service");

        LoginSQL runner = new LoginSQL();
        boolean authenticated = runner.authenticated(login.getUser(), login.getPass());

        if (authenticated) {
            model.addAttribute("FirstName", login.getFirstName());
            model.addAttribute("lastName", login.getLastName());
            model.addAttribute("user", login.getUser());
            model.addAttribute("pass", login.getPass());
            model.addAttribute("quota", login.getQuota());
            model.addAttribute("student", login.isStudent());
            model.addAttribute("admin", login.isAdmin());
            return "redirect:/queue/index";
        } else {
            model.addAttribute("Login", new Login());
            model.addAttribute("error", runner.getError());
            model.addAttribute("errorDetails", runner.getRawError());
            return "index";
        }
    }
}