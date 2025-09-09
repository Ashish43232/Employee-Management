package myproject.bootjpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import myproject.bootjpa.model.LoginPayLoadModel;
import myproject.bootjpa.service.EmployeeAuthService;

@Controller
public class EmployeeAuthController {
	
	@Autowired
	EmployeeAuthService employeeauthservice;
	
	@GetMapping("/dologin")
	public String loadLoginPage(Model model)
	{
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutAction(Model model) {
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboardpage(HttpSession session , Model model) {
		String loginedname = (String) session.getAttribute("name");
		
		if(loginedname != "" && loginedname != null) {
			model.addAttribute("name", loginedname);
		}
		
		return "dashboard";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginPayLoadModel fromUser, HttpSession session,Model model) {
		
		System.out.println("Param Data : " +fromUser.getName() + fromUser.getCode());
		
		boolean isuserobj = employeeauthservice.LoginAction(fromUser.getName(), fromUser.getCode());
		
		System.out.println(isuserobj);
		
		if(isuserobj) {
			model.addAttribute("message","");
			session.setAttribute("name",fromUser.getName());
			return "redirect:dashboard";
		}
		
		else {
			model.addAttribute("message","Name/code is invalid");
			return "login";
		}
	}

}
