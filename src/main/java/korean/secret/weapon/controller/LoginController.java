package korean.secret.weapon.controller;

import java.util.Map;

import korean.secret.weapon.service.CommonService;
import korean.secret.weapon.service.LoginService;
import korean.secret.weapon.util.JSONToOthers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
    private LoginService loginService;
	
	@Autowired
    private CommonService commonService;
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public @ResponseBody ModelAndView getData(@RequestBody String data) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> param = JSONToOthers.parseMapJson(data);
		
		String result = loginService.loginCheck(param);
		if(result=="success"){
			mav.addObject("userInfo",commonService.map("login.getLoginInfo", param));
		}else{
			mav.addObject("message",result);
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
}
