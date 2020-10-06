package com.kohen.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	private Object newSum;

	@GetMapping("/")
	public String index(HttpSession session) {
		Integer currentSum = (Integer) session.getAttribute("totalSum");
		if (currentSum == null) {
			session.setAttribute("totalSum", 0);
		}
		
		ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
		
		if (fromSession.equals(null)) {
			ArrayList<String> logList =  new ArrayList<String>();
			session.setAttribute("logList",logList);
		}
		
//		ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
//		for(String listItem : fromSession) {
//			
//		}
		
		return "index";
	}
	
	@PostMapping("/farm")
	public String farm(HttpSession session) {
		Integer randomNum = ThreadLocalRandom.current().nextInt(10, 20 + 1);
		Integer currentSum = (Integer) session.getAttribute("totalSum");
		Integer newSum = randomNum + currentSum;
		session.setAttribute("totalSum", newSum);
		
		String timeStamp = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date());
		String logItem = "You entered a farm and earned " + randomNum + " gold. " + "(" + timeStamp + ")";
		ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
		fromSession.add(logItem);
		session.setAttribute("logList",fromSession);
		
		return "redirect:/";
	}
	
	@PostMapping("/cave")
	public String cave(HttpSession session) {
		Integer randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		Integer currentSum = (Integer) session.getAttribute("totalSum");
		Integer newSum = randomNum + currentSum;
		session.setAttribute("totalSum", newSum);
		
		String timeStamp = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date());
		String logItem = "You entered a cave and earned " + randomNum + " gold. " + "(" + timeStamp + ")";
		ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
		fromSession.add(logItem);
		session.setAttribute("logList",fromSession);
		
		return "redirect:/";
	}
	
	@PostMapping("/house")
	public String house(HttpSession session) {
		Integer randomNum = ThreadLocalRandom.current().nextInt(2, 5 + 1);
		Integer currentSum = (Integer) session.getAttribute("totalSum");
		Integer newSum = randomNum + currentSum;
		session.setAttribute("totalSum", newSum);
		
		String timeStamp = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date());
		String logItem = "You entered a house and earned " + randomNum + " gold. " + "(" + timeStamp + ")";
		ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
		fromSession.add(logItem);
		session.setAttribute("logList",fromSession);
		
		return "redirect:/";
	}
	
//	public void addItem(HttpSession session) {
//		ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
//		fromSession.add(logItem);
//		session.setAttribute("logList",fromSession);
//	}
	
	@PostMapping("/casino")
	public String casino(HttpSession session) {
		Integer randomNum = ThreadLocalRandom.current().nextInt(0, 50 + 1);
		Integer currentSum = (Integer) session.getAttribute("totalSum");
		Integer decider = ThreadLocalRandom.current().nextInt(1, 2 + 1);
		String timeStamp = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date());
		
		
		
		if (decider == 1) {
			Integer newSum = randomNum + currentSum;
			session.setAttribute("totalSum", newSum);
			String logItem = "You entered a casino and earned " + randomNum + " gold. " + "(" + timeStamp + ")";
			ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
			fromSession.add(logItem);
			session.setAttribute("logList",fromSession);
			
		} else if (decider == 2) {
			Integer newSum = currentSum - randomNum;
			session.setAttribute("totalSum", newSum);
			String logItem = "You entered a casino and lost " + randomNum + " gold. " + "(" + timeStamp + ")";
			ArrayList<String> fromSession = (ArrayList<String>) session.getAttribute("logList");
			fromSession.add(logItem);
			session.setAttribute("logList",fromSession);
		}
		
		return "redirect:/";
	}
}
