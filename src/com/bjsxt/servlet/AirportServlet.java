package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.pojo.Airport;
import com.bjsxt.service.AirportService;
import com.bjsxt.service.impl.AirportServiceImpl;

@WebServlet("/airport")
public class AirportServlet extends HttpServlet{
 
	private AirportService airportService;
	
	@Override
	public void init() throws ServletException {
		//ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		airportService=context.getBean("airportService",AirportServiceImpl.class);
	    
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    
	req.setAttribute("list",airportService.show());
    req.getRequestDispatcher("index.jsp").forward(req, resp);
    
	}
	
}
