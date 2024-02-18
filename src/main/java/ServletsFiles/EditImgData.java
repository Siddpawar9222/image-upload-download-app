package ServletsFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.Session;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditImgData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Dao d = new Dao();
		int id = Integer.parseInt(req.getParameter("id"));

		String remark = null;

		ResultSet set = d.selectIdData(id) ;
		try {
			while (set.next()) {
                remark = set.getString("remark");
           }
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		HttpSession session = req.getSession();
		session.setAttribute("remark", remark);
        session.setAttribute("id", id);
		
		resp.sendRedirect("edit.jsp");
		
	}
}
