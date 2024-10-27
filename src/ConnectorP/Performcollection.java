package ConnectorP;

import database.User;
import database.collections;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Performcollection {


    collections db=new collections();

    public Map<String,Integer> getvendorsid() {
       return  db.GetStudentsname();
    }
    public Map<Integer,String> getvendorstable() throws Exception {
    db.connect();
    db.vendorname();

        return  db.GetStudentsnids();
    }


    public void connect() throws Exception {
        db.connect();
}






    public void loadname() throws Exception {

        db.connect();
        db.vendorname();

    }

    public  void addDefaultcate() throws Exception {

    db.connect();
    db.add_default_cate();


    }


    public void adduserC(User person) throws Exception {

        db.adduser(person);
        db.connect();
        db.registerUser();

    }

    public List<User> getAllusers() throws Exception {

    db.connect();
    db.getAlluser();

    return db.getuser();

    }

    public List<User> getusers()  {

        return db.getuser();
    }


    public void loginP(String username,String password) throws Exception {

    db.connect();
        db.getlogins(username,password);

    }

    public Stack<User> getlogU(){
        return db.person;
    }
    public void delectList(int index) throws  Exception{
    db.connect();


    }



public void SetDISPLAYTYPE(String a){
        db.setDisplayType(a);
}
public String getDISPLAYTYPE(){
     return db.getDisplayType();
}

public void delectStack() throws Exception {
        db.connect();

 ;

}

public void AddSaleRecord(int a ,int index) throws Exception {
db.connect();

}
public void  Disconnect(){
    db.disconnected();
}








}
