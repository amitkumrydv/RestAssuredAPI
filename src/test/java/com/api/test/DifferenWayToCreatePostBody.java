package com.api.test;

import java.util.HashMap;

/*
How many ways we create request body
--------------------
1. HashMap
2. Using org-json
3. Using POJO (Plan Old Java Object )
4. Using external json file

*/

public class DifferenWayToCreatePostBody {
	
	
	
	void usingHasMapPost()
	{
		
		HashMap data = new HashMap();
		data.put("name", "Scot");
		data.put("location", "France");
		data.put("phone", "123456789");
		
		String courseArr[] = {"c","d"};
		
		data.put("course",courseArr);
		
	}

}
