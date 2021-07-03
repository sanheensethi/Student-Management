package students.database;
import java.sql.*;
import students.student.Student;
public class Database{
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private boolean insertFlag = false;
	private boolean deleteFlag = false;
	private boolean updateFlag = false;

	public Database(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","sanheen");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean insert(Student st){
		this.insertFlag = false;
		String query = "INSERT INTO students(name,age) VALUES (?,?)";
		try{
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setString(1,st.getName());
			this.pstmt.setInt(2,st.getAge());
			this.pstmt.executeUpdate();
			this.insertFlag = true;
			this.pstmt = null;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return this.insertFlag;
	}

	public boolean delete(int id){
		this.deleteFlag = false;
		String query = "DELETE FROM students WHERE id = ?";
		try{
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setInt(1,id);
			this.pstmt.executeUpdate();
			this.deleteFlag = true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return this.deleteFlag;
	}

	public boolean update(int id,String name){
		this.updateFlag = false;
		String query = "UPDATE students SET name = ? WHERE id = ?";
		try{
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setString(1,name);
			this.pstmt.setInt(2,id);
			this.pstmt.executeUpdate();
			this.updateFlag = true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return this.updateFlag;
	}

	public boolean update(int id,int age){
		this.updateFlag = false;
		String query = "UPDATE students SET age = ? WHERE id = ?";
		try{
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setInt(1,age);
			this.pstmt.setInt(2,id);
			this.pstmt.executeUpdate();
			this.updateFlag = true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return this.updateFlag;
	}

	public ResultSet select(String ... columns){
		ResultSet rs = null;
		String query = "";
		if(columns.length == 0){
			query = "SELECT * FROM students";
		}else{
			query = "SELECT ";
			int i=0;
			for(;i<columns.length-1;i++){
			query = query+columns[i]+",";
		}
			query = query+columns[i]+" ";
			query = query + "FROM students";
		}
		try{
			this.pstmt = this.con.prepareStatement(query);
			rs =this.pstmt.executeQuery();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	return rs;
}

	public ResultSet select(int id,String ... columns){
		ResultSet rs = null;
		String query = "";
		if(columns.length == 0){
			query = "SELECT * FROM students WHERE id = ?";
		}else{
			query = "SELECT ";
			int i=0;
			for(;i<columns.length-1;i++){
			query = query+columns[i]+",";
		}
		query = query+columns[i]+" ";
		query = query + "FROM students WHERE id = ?";
		}
		try{
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setInt(1,id);
			rs = this.pstmt.executeQuery();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return rs;
	}
}