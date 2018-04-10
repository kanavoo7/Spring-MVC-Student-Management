package com.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class StudentDao {
@Autowired	
JdbcTemplate template;
//@Autowired
//DataSource ds;
public StudentDao(JdbcTemplate template)
{
	this.template=template;
}

public StudentDao()
{
	
}

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}


	//public void setDs(DataSource ds) {
	//this.ds = ds;
//}

	public int save(Student st)
	{
		String sql="insert into student(name,course,number) values('"+st.getName()+"','"+st.getCourse()+"',"+st.getNumber()+")";
	    return template.update(sql);
	}
	
	public int delete(int id)
	{
		String sql="delete from student where id="+id+"";
				   return template.update(sql);
	}
	public List<Student> getStudents(){
		return template.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs,int row) throws SQLException{
				
				Student st1 =new Student();
				st1.setId(rs.getInt(1));
				st1.setName(rs.getString(2));
				st1.setCourse(rs.getString(3));
				st1.setNumber(rs.getInt(4));
								
			return st1;

			}
		});
		
	}
	public JSONArray getJson() {
		java.sql.Connection con;
		java.sql.Statement st;
		ResultSet rs;
		JSONArray jsarr = new JSONArray();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","");
			st=cn.createStatement();
			rs= st.executeQuery("select * from student");
			java.sql.ResultSetMetaData rsmd= rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			while(rs.next()) {
				JSONObject jobj = new JSONObject();
				for(int i=1;i<numCols+1;i++)
				{
					String colName = rsmd.getColumnName(i);
					if(rsmd.getColumnType(i)==java.sql.Types.ARRAY)
						{jobj.put(colName,rs.getArray(i));}
					else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER)
					{jobj.put(colName,rs.getInt(i));}
					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR)
					{
						jobj.put(colName,rs.getString(i));
					}
					
				
				}
				jsarr.put(jobj);
			}
		}catch(Exception e)
		{
			
		System.out.println(e);	
		}
		System.out.println(jsarr.toString());
		
		return jsarr;
		}
		   
	     public String login(Student st) throws SQLException
	     {    
	    	 String page="";
	    	 try {
	 			Class.forName("com.mysql.jdbc.Driver");
	 			java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","");
	 		java.sql.Statement st1 =cn.createStatement();
	 			ResultSet rs= st1.executeQuery("select * from student");
	 			 if(rs.getInt(1)==st.getId() && rs.getString(2).equals(st.getName()))
	 			 {
	 				  page= "studentform";
	 			 }
	 			 else {
	 				 page= "loginform";
	 			 }
	     }catch(Exception e)
	    	 {
	    	    System.out.println(e);
	    	 }
	    	return page;
	     }
	     
	}
