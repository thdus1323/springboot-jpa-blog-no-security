package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //글 목록보기
    public List<BoardRequest.BoardDTO> findAll(){
        return boardRepository.findAll().stream()
                .map(board -> new BoardRequest.BoardDTO(board.getId(), board.getTitle()))
                .collect(Collectors.toList());
    }

    //글쓰기
    @Transactional
    public Board save(BoardRequest.WriteDTO reqDTO){
        Board board = reqDTO.getBoard();
        board.setTitle(reqDTO.getTitle());
        board.setContent(reqDTO.getContent());

        return boardRepository.save(board);

    }
}
