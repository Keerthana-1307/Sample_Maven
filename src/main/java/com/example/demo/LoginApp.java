package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class LoginApp {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    public static void main(String[] args) {
        SpringApplication.run(LoginApp.class, args);
    }

    @GetMapping("/login")
    public String loginForm() {
        return "<!DOCTYPE html><html><body>"
            + "<h2>Login Page</h2>"
            + "<form method='post' action='/login'>"
            + "  <label>Username:</label><br>"
            + "  <input type='text' name='username'/><br><br>"
            + "  <label>Password:</label><br>"
            + "  <input type='password' name='password'/><br><br>"
            + "  <button type='submit'>Login</button>"
            + "</form>"
            + "</body></html>";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password) {
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            return "<h2 style='color:green'>✅ Login Successful! Welcome, " + username + ".</h2>"
                 + "<a href='/login'>Go Back</a>";
        } else {
            return "<h2 style='color:red'>❌ Login Failed! Invalid username or password.</h2>"
                 + "<a href='/login'>Try Again</a>";
        }
    }
}