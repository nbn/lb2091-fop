package dk.lundogbendsen.foundation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id:[\\d]+}")
    public User getUser(@PathVariable long id) {
        return userRepository
                    .findById(id)
                    .orElseThrow( () -> new IllegalArgumentException("No such user " + id));
    }


    @DeleteMapping("/user/{id:[\\d]+}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }


    @GetMapping("/" )
    public HttpEntity<String> sanityCheck() {

        // Return some HTML
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        String msg = "It's alive! It's alive!";
        return new HttpEntity<>(msg, headers);
    }



    // curl -X POST -d '{"name":"Niels","votes":"200"}' -H 'Content-Type:application/json' http://localhost:8080/user
    // curl http://localhost:8080/users
    // curl http://localhost:8080/user/1
    // curl -X DELETE http://localhost:8080/user/1
}
