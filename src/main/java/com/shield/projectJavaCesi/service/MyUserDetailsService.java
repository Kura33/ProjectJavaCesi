package com.shield.projectJavaCesi.service;

import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee user = employeeRepository.getEmployeeByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("email " + email + " not found");
        }
        List<GrantedAuthority> authorities = getAuthorities(user.getBeing().getAccessRole().getName());
        return Mapper.employeeToUserDetails.apply(user, authorities);
    }

    private static List<GrantedAuthority> getAuthorities (String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

}
