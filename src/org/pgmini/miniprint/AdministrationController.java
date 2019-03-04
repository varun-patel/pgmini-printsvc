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
public class AdministrationController {
    @RequestMapping(value = "/admin/stats", method = RequestMethod.GET)
    public String stats(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

    @RequestMapping(value = "/admin/quotas", method = RequestMethod.GET)
    public String quotas(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

    @RequestMapping(value = "/admin/changeQuotas", method = RequestMethod.POST)
    public String changeQuotas(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework");
        return "index";
    }

    @RequestMapping(value = "/admin/logins", method = RequestMethod.GET)
    public String logins(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

    @RequestMapping(value = "/admin/logins/addlogins", method = RequestMethod.PUT)
    public String addLogins(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework");
        return "index";
    }

    @RequestMapping(value = "/admin/logins/dellogins", method = RequestMethod.DELETE)
    public String delLogins(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework");
        return "index";
    }
}