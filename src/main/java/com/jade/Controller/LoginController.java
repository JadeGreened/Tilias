package com.jade.Controller;

import com.jade.pojo.Emp;
import com.jade.pojo.Result;
import com.jade.service.EmpService;
import com.jade.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("Login by username:{},password:{}", emp.getUsername(), emp.getPassword());
        Emp login = empService.login(emp);

        if (login != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", login.getId());
            claims.put("nme", login.getName());
            claims.put("username", login.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("Username or password is wrong");


    }
}
