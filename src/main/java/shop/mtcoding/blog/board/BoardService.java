package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //글쓰기
    @Transactional
    public Board save(BoardRequest.WriteDTO reqDTO){
        Board board = reqDTO.getBoard();
        board.setTitle(reqDTO.getTitle());
        board.setContent(reqDTO.getContent());

        return boardRepository.save(board);

    }
}
