package com.cdac.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * URL - http://host:port/ctx/test/test1 , GET
	 * Resp - dyn resp with time stamp
	 * Entry in H.M (HandlerMapping)
	 * Key - /test/test1
	 * Value - TestController.testModelAndView
	 */
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test model n view");
		/*
		 * Ctor of o.s.w.s.ModelAndView(String LVN , 
		 * String modelAttrName
		 * ,Object modelAttrValue)
		 * ModelAndView - class that holds model n view together.
		 * 
		 */
		return new ModelAndView("test/display", 
				"server_ts", LocalDateTime.now());
		/*
		 * Handler rets ModelAndView -> D.S 
		 * D.S -> extracts LVN -> V.R
		 * V.R -> AVN (/WEB-INF/views/test/display.jsp) -> D.S
		 * -> chks for model attributes 
		 * -> present -> adds model attribute under req scope
		 * -> forwards (rd.forward) -> view layer
		 * 
		 */
	}
	

}
