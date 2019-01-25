package dk.lundogbendsen.foundation.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

// Add these to load a shared context throughout tests
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextUserControllerTest {

    // This bean is now a Mockito mock
    @MockBean
    private UserRepository userRepository;

    // This one will be rewired by spring, using mockbeans and original beans from context
    @Autowired
    private UserController userController;


    @Test
    public void testInUserControllerThatSomethingIsRight() {

        long userID = 1L;


        // Training a mock
        Mockito.doReturn(testUser()).when(userRepository).findById(userID);

        long votes = userController.getVotesFor(userID);

        assertEquals(200, votes);
    }





    private Optional<User> testUser() {
        User u = new User();
        u.setVotes(200);
        u.setName("Niels");
        return Optional.of(u);
    }
}