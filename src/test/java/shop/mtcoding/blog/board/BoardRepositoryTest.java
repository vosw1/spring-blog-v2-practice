package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    private EntityManager em;

    @Test
    public void updateById_test(){
        // given
        int id  = 1;
        String title = "수정제목1";
        String content = "수정내용1";
        // when
        boardRepository.updateById(id, title, content); // delete 쿼리 발동
        em.flush();
        // then
        System.out.println("updateById_test : " + boardRepository.findById(id));
    }

    @Test
    public void findByIdJoinUser_test(){
        // given
        int id = 1;
        // when
        Board board = boardRepository.findById(id);
        // then
        System.out.println("findByIdJoinUser_test : " + board);
    }

    @Test
    public void findById_test(){
        // given
        int id = 1;
        // when
        Board board = boardRepository.findById(id);
        // then
        System.out.println("findById_test : " + board);
    }

    @Test
    public void deleteById_test(){
        // given
        int id = 4;
        // when
        boardRepository.deleteById(id);
        // then
        System.out.println("deleteById_test : " + boardRepository.findAll().size());
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<Board> boardList = boardRepository.findAll();
        // then
        System.out.println("findAll_test : " + boardList.size());
    }

}
