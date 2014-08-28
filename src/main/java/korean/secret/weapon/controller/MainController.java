package korean.secret.weapon.controller;

import korean.secret.weapon.service.CommonService;
import korean.secret.weapon.util.JSONToOthers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
    private CommonService commonService;
	
	@RequestMapping(value = "/list", method=RequestMethod.POST)
	public @ResponseBody ModelAndView getData(@RequestBody String data,
											  @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", commonService.list(query,JSONToOthers.parseMapJson(data)));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody ModelAndView save(@RequestBody String data,
										   @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.save(query,JSONToOthers.parseListJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public @ResponseBody ModelAndView update(@RequestBody String data,
											 @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.insert(query,JSONToOthers.parseMapJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public @ResponseBody ModelAndView delete(@RequestBody String data,
											 @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.insert(query,JSONToOthers.parseMapJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public @ResponseBody ModelAndView insert(@RequestBody String data,
											 @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.insert(query,JSONToOthers.parseMapJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
}
