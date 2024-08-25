package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        System.out.println("user1 = " + user);
        userRepository.save(user);
        System.out.println("user 2= " + user);
    }

}
