package code.climb.controller;

import code.climb.entity.User;
import code.climb.request.AuthenticationRequest;
import code.climb.request.SignupRequest;
import code.climb.service.AuthenticationService;
import code.climb.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final JWTService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(JWTService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest requestBody) {
        return authenticationService.signup(requestBody);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationRequest requestBody) {
        Authentication authenticate = authenticationService.authenticate(requestBody);
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(requestBody.getUsername());
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
