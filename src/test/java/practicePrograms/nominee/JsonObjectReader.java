package practicePrograms.nominee;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonObjectReader {
	public String jr(String key) throws Throwable, JsonSyntaxException, FileNotFoundException {
		/*parse the data from the json*/
		JSONParser jp= new JSONParser();
		Object obj= jp.parse(new FileReader("D:\\Test Yantra\\Project doc\\LIM_SPRINT-2\\Jsondata.json"));
		/*downcasting the object into jsonObject automatically all the data will be stored into the form */
		JSONObject map= (JSONObject)obj;
		String data=(String)map.get("key");
		return data;
		
	}

}
