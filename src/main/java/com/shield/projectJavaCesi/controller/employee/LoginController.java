package com.shield.projectJavaCesi.controller.employee;

import com.shield.projectJavaCesi.config.JwtTokenUtil;
import com.shield.projectJavaCesi.config.TokenResponse;
import com.shield.projectJavaCesi.dto.EmployeeDto;
import com.shield.projectJavaCesi.service.MyUserDetailsService;
import com.shield.projectJavaCesi.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shield")
public class LoginController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody EmployeeDto employeeDto) throws Exception {
        authenticate(employeeDto.email, employeeDto.password);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(employeeDto.email);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new TokenResponse(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}