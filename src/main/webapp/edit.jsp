<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Data</title>
 <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />
</head>
<body class="bg-light">
<% 
    
String remark =(String) session.getAttribute("remark");
%>
    <div class="container">
      <div class="text-center">
        <h3 class="my-3">Edit Image</h3>
      </div>
      <form
        class="container card"
        action="editData"
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
          onchange="validateFileType()"
        />
        <label for="formFileLg" class="form-label my-2 mx-1">Remark</label>
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder=""
          aria-label=".form-control-lg example"
          name="remark"
          value="<%=remark %>"
        />

        <div class="text-center">
          <input type="submit" class="btn btn-primary my-3" value="Edit" />
        </div>
      </form>
      </div>
      
          <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
     </body>
</html>