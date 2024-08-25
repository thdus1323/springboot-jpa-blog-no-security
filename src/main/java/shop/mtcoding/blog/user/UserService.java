package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    public void join(UserRequest.JoinDTO reqDTO){
        User user = new User();
        user.setUsername(reqDTO.username);
        user.setPassword(reqDTO.password);
        user.setEmail(reqDTO.email);
        userRepository.save(user);
    }

    //로그인
      @Transactional(readOnly = true)
    public User login(UserRequest.LoginDTO reqDTO){
          Optional<User> sessionUser = userRepository.findByUsernameAndPassword(reqDTO.getUsername(), reqDTO.getPassword());
          if (sessionUser.isPresent()){
              return sessionUser.get();
          }
          throw new RuntimeException("로그인 실패 : 아이디 혹은 패스워드를 다시 확인하세요");

      }

}
