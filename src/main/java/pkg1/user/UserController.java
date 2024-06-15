package pkg1.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserRepo ur;
	
	@PostMapping("/user/add")
	public String addUser(@RequestBody UserEntity ue) {
		ur.save(ue);
		return "User added Successfully";
	}
	
	@GetMapping("/user/login/{user}/{pass}")
	public List<UserEntity> login(@PathVariable String user, @PathVariable String pass){
		return ur.login(user, pass);
	}

}
