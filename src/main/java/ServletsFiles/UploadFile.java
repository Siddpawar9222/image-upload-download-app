package ServletsFiles;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadFile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Dao d = new Dao();
	

		Part p = req.getPart("file");
		String fileName = p.getSubmittedFileName();
		String remark = req.getParameter("remark");

		InputStream file = p.getInputStream();
		byte imgData[] = new byte[(int)p.getSize()] ;
		file.read(imgData);
		System.out.println(d.insertData(fileName, remark,imgData));
		
		resp.sendRedirect("index.jsp");

  }
}
