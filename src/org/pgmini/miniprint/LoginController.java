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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class LoginController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("Login", new Login());
        model.addAttribute("Title", "PG Mini Print Service");
        model.addAttribute("relpath", "./login/addLogin.login");
        return "index";
    }

    @RequestMapping(value = "/login/index", method = RequestMethod.GET)
    public String login_index(ModelMap model) {
        model.addAttribute("Login", new Login());
        model.addAttribute("Title", "PG Mini Print Service");
        model.addAttribute("relpath", "./addLogin.login");
        return "index";
    }

    @RequestMapping(value = "/login/addLogin", method = RequestMethod.POST)
    public String login_addLogin(@ModelAttribute("login") /*@Valid*/ Login login, ModelMap model/*, BindingResult bindingResult*/) {
        model.addAttribute("Title", "PG Mini Print Service");

        LoginSQL runner = new LoginSQL();
        boolean authenticated = runner.authenticate(login);

        if (authenticated) {
            model.addAttribute("Login", login);
            model.addAttribute("FirstName", login.getFirstName());
            model.addAttribute("lastName", login.getLastName());
            model.addAttribute("user", login.getUser());
            model.addAttribute("pass", login.getPass());
            model.addAttribute("quota", login.getQuota());
            model.addAttribute("student", login.isStudent());
            model.addAttribute("admin", login.isAdmin());
            model.addAttribute("gradYear", login.getGradYear());
            model.addAttribute("uuid", login.getUuid());

            return "redirect:/queue/index";
        } else if (runner.getError() != null) {
            model.addAttribute("Login", new Login());
            model.addAttribute("error", runner.getError());
            model.addAttribute("errorDetails", runner.getRawError());
            model.addAttribute("relpath", "./addLogin.login");
            return "index";
        }
        /*else if (bindingResult.hasErrors()) {
            model.addAttribute("Login", new Login());
            model.addAttribute("error", "Invalid Login or Password Input");
            model.addAttribute("errorDetails", "send the following information to the lab administrator \n" + login.toString() + "\n" + bindingResult.toString() + "\n" + model.toString() + UUID.randomUUID());

            model.addAttribute("relpath", "./addLogin.login");
            return "index";
        }*/
        else {
            model.addAttribute("Login", new Login());
            model.addAttribute("error", "An unknown error occurred");
            model.addAttribute("errorDetails", "send the following information to the lab administrator \n" + login.toString() + "\n" + /*bindingResult.toString() + "\n" + */model.toString() + UUID.randomUUID());
            model.addAttribute("relpath", "./addLogin.login");
            return "index";
        }
    }
}