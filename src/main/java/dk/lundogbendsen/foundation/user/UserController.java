package dk.lundogbendsen.foundation.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {

    private static long defaultVotes = -1;

    // Autowired by field reference (Bad for testing, good for simplicity)
    //@Autowired
    private UserRepository userRepository;


    // Autowired by constructor (Cleaner design, better for testing)
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public long getVotesFor(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(defaultUser()).getVotes();
    }


    private User defaultUser() {
        User u = new User();
        u.setVotes(defaultVotes);
        return u;
    }
}
