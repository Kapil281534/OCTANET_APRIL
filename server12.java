import java.sql.*; 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class server12 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		String s1=request.getParameter("pa");
		String s2=request.getParameter("pb");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/abhidb?useSSL=false";
			String db_uname="root";
			String db_upass="Root";
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
			String q="insert into login(UNAME ,UPASS )values('"+s1+"','"+s2+"')";
			st.executeUpdate(q);
			System.out.println("insert");
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		out.println("<h1>insert<h1>");
		out.println("</body>");
		out.println("</html>");
        out.close();
	}
}

