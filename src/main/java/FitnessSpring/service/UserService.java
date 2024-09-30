package FitnessSpring.service;



import FitnessSpring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import FitnessSpring.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

 // Sign up method
    public User registerUser(String username, String password,String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); 
        user.setEmail(email); // In real life, hash the password
        return userRepository.save(user);
    } 
    
// Contact form submission

    
    //login

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
