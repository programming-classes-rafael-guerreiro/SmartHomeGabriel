package com.smart.home.servlet;

import static java.lang.String.valueOf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("devices") // os codigos sao iguais (value = { "/devices" })
public class DevicesServlet extends HttpServlet {

	@Override // GET = leitura
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.getOutputStream();
		// try (PrintWriter writer = resp.getWriter()){
		// writer.append("Hello World");
		// }

		// vai no banco
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to locate myql driver" + e.getMessage());
		}

		String[][] data = new String[2][4];

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_home", "root",
				"")) {

			ResultSet result = connection
					.prepareStatement("select u.user_id, u.name as user_name, d.device_id, d.name as device_name "
							+ "from users u, devices d " + "where u.user_id = d.user_id")
					.executeQuery();

			int line = 0;
			while (result.next()) {
				int column = 0;

				data[line][column++] = valueOf(result.getInt("user_id"));
				data[line][column++] = result.getString("user_id");
				data[line][column++] = valueOf(result.getInt("device_id"));
				data[line][column++] = result.getString("device_id");

				line++;
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong" + e);
		}

		// pego os devices

		// coloca na devices.jsp

		for (int line = 0; line < data.length; line++) {
			System.out.println(data[line]);
		}

		// a linha abaixo serve para que o arquivo exibido a quem navegar seja a
		// servelet e não o arquivo .jsp
		req.getRequestDispatcher("devices.jsp").forward(req, resp);

	}

	@Override // POST = criacao
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND); // URL + HTTP_METHOD
															// was NOT FOUND
	}

	@Override // PUT = alteracao
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND); // URL + HTTP_METHOD
															// was NOT FOUND
	}

	@Override // DELETE = DELECAO
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND); // URL + HTTP_METHOD
															// was NOT FOUND
	}

}
