package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {

	public String firstName, lastName, day, month, year, email, passWord;

	public void jsonRreader() {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.json";
		File sourceFile = new File(filePath);
		JSONParser parser = new JSONParser();

		try {
			JSONArray jArray = (JSONArray) parser.parse(new FileReader(sourceFile));
			for (Object jsonObject : jArray) {
				JSONObject person = (JSONObject) jsonObject;
				firstName = (String) person.get("f");
				lastName = (String) person.get("l");
				day = (String) person.get("d");
				month = (String) person.get("m");
				year = (String) person.get("y");
				email = (String) person.get("e");
				passWord = (String) person.get("p");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

}
