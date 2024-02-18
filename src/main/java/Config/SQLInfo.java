package Config;

public class SQLInfo {
   	public static final String URL = "jdbc:mysql://localhost:3306/jspservletprojects" ;
	public static final String USERNAME = "root" ;
	public static final String PASSWORD = "123456" ;
	public static final String INSERTQ = "insert into imagedetails(img_name,remark,img) values(?,?,?)" ;
    public static final String SELECTQ = "select * from imagedetails" ;
    public static final String DELETEQ = "delete from imagedetails where id=?" ;
    
    public static final String SELECTIDQ = "select * from imagedetails where id=?" ;
    
    public static final String UPDATEQ1 = "update imagedetails set img_name=? ,remark=? ,img=? where id=?" ;
    public static final String UPDATEQ2 = "update imagedetails set remark=? where id=?" ; 
    

}

