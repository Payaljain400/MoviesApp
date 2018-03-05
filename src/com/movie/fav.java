package com.movie;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fav
 */
@WebServlet("/fav")
public class fav extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static int count;
	
	static JSONObject object1=new JSONObject();
	FileWriter jsonFileWriter; 
	static JSONArray jarr= new JSONArray();
	
    public fav() {
        super();  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String rating=request.getParameter("rating");
		String releaseDate=request.getParameter("releaseDate");
		String overview=request.getParameter("overview");
		JSONObject object=new JSONObject();
		JSONParser parser= new JSONParser();
		try {
			try {
				JSONObject count1 = new JSONObject();
				count1 = (JSONObject) parser.parse(new FileReader("/home/sapient/Downloads/sts-bundle/sts-3.9.2.RELEASE/STS_Workspace/MoviesApp/src/com/movie/favo.json"));
				count = Integer.parseInt(String.valueOf(count1.get("count")));
			} catch (Exception e) {
				count=0;
			}
			if(count<10) {
				count++;
		object.put("title",title);
		object.put("rating",rating);
		object.put("releaseDate",releaseDate);
		object.put("overview",overview);
		
		    jsonFileWriter = new FileWriter("/home/sapient/Downloads/sts-bundle/sts-3.9.2.RELEASE/STS_Workspace/MoviesApp/src/com/movie/favo.json");
		    
		    jarr.add(object);
		    object1.put("movie",jarr);
		    object1.put("count",count);
		    jsonFileWriter.write(object1.toString());
		    
		    response.setContentType("text/plain");
            response.getWriter().write("Successfully added to favourite");
            }
			else {
				response.getWriter().write("can only add 10 movies to favourite");
			}
		    }
		catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			if(  jsonFileWriter!= null)
			 jsonFileWriter.close();
		} 
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
