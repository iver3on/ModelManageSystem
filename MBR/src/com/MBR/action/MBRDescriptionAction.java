package com.MBR.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Iver3oN Zhang
 * @date 2015-10-23 Impossible is nothing
 */
@Controller
@RequestMapping("description")
public class MBRDescriptionAction {

	@RequestMapping(value = "/reasoning", method = RequestMethod.GET)
	public String reasoning() {
		return "/description/reasoning";
	}

	@RequestMapping(value = "/modelManage", method = RequestMethod.GET)
	public String modelManage() {
		return "/description/modelManage";
	}

	@RequestMapping(value = "/modelPractice", method = RequestMethod.GET)
	public String modelPractice() {
		return "/description/modelPractice";
	}
}
