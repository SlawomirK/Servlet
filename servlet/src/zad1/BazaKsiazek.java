
/**
 *
 *  @author Kobyliński Sławomir S12410
 *
 */
package zad1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class BazaKsiazek {
	private Connection con;		

	public Set<String> wyszukajPozycje(Connection con, String string) {
		// TODO szuka w bazie pozycji zawirających string
		Set<String> set = new HashSet<>();
		ResultSet rs = null;
		Statement polecenieSelect = null;
		try {// SELECT * FROM `biblioteka` WHERE autor like "%dumas%"||tytul like "%dumas%"
			polecenieSelect = con.createStatement();
			rs = polecenieSelect.executeQuery(
					"select * from biblioteka where autor like \"%" + string + "%\"|| tytul like \"%" + string + "%\"");
			while (rs.next()) {
				set.add("\"" + rs.getString(1) + "\" autor " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				polecenieSelect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return set;
	}

	public Connection nawiazPolaczenie()  {
		// TODO  !!!!!!!!!!!!!!!!!1hasło jawne
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");			
			con = DriverManager.getConnection(
					"jdbc:mysql://db4free.net:3306/baza_do_testow?autoReconnect=true&useSSL=false", "slawek",
					"haslo_do_bazy");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
/*
	private static void wypelnijBazeDanymiZPliku(Connection con, String string) {
		// w pliku txt są dane w formacie np "1. Duma i uprzedzenie - Jane Austen" to
		// już dla zabawy i przypomnienia sobie obróbki stringów. baza danych oczywiście nieprawidłowo
		// zrobiona bo tylko jedna tabela ale przyjąłem że to zadanie ma na celu przećwiczenie jdbc a nie budowy
		// relacyjnych baz danych. Przebudowa kodu aby wypełniał np dwie tabele tytuly i autorzy to już szczegół.
		Statement statement = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			statement = con.createStatement();
			fr = new FileReader(string);
			Reader in = new InputStreamReader(new FileInputStream(string));
			br = new BufferedReader(in);
			String linia = "";
			String tytul = "", autor = "";
			while ((linia = br.readLine()) != null) {
				tytul = linia.substring(linia.indexOf(".") + 1, linia.indexOf("–") - 1).trim();
				autor = linia.substring(linia.indexOf("–") + 1).trim();
				System.out.println("tytul " + tytul + " autor " + autor);
				statement.executeUpdate(
						"insert into biblioteka(autor,tytul)" + "values (\"" + autor + "\",\"" + tytul + "\");");
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}*/

}
