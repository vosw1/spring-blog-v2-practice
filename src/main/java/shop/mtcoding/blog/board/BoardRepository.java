package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager em;

    public Board findById(int id) {
        Board board = em.find(Board.class, id);
        return board;
    }

    @Transactional
    public void deleteById(int id){
        Query query = em.createQuery("delete from Board b where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    public List<Board> findAll() {
        Query query = em.createQuery("select b from Board b order by b.id desc", Board.class);
        return query.getResultList();
    }

    public Board findByIdJoinUser(int id) {
        Query query = em.createQuery("select b from Board b join fetch b.user u where b.id = :id", Board.class);
        query.setParameter("id", id);
        return (Board) query.getSingleResult();
    }

    @Transactional
    public void updateById(int id, String title, String content) { // DTO를 안만들고 꺼내서 넘겨도 됨 -> 재사용 가능
        Board board = findById(id);
        board.setTitle(title);
        board.setContent(content);
    }
}
