package com.MBR.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Iver3oN Zhang
 * @date 2015-10-26 Impossible is nothing
 */
@Controller
@RequestMapping("intro")
public class MBRIntroAction {
	@RequestMapping(value = "/MBRintroduce", method = RequestMethod.GET)
	public String introduce() {
		return "/intro/intro";
	}

}
