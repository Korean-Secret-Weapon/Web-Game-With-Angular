package korean.secret.weapon.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import korean.secret.weapon.service.CommonService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

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
		mav.addObject("list", commonService.list(query,parseMapJson(data)));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody ModelAndView save(@RequestBody String data,
										   @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.save(query,parseListJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public @ResponseBody ModelAndView update(@RequestBody String data,
											 @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.insert(query,parseMapJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public @ResponseBody ModelAndView delete(@RequestBody String data,
											 @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.insert(query,parseMapJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public @ResponseBody ModelAndView insert(@RequestBody String data,
											 @RequestParam(value="query") String query) throws Exception {
		ModelAndView mav = new ModelAndView();
		commonService.insert(query,parseMapJson(data));
		mav.setViewName("jsonView");
		return mav;
	}
	
	private List<Map<String, Object>> parseListJson(String jsonString){
   	 
	   	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	   	if(jsonString.length()!=0){
		   	JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsonString);
		   	for(int i = 0; i < jsonArray.size(); i++){
			   	Map<String, Object> map = new HashMap<String, Object>();
			   	JSONObject jsonObject = jsonArray.getJSONObject(i);
			   	JSONArray headers = jsonObject.getJSONArray("headers");
			   	for(int y = 0; y < headers.size(); y++){
			   		String headerName = (String) headers.get(y);
			   		map.put(headerName, jsonObject.get(headerName));
			   	}
			   	list.add(map);
		   	} 
	   	}
	   	return list;
   	}
	
	private Map<String, Object> parseMapJson(String jsonString){
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(jsonString.length()!=0){
			JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonString);
			JSONArray headers = jsonObject.getJSONArray("headers");
			for(int y = 0; y < headers.size(); y++){
				String headerName = (String) headers.get(y);
				map.put(headerName, jsonObject.get(headerName));
			}
		}
		return map;
   	}
}
