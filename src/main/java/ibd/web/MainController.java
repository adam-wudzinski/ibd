package ibd.web;

import ibd.persistence.entity.User;
import ibd.persistence.repository.UserRepository;
import ibd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String homePage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String hello() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String add(){
        return "auth/register";
    }

    @PostMapping("/register")
    public String postAdd(@ModelAttribute User user, Model model) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            model.addAttribute("userExistsError", true);
            return "auth/register";
        }
        userRepository.save(user);
        return "redirect:/login";
    }

}
