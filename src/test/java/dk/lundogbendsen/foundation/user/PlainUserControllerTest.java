package dk.lundogbendsen.foundation.user;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.Assert.*;

public class PlainUserControllerTest {

    @Test
    public void plainTest() {
        long userID = 1L;

        UserRepository repository = Mockito.mock(UserRepository.class);


        // Use this to inject into a private field (Or rewrite to constructor injection)
        UserController controller = new UserController(repository);
        //UserController controller = new UserController();
        //ReflectionTestUtils.setField(controller, "userRepository", repository);

        Mockito.doReturn(testUser()).when(repository).findById(userID);

        long votes = controller.getVotesFor(userID);

        assertEquals(200, votes);
    }



    private Optional<User> testUser() {
        User u = new User();
        u.setVotes(200);
        u.setName("Niels");
        return Optional.of(u);
    }

}