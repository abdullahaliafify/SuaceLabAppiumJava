package utilits;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonReader {

    public static Object [][] getJsonData(String Json_Path,String Json_Data,int Json_attributes) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(Json_Path));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get(Json_Data);

        Object[][] array = new String[jsonArray.size()][Json_attributes];
        for (int i = 0 ; i < jsonArray.size(); i++)
        {
                JSONObject obj1 = (JSONObject) jsonArray.get(i);
                array[i][0] = String.valueOf(obj1.get("Username"));
                array[i][1] = String.valueOf(obj1.get("Password"));
                array[i][2] = String.valueOf(obj1.get("Firstname"));
                array[i][3] = String.valueOf(obj1.get("Lastname"));
                array[i][4] = String.valueOf(obj1.get("PostalCode"));
        }
        return  array;


    }

}
