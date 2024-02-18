package ServletsFiles;

import java.io.IOException;
import java.io.PrintWriter;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteImg extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int n = Integer.parseInt(req.getParameter("id"));
		Dao d = new Dao();

		if (d.deleteData(n)) {
			resp.sendRedirect("index.jsp");
		} else {
			out.print("Something Wrong");

		}

	}
}
