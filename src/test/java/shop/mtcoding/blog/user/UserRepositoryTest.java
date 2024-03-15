package shop.mtcoding.blog.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void updateById_test() {
    // given
    int id = 1;
    String password = "12345";
    String email = "ssar12@nate.com";
    //when
    User user = userRepository.updateById(id, password, email);
    //then
        System.out.println("updateById_test : " + user);
    }

    @Test
    public void findByUsername_test(){
        // given
        UserRequest.LoginDTO reqDTO = new UserRequest.LoginDTO();
        reqDTO.setUsername("ssar");
        reqDTO.setPassword("1234");
        // when
        User user = userRepository.findByUsernameAndPassword(reqDTO);

        // then
        System.out.println("findByUsernamneAndPassword_test : " + user);
    }
}
