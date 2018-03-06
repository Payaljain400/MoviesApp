package com.movie;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class remove
 */
@WebServlet("/remove")
public class remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	static int count;
	JSONObject object1 = new JSONObject();
	FileWriter jsonFileWriter;
	JSONArray jarr = new JSONArray();

	public remove() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONParser parser = new JSONParser();
		try {
			try {

				object1 = (JSONObject) parser.parse(new FileReader(
						"/home/sapient/Downloads/sts-bundle/sts-3.9.2.RELEASE/STS_Workspace/MoviesApp/src/com/movie/favo.json"));
				count = Integer.parseInt(String.valueOf(object1.get("count")));
				jarr = (JSONArray) object1.get("movie");
				jarr.remove(Integer.parseInt(request.getParameter("id")));

			} catch (Exception e) {
				count = 0;
			}
			if (count != 0) {
				count--;

				jsonFileWriter = new FileWriter(
						"/home/sapient/Downloads/sts-bundle/sts-3.9.2.RELEASE/STS_Workspace/MoviesApp/src/com/movie/favo.json");

				object1.put("movie", jarr);
				object1.put("count", count);
				jsonFileWriter.write(object1.toString());

				response.setContentType("text/plain");
				response.getWriter().write("Successfully removed from favourites");
			} else {
				response.getWriter().write("nothing to remove from favourite");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jsonFileWriter != null)
				jsonFileWriter.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
