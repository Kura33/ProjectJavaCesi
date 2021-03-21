package com.shield.projectJavaCesi.controller.employee;

import com.shield.projectJavaCesi.dto.EmployeeDto;
import com.shield.projectJavaCesi.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@RequestMapping("/shield")
public class LoginController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/login")
    public boolean login(@RequestBody EmployeeDto employeeDto)
    {
        if (service.checkLogin(employeeDto.email, employeeDto.password) != null) {
            return true;
        }
        return false;
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request){
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }
}
