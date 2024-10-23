package br.com.fiap.mvcagrocaretech.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model, @AuthenticationPrincipal OAuth2User principal){
        var user = (User) principal;

        model.addAttribute("user", user);
        model.addAttribute("users", userService.getRanking());

        return "users";

    }

}
