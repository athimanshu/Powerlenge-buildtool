package com.powerlenge.getjar.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


@Controller
public class HomeController {

	public static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getHome(Model model) {
		logger.info("home page called.");
		return "home";
	}
	
	
	@RequestMapping(value="/getJar",method = RequestMethod.GET)
	public StreamingResponseBody  getJar(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		logger.info("getJar method called.");
		String aId = request.getParameter("aId");
		String gId = request.getParameter("gId");
		String vId = request.getParameter("vId");
		logger.info("input values : "+ aId +", "+ gId+", "+vId);
		downloadFile(response);
		response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
	    InputStream inputStream = new FileInputStream(new File("C:\\Users\\himanshu_singh\\Downloads\\Attachment.pdf"));
	    return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
		//return "home";
	}
	
	public StreamingResponseBody downloadFile(HttpServletResponse response) throws FileNotFoundException
	{
		logger.info("Inside Download File");
		 response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
		    InputStream inputStream = new FileInputStream(new File("C:\\Users\\himanshu_singh\\Downloads\\Attachment.pdf"));
		    return outputStream -> {
	            int nRead;
	            byte[] data = new byte[1024];
	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	                System.out.println("Writing some bytes..");
	                outputStream.write(data, 0, nRead);
	            }
	        };
		
		
	}
	
}
