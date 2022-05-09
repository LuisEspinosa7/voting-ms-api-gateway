/*
 * Developed by: Luis Espinosa, be aware that this project
 * is part of my personal portfolio.
 */
package com.lsoftware.voting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GatewayController.
 * 
 * @author Luis Espinosa
 */
@RestController
@RequestMapping("/fallback")
public class GatewayController {
	
	/**
	 * Info service fallback.
	 *
	 * @return the string
	 */
	@GetMapping("/infoServiceFallback")
	public String infoServiceFallback() {
		return "There was problem in the connection to info service. Please try again later.";
	}
	
	/**
	 * Vote service fallback.
	 *
	 * @return the string
	 */
	@GetMapping("/voteServiceFallback")
	public String voteServiceFallback() {
		return "There was problem in the connection to vote service. Please try again later.";
	}
	
	/**
	 * Results service fallback.
	 *
	 * @return the string
	 */
	@GetMapping("/resultsServiceFallback")
	public String resultsServiceFallback() {
		return "There was problem in the connection to results service. Please try again later.";
	}

}
