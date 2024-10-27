package database;

public class departmentmodel {
    private  int count=0;

    private int Id;
    private String studentname;
    private String Address;
    private int Contact;
    private java.sql.Date Date;


    private String departmentname;
    private String departmenthead;


    public String gethead() {
        return departmenthead;
    }


    public int getId() {
        return Id;
    }



    public java.sql.Date getDate() {
        return Date;
    }


    public departmentmodel(String departh){

        this.departmenthead=departh;



    }
    public departmentmodel(int id, String departh){

        this.departmenthead=departh;

        this.Id=id;


    }





}
