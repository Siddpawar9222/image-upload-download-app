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

@WebServlet("/editData")
@MultipartConfig
public class UpdateData extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  
    	 HttpSession session = req.getSession() ;
     int id = (int) session.getAttribute("id");
    	  
    	    Dao d = new Dao() ;
     
		Part p = req.getPart("file");
		String fileName = p.getSubmittedFileName();
		String remark = req.getParameter("remark");

		InputStream file = p.getInputStream();
		
		byte imgData[] = new byte[(int)p.getSize()] ;
		file.read(imgData);
		
		if(imgData.length>0) {
			 d.updateData1(fileName ,remark,imgData,id) ;
		}else {
			 d.updateData2(remark,id) ;
		}
		
		
	    resp.sendRedirect("index.jsp");
     
    	  
    }
}
