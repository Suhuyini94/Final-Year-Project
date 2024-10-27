package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;
import java.util.Random;
public class collections {


    public List<User> users;
    public Stack<Attendancemodel>AttendanceRecord;
    public HashMap<String, StudentModel> Students;
    public HashMap<String, departmentmodel> departments;
    public HashMap<String,Integer> Studentsnames;
    public HashMap<Integer,String> vendornamids;

    public List<Attendancemodel>FilterAttendence;
    public List<String>categorylist;
    public Stack<User> person;
    public Stack<coursemodel> Courses;
    private int rand;


    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    private String displayType;


    public Connection con;


    public collections(){
        person=new Stack<>();
        Courses=new Stack<>();
    users=new ArrayList<>();

      Students=new HashMap<>();
      departments=new HashMap<>();

        FilterAttendence=new ArrayList<>();
        Studentsnames=new HashMap<>();
        vendornamids=new HashMap<>();
        AttendanceRecord=new Stack<>();

categorylist=new ArrayList<>();





    }

public void adduser(User p){
        users.add(p);
}

    public void addRecord(Attendancemodel p){
        AttendanceRecord.add(p);
    }

    public Stack<Attendancemodel> getAttendanceRecord(){
        return AttendanceRecord;
    }
    public List<User> getuser(){
     return users;
    }
    public void loginPerson(User p){
        person.push(p);
    }

    public void addCourse(coursemodel p){
        Courses.push(p);
    }
    public Stack<User> getlectu(){
        return person;
    }
    public Stack<coursemodel> getCourses(){
        return Courses;
    }


    /** stack   ADD    */

public void FilterAttendent(Integer a){

for(Attendancemodel g:AttendanceRecord){
    if(Objects.equals(a, g.getDateD())){
        FilterAttendence.add(g);

    }

}

}
    /** *******************REMOVE FROM  STACK ***********************/







    /*** GET GOOD FROM stack***********************************/



/*****

*

 / **************LIST FOR ADD CATEGORY 8 TO 11 ****************************************/
/** add */

    public void add_studentname(String name,Integer id){
        Studentsnames.put(name,id);
    }
    public void add_studentids(Integer id,String name){
        vendornamids.put(id,name);
    }
    public Map<String,Integer> GetStudentsname(){
    return Studentsnames;
    }
    public Map<Integer,String> GetStudentsnids(){
        return vendornamids;
    }
/** *****REMOVE FROM LIST************************************ */



/**********END ************************************ **/


/********************** ADD******************/




/****************************        STORE VENDOR DETAILS USING HASHMAP***/


public void AddStudent(String name, StudentModel detail){
    Students.put(name,detail);
}
    public void AddDepartment(String name, departmentmodel detail){
        departments.put(name,detail);
    }


public HashMap<String, StudentModel> GetStudents(){
    return
            Students;
}

    public HashMap<String, departmentmodel> GetDepartments(){
        return
                departments;
    }
public void removedepartment(String n){
    departments.remove(n);
}
/*************** end of hashmap****/

/********   DATABASE CONNECTION *******************************************/
    public void connect() throws Exception  {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver connected");


    String mysqlurl="jdbc:mysql://localhost:3306/institution";
    con= DriverManager.getConnection(mysqlurl,"root","Legon@25");
        System.out.println("driver connected");
        Statement statement = con.createStatement();


        String studenttable = "CREATE TABLE IF NOT EXISTS Students ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(50) NOT NULL,"
                + "address VARCHAR(30) DEFAULT NULL,"
                + "firm VARCHAR(50) DEFAULT NULL,"
                + "contact_number INT DEFAULT NULL,"
                + "course INT DEFAULT NULL,"
                + "country VARCHAR(30) DEFAULT NULL,"
                + "level VARCHAR(30) DEFAULT NULL,"
                + "identity VARCHAR(100) DEFAULT NULL"
                + ")";


        String attendancetable = "CREATE TABLE IF NOT EXISTS attendance ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nameid INT NOT NULL,"
                + "name VARCHAR(50) NOT NULL,"
                + "course INT DEFAULT NULL,"
                + "contact VARCHAR(30) DEFAULT NULL,"
                + "department INT DEFAULT NULL,"
                + "level INT DEFAULT NULL,"
                + "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";


        String coursetable = "CREATE TABLE IF NOT EXISTS courses ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "coursename VARCHAR(50) NOT NULL,"
                + "level INT DEFAULT NULL,"
                + "department INT DEFAULT NULL,"
                + "Semester VARCHAR(30) DEFAULT NULL"

                + ")";

        String departmenttable = "CREATE TABLE IF NOT EXISTS department ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(50) NOT NULL,"
                + "head VARCHAR(30) DEFAULT NULL"
                + ")";

        String usertable = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "firstname VARCHAR(50) DEFAULT NULL,"
                + "lastname VARCHAR(50) DEFAULT NULL,"
                + "username VARCHAR(50) DEFAULT NULL,"
                + "account VARCHAR(50) DEFAULT NULL,"
                + "course INT DEFAULT NULL,"
                + "password VARCHAR(50) DEFAULT NULL"
                + ")";


        statement.executeUpdate(studenttable);
        statement.executeUpdate(departmenttable);
      statement.executeUpdate(usertable);
        statement.executeUpdate(coursetable);
        statement.executeUpdate(attendancetable);
statement.close();

    }


    /*** DISCONNECT***************************/
    public void disconnected()  {
if(con !=null){
    try{
        con.close();
        System.out.println("connection close");
    }
    catch(SQLException e){
      System.out.println("not close");
    }

}
    }






    /**** add default catgories   *****/

    public void add_default_cate() throws SQLException {
String loader="SELECT * from drugcategories";
Statement statement=con.createStatement();
ResultSet results=statement.executeQuery(loader);

if(results.next()){

}
else{
    results.close();
    statement.close();


}















    }








    /****************************sAVE VENDORS**********************************/
public void save_To_database_students() throws Exception {
    String Doc="insert into Students (name,address,firm,contact_number,course,country,level,identity) values(?,?,?,?,?,?,?,?)";
    PreparedStatement insertDoc=con.prepareStatement(Doc);

    for(HashMap.Entry<String, StudentModel>e:Students.entrySet()){
    String name=e.getKey().toString();
    String add=e.getValue().getAddress();
   int cont=e.getValue().getContact();
    String comp=e.getValue().getCompany();
    String count=e.getValue().getCountry();
    int course=e.getValue().getCourse();
    String level=e.getValue().getLevel();
    String identity=e.getValue().getIdentity();
    int size=Students.size()+1;
    insertDoc.setString(1,name);
    insertDoc.setString(2,add);
    insertDoc.setString(3,comp);
    insertDoc.setInt(4,cont);
    insertDoc.setInt(5,course);
    insertDoc.setString(6,count);
    insertDoc.setString(7,level);
   insertDoc.setString(8,identity);

    insertDoc.executeUpdate();



}

    insertDoc.close();

}









    public void save_To_database_department() throws Exception {
        String Doc="insert into department (name,head) values(?,?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);
        for(HashMap.Entry<String, departmentmodel>e:departments.entrySet()){
            String name=e.getKey().toString();
            String head=e.getValue().gethead();

            int size=Students.size()+1;
            insertDoc.setString(1,name);
            insertDoc.setString(2,head);

            insertDoc.executeUpdate();



        }

        insertDoc.close();

    }



    public void registerUser() throws SQLException {
        String Doc="insert into users (firstname,lastname,username,account,password) values(?,?,?,?,?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);
        Iterator hash = Students.entrySet().iterator();
        for(User u:users){
           String firstname=u.getFirstname();
           String lastname=u.getLastname();
           String username=u.getUsername();
           String account=u.getAccount();
           String password=u.getPassword();
            int size=Students.size()+1;
            insertDoc.setString(1,firstname);
            insertDoc.setString(2,lastname);
            insertDoc.setString(3,username);
            insertDoc.setString(4,account);
            insertDoc.setString(5,password);
            insertDoc.executeUpdate();
        }
        System.out.println(users);
        users.clear();
        insertDoc.close();
    }


    public void TakeAttendance() throws SQLException {
        String Doc="insert into attendance (nameid,name,course,contact,department,level) values(?,?,?,?,?,?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);
        Iterator hash = Students.entrySet().iterator();
        for(Attendancemodel u:AttendanceRecord){
            Integer nameid=u.getIdstudent();
            String name=u.getName();
            Integer course=u.getCourse();
            Integer contact=u.getContact();
            Integer department=u.getDepartment();
            Integer level=u.getCourlevel();
            int size=Students.size()+1;
            insertDoc.setInt(1,nameid);
            insertDoc.setString(2,name);
            insertDoc.setInt(3,course);
            insertDoc.setInt(4,contact);
            insertDoc.setInt(5,department);
            insertDoc.setInt(6,level);
            insertDoc.executeUpdate();
        }
        System.out.println(users);
        users.clear();
        insertDoc.close();
    }



    public void Load_attendace() throws SQLException {
        AttendanceRecord.clear();
        String loader="select * from attendance";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            int nameid=result.getInt("nameid");
            String name=result.getString("name");
            int course=result.getInt("course");
            int contact=result.getInt("contact");
            int department=result.getInt("department");
            Date date=result.getDate("date");

            int level=result.getInt("level");
            addRecord(new Attendancemodel(id,nameid,name,course,contact,department,level,date));
        }
        for(Map.Entry<String, StudentModel>e:GetStudents().entrySet()){
        }
        System.out.println(Students);
        result.close();
        state.close();


    }



























    public void registerLecturer() throws SQLException {
        String Doc="insert into users (firstname,lastname,username,account,course,password) values(?,?,?,?,?,?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);

        for(User u:users){
            String firstname=u.getFirstname();
            String lastname=u.getLastname();
            String username=u.getUsername();
            String account=u.getAccount();
            String password=u.getPassword();
          int course=u.getcourse();
            int size=Students.size()+1;
            insertDoc.setString(1,firstname);
            insertDoc.setString(2,lastname);
            insertDoc.setString(3,username);
            insertDoc.setString(4,account);
            insertDoc.setInt(5,course);
            insertDoc.setString(6,password);
            insertDoc.executeUpdate();
        }

        users.clear();
        insertDoc.close();
    }

    public void getlogins(String username,String password) throws SQLException {


        String doc = "SELECT * FROM users WHERE username= ? AND password = ? ";

       PreparedStatement statement=con.prepareStatement(doc);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet result=statement.executeQuery();
        while(result.next()){
         loginPerson(new User(result.getInt("id"),
                      result.getString("firstname"),result.getString("lastname"),
                      result.getString("username"),result.getString("account"),result.getString("password")));
        }
statement.close();

        result.close();

    }


    public void getlectures() throws SQLException {


        String doc = "SELECT * FROM users WHERE account= ? ";

        PreparedStatement statement=con.prepareStatement(doc);
        statement.setString(1,"Lecturer");
        ResultSet result=statement.executeQuery();
        while(result.next()){
            loginPerson(new User(result.getInt("id"),
                    result.getString("firstname"),result.getString("lastname"),
                    result.getString("username"),result.getString("account"),result.getInt("course")));
        }
        statement.close();

        result.close();

    }



    public void getAlluser() throws SQLException {
users.clear();
        String Doc="SELECT * FROM users ";

        Statement statement=con.createStatement();
        ResultSet result=statement.executeQuery(Doc);
        while(result.next()){
            System.out.println(  result.getString("firstname"));
                adduser(new User(result.getInt("id"),
                        result.getString("firstname"),result.getString("lastname"),
                        result.getString("username"),result.getString("account"),result.getString("password")));
        }
        statement.close();
        result.close();
    }












    /********    adding to database  using *****************/



    public void saveCourses() throws SQLException {

        int size= new Random().nextInt(99001) + 1000;
        String Doc="insert into courses(coursename,level,department,semester) values(?,?,?,?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);
        System.out.println(Courses.size());
        for(coursemodel g:Courses){
            int id=g.getId();

            String  coursename=g.getCoursename();
            int level=g.getlevel();
            String semester=g.getSemester();
            int department=g.getDepartment();

            insertDoc.setString(1,coursename);

            insertDoc.setInt(2,level);
            insertDoc.setInt(3,department);
            insertDoc.setString(4,semester);
            insertDoc.executeUpdate();

        }



       Courses.clear();


    }


    /**************** queues *********************************************************************/



/********           Storing product with list ************/

    String gh="d";


    public void LoadCourse() throws SQLException {
      Courses.clear();

        String loader="select * from courses ORDER BY coursename DESC";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String coursen=result.getString("coursename");
         int level=result.getInt("level");
            int department=result.getInt("department");
            String sem=result.getString("semester");
            addCourse(new coursemodel(id,coursen,level,sem,department));
        }


        result.close();
        state.close();

    }




    public void vendorname() throws SQLException {
        vendornamids.clear();
        Studentsnames.clear();
        String loader="select name, id from Students";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            String name=result.getString("name");
            int id=result.getInt("id");
            add_studentname(name,id);
            add_studentids(id,name);

        }
        result.close();
        state.close();
    }







    public void Load_data_v() throws SQLException {

        Students.clear();
        String loader="select * from Students";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String name=result.getString("name");
            String address=result.getString("address");
            String company=result.getString("firm");
            int contact=result.getInt("contact_number");
            int couser=result.getInt("course");
            String country=result.getString("country");
            String city=result.getString("level");
            String identity=result.getString("identity");
            AddStudent(name,new StudentModel(id,address,company,contact,couser,country,city,identity));

        }

        for(Map.Entry<String, StudentModel>e:GetStudents().entrySet()){

        }

        System.out.println(Students);
        result.close();
        state.close();

    }





    public void Load_data_departmentrecord() throws SQLException {

        departments.clear();
        GetDepartments().clear();
        String loader="select * from department";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String name=result.getString("name");
            String head=result.getString("head");

            AddDepartment(name,new departmentmodel(id,head));

        }



        result.close();
        state.close();

    }





}


