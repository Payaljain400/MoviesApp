package com.movie;

import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class Favwatch
 */
@WebServlet("/Favwatch")
public class Favwatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Favwatch() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONParser parser = new JSONParser();
		FileReader fs = new FileReader(
				"/home/sapient/Downloads/sts-bundle/sts-3.9.2.RELEASE/STS_Workspace/MoviesApp/src/com/movie/favo.json");

		try {
			Object obj1 = parser.parse(fs);
			JSONObject jObj = (JSONObject) obj1;
			response.getWriter().write(jObj.toString());

		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			fs.close();
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
