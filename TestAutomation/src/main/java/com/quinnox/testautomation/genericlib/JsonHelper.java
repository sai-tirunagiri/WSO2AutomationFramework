package com.quinnox.testautomation.genericlib;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JsonHelper {
	public static void toMap(JSONObject object){
		System.out.println("Method call happened");
		Map<String, Object> map = new HashMap<String, Object>();
		
		Iterator<String> keysItr = object.keys();
		while(keysItr.hasNext()){
			String key = keysItr.next();
			Object value = object.get(key);
			
			if(value instanceof JSONArray){
				System.out.println("True");
				 toList((JSONArray) value);
			}
			
			/*else if(value instanceof JSONObject){
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map; */
	}
  }
	
	public static void toList(JSONArray array) throws JSONException{
		List<HashMap<String, Object>> listOfMap = new ArrayList<HashMap<String, Object>>();
		
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			System.out.println(value);
//			if(value instanceof JSONArray){
//				value = to((JSONArray)value);
//			}
//			
//			else if(value instanceof JSONObject){
//				value = toMap((JSONObject) value);
//			}
		//	list.add(value);
		}
	//	return list;
	}
}