package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final HttpSession session;
    private final UserService userService;

    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest. JoinDTO reqDTO){
        userService.join(reqDTO);
//        System.out.println("reqDTO = " + reqDTO);
        return "redirect:/login-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    @PostMapping("/login")
    public String login(UserRequest. LoginDTO reqDTO){
        User user = userService.login(reqDTO);

        session.setAttribute("sessionUser", user);
        System.out.println("로그인한 user = " + user);

        return "redirect:/";
    }

    @GetMapping("/user/update-form")
    public String updateForm() {
        return "user/update-form";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
