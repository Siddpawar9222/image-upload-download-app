<%@page import="java.util.Base64"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/x-icon" href="favicon.png">
	<link rel="stylesheet" href="style.css">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />
	
    <script type="text/javascript" src="index.js"></script>
    <title>Image Uploading and Downloading</title>
  </head>
  <body class="bg-light">
    <div class="container">
      <div class="text-center">
        <h3 class="my-3">Image Upload</h3>
      </div>

      <form
        class="container card"
        action="upload"
        method="post"
        enctype="multipart/form-data"
      >
        <label for="formFileLg" class="form-label my-2 mx-1">Image</label
        ><label id="errormg"></label>
        <input
          class="form-control form-control-lg"
          id="formFileLg"
          type="file"
          name="file"
          accept="image/*"
		  required
          onchange="validateFileType()"
        />
        <label for="formFileLg" class="form-label my-2 mx-1">Remark</label>
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder=""
          aria-label=".form-control-lg example"
		  required
          name="remark"
        />

        <div class="text-center">
          <input type="submit" class="btn btn-primary my-3" value="Upload" />
        </div>
      </form>

      <table>
        <thead>
    <tr>
      <th scope="col">Image</th>
      <th scope="col">Remark</th>
      <th scope="col">Download</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
        <tbody>
        	 <%
    Dao d = new Dao();
    ResultSet set = d.selectData();
    while (set != null && set.next()) {
        int id = set.getInt("id");
        String remark = set.getString("remark");
        String img_name = set.getString("img_name");
        byte[] imageData = set.getBytes("img");
        String base64Image = Base64.getEncoder().encodeToString(imageData);
%>
        <tr>
            <td data-label="Image" class="image-cell"><img src="data:image/jpeg;base64,<%= base64Image %>" alt="Image" width="150px" height="120px"></td>
            <td  data-label="Remark" class="remark-cell"><%= remark %></td>
            <td  data-label="Download"> <a href="data:image/jpeg;base64,<%= base64Image %>" download="<%=img_name%>"><i class="fa-sharp fa-solid fa-download fa-xl"></i></a></td>
            <td data-label="Edit" > <a href="edit?id=<%=id %>"><i class="fa-solid fa-pen-to-square fa-xl"></i></a></td>
           <td data-label="Delete">
           <a href="delete?id=<%=id %>">
           <i class="fa-sharp fa-solid fa-trash fa-xl"></i>
           </a>
           </td>

        </tr>
<%
    }
%>
        	       
        </tbody>
      </table> 

    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
    <script src="https://kit.fontawesome.com/f7a69ac530.js" crossorigin="anonymous"></script>
  </body>
</html>

        