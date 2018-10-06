
/**
 *
 *  @author Kobyliński Sławomir 
 *
 */


package zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Serwlet
 */
@WebServlet("/Serwlet")
public class Serwlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Serwlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String zapytanieZeStrony = request.getParameter("tytul");// odbieram tekst ze strony
			BazaKsiazek baza = new BazaKsiazek();
			Set<String> wynik = baza.wyszukajPozycje(baza.nawiazPolaczenie(), zapytanieZeStrony);
			String formFile = getInitParameter("gdyJestPytanie");
			ServletContext context = getServletContext();
			InputStream in = context.getResourceAsStream("/WEB-INF/" + formFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null)
				out.print(line);
			if (zapytanieZeStrony.isEmpty()) {
				out.println("</center></body></html>");
			} else if (wynik.isEmpty()) {
				out.println("<h3>W rejestrze brak szukanych pozycji</h3>");
				out.println("</center></body></html>");
			} else {
				out.println("<html><body><center>");
				out.println("<h3>Dostepne sa nastepujace pozycje</h3>");
				out.println("<hr size=\"2\"><br>");
				for (String w : wynik) {
					out.println(w);
					out.println("<br>");					
				}
				out.println("</center></body></html>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
