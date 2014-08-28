package korean.secret.weapon.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONToOthers {
	public static List<Map<String, Object>> parseListJson(String jsonString){
	   	 
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
	
	public static Map<String, Object> parseMapJson(String jsonString){
		
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
