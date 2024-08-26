package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog.user.User;

import java.util.List;

@Slf4j // 코드에 주석
@RequiredArgsConstructor
@Controller
public class BoardController {
    private final HttpSession session;
    private final BoardService boardService;

    @GetMapping("/" )
    public String index(Model model) {
        List<BoardRequest.BoardDTO> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "index";
    }

    //게시글 쓰기
    @PostMapping("/board/save")
    public  String save(@RequestParam String title, @RequestParam String content){
       User user = (User) session.getAttribute("sessionUser");
        System.out.println("user = " + user);
       if (user == null){
           return "/login-form";
       }

       Board board = new Board();
        board.setUser(user);

        BoardRequest.WriteDTO writeDTO = new BoardRequest.WriteDTO(title, content, board);

        boardService.save(writeDTO);

        return "redirect:/";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id) {
        return "board/detail";
    }
}
