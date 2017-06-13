import java.util.*;
import java.io.*;
import java.net.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class news{
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException, IOException{
        try{
            String urlString = "https://newsapi.org/v1/articles?source=techcrunch&apiKey=19c4b97018d24f6391e87b86e440e3fc";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			//Use the connect method to create the connection bridge
			conn.connect();
			//Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);

            String newsDataString ="";
    				//Scanner
    		Scanner sc = new Scanner(url.openStream());
            String inputLine="";
            while(sc.hasNext()){
                inputLine+=sc.nextLine();

            }
            sc.close();
            //initializes JSONParser
            JSONParser parse = new JSONParser();
            //parses and casts string version of json into json object
            JSONObject jobj = (JSONObject)parse.parse(inputLine);
            //gets the first json array "articles" and puts into jsonarr_1
            JSONArray jsonarr_1 = (JSONArray) jobj.get("articles");
            //Gets first element of json array "articles"
            JSONObject jsonobj_2 = (JSONObject) jsonarr_1.get(1);
            
                //gets title from jsonobj_2
                String title = (String) jsonobj_2.get("title");
                System.out.println("Title : " + title);
                //gets description from jsonobj_2
                String description = (String) jsonobj_2.get("description");
                System.out.println("Description: " + description);
                conn.disconnect();
            }
            catch(Exception e){
			e.printStackTrace();
		}
    }
}
