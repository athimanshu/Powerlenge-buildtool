package com.powerlenge.getjar.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	public static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getHome(Model model) {
		logger.info("home page called.");
		return "home";
	}
	
	
	@RequestMapping(value="/getJar",method = RequestMethod.POST)
	public String getJar(HttpServletRequest request) {
		logger.info("getJar method called.");
		String aId = request.getParameter("aId");
		String gId = request.getParameter("gId");
		String vId = request.getParameter("vId");
		logger.info("All input value : "+ aId +", "+ gId+", "+vId);
		return "home";
	}
}
