package shop.mtcoding.blog.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    //회원가입

    //로그인
    //Select * from user where username=? and password =?;
   Optional<User>  findByUsernameAndPassword(String username, String password);
}
