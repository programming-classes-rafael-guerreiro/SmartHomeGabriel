package com.smart.home.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = { "/hello-world" })
public class HelloWorldServlet extends HttpServlet {

	@Override // GET = leitura
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getOutputStream();
		try (PrintWriter writer = resp.getWriter()){
			writer.append("Hello World");
		}
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
