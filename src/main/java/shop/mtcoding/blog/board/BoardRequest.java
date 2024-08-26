package shop.mtcoding.blog.board;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardRequest {

    @Data
    @NoArgsConstructor
    public static class WriteDTO{
        private String title;
        private String content;
        private Board board;

        public WriteDTO(String title, String content, Board board) {
            this.title = title;
            this.content = content;
            this.board = board;
        }
    }

    @Data
    public static class BoardDTO{
        private Integer id;
        private String title;

        public BoardDTO(Integer id, String title) {
            this.id = id;
            this.title = title;
        }
    }
}
