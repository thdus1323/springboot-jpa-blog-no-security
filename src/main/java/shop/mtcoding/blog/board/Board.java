package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import shop.mtcoding.blog.user.User;

@Entity
@Table(name = "board_tb")
@Data
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(unique = true, length = 30, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
