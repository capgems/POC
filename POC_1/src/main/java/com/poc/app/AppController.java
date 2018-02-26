/**
 * 
 */
package com.poc.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shysatya
 *
 */
@Controller
public class AppController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("login", true);
		return "index";
	}
	
}
