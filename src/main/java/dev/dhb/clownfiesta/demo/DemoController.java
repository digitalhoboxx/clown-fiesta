package dev.dhb.clownfiesta.demo;

import dev.dhb.clownfiesta.config.RBACConfig;
import dev.dhb.clownfiesta.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/demo-controller")
public class DemoController {

    @Autowired
    private RBACConfig rbacConfig;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            System.out.println(rbacConfig.getPermissions().get(user.getRole()));
        }

        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
