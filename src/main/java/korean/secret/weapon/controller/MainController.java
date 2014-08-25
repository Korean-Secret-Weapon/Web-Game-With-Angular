package korean.secret.weapon.controller;
import java.util.Map;

import korean.secret.weapon.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
    private CommonService commonService;
	
	@RequestMapping(value = "/get")
	public ModelAndView getData(@RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", commonService.select(query));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/join")
	public ModelAndView join(@RequestParam(value="data") Map<String,Object> data) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println();
		System.out.println(data);
		System.out.println();
		
		mav.setViewName("jsonView");
		return mav;
	}
}
