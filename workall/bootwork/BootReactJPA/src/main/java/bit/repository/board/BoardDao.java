package bit.data.board;


import bit.repository.board.BoardDaoInter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BoardDao {

    private BoardDaoInter boardDaoInter;
}
