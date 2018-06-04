package zad3;

import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import antlr.collections.List;

@Controller
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	//private MessageRepo messageRepo;
	
	@GetMapping("/")
	public String test(Map<String, Object> model) {
		
		model.put("message", "Hello, my friend!!!");
		
		return "test";
	}
	
	@GetMapping("/users/")
	public String users(Map<String, Object> model) {
		
		model.put("message", "Hello, my friend!!!");
		
		return "users";
	}
	
	@GetMapping("users/show/")
	public String showusers(Map<String, Object> model){
		Iterable<User> messages = userRepository.findAll();
		
		model.put("message", messages);
		
	return "showusers";
	}
	
	
	@GetMapping("users/add/")
	public String addUser(Map<String, Object> model) {
		return "addUser";
	}

	
	@PostMapping("users/add/")
	public String addUserAction(@ModelAttribute("email") String email, @ModelAttribute("name") String name, Map<String, Object> model) {
		System.out.println("User to be added: " + email);
		if (email != null) {
			User user = new User();
			user.setEmail(email);
			user.setName(name);
			
			userRepository.save(user);
			
			model.put("message", "User added");
		}
		return "addUser";
	}

}
