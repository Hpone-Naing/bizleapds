package com.bizleap.common.ucsy.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Parser {

	public static JSONObject parseJSon(String input) {
		JSONObject json = null;
		try {
			json = (JSONObject) new JSONParser().parse(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
