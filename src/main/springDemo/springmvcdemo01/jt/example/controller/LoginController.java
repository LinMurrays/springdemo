package springmvcdemo01.jt.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/doLoginUi")
	public String doLoginUi(){	
		return "login";
	}
	
	
}
