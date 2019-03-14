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
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.pgmini.miniprint.Login;

public class LoginValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return Login.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "valid.user");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "valid.pass");
    }
}