package FitnessSpring.controller;

import FitnessSpring.entity.User;
import FitnessSpring.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import FitnessSpring.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ContactService contactService;

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // This corresponds to login.html in the templates folder
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    
    
 
    // Handle signup form submission
    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username, 
                         @RequestParam("password") String password,
                         @RequestParam("email") String email,
                         Model model) {
        if (userService.registerUser(username, password, email) != null) {
        	model.addAttribute("message", " Successfully Register!");
        	return "login";  // Redirect to login after signup
        } else {
            model.addAttribute("error2", "Signup failed. Try again.");
            return "login";
        }
    }
        //contact
        @PostMapping("/contact")
        public String contact(@RequestParam("name") String name, 
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("message") String message,
                             Model model) {
            if (contactService.registerContact(name, email, phone,message) != null) {
            	model.addAttribute("message3", " Message Successfully Sent !");
            	return "home"; 
            } else {
                model.addAttribute("error3", "Signup failed. Try again.");
                return "home";
            }
        }
//Logout page         
@GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login"; 
    


       
            
}
}