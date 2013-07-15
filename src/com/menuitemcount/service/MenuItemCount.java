package com.menuitemcount.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class MenuItemCount {

	Long idValueCount = 0L;
	public void calculateMenuItem(){

		try{

			String filePath = "src\\\\com\\\\menuitemcount\\\\data\\\\inputFile.txt";

			// Process the file line by line
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			// Set JSON parser
			JSONParser parser = new JSONParser();
			String line;
			
			// Read line
			while( ( line = br.readLine() ) != null ){

				// parse string to object - this line can be avoided
				Object object = parser.parse(line);
				
				// Convert string to JSON string
				JSONObject menu = (JSONObject) object;

				// Display menu line 
				System.out.println("menu=" +menu.toJSONString());
				
				// Fetch items array from the menu Object
				JSONObject items = (JSONObject) menu.get("menu");

				// Display items line
				System.out.println("items="+ items.toJSONString());
				
				// Fetch items Array
				JSONArray itemsArray = (JSONArray) items.get("items");

				// Display items Array
				System.out.println("itemsArray="+ itemsArray.toJSONString());
				
				// Set and iterator on itemsArray
				Iterator<JSONObject> it = itemsArray.iterator();

				while( it.hasNext() ){
					
					// Read each element from the array
					JSONObject element = (JSONObject) it.next();

					// Do not process if array element is null
					if( element != null ){
						
						// Check if a label exists
						boolean labelExists = element.containsKey("label");
						
						// Calculate Id values
						if(labelExists){
							// Fetch id value from id field
							Long idValue = (Long) element.get("id");
							System.out.println("idValue= "+ idValue);

							idValueCount = idValueCount + idValue;
							System.out.println("idValueCount="+ idValueCount);
						}
					}
				}

				System.out.println("Id value = "+ idValueCount);
				idValueCount = 0L;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
