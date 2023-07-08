package edu.jsp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.jsp.dao.UserDao;

@Controller
public class DashBoardController {
	@Autowired
	
	private UserDao user;
	
	
}
