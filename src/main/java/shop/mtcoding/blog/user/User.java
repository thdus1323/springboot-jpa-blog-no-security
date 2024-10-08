package shop.mtcoding.blog.user;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import shop.mtcoding.blog.board.Board;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "user_tb")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 20, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany
    private List<Board> boards;
}
