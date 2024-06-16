package ios_project_final.cheermassage.controller;

import ios_project_final.cheermassage.entity.UserEntity;
import ios_project_final.cheermassage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestParam String kakaoId,
                                   @RequestParam String userName,
                                   @RequestParam String userPassword,
                                   @RequestParam String userAddress) {
        return userService.registerUser(kakaoId, userName, userPassword, userAddress);
    }

    @PostMapping("/login")
    public UserEntity loginUser(@RequestParam String kakaoId,
                                @RequestParam String userPassword) {
        return userService.loginUser(kakaoId, userPassword);
    }
}