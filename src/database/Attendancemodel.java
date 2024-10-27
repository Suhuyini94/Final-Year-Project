package database;

import java.sql.Date;

public class Attendancemodel {

    private Integer Idstudent;
    private Integer ID;
   private String Name;
   private Integer Contact;
   private Integer Course;

    public Date getDateD() {
        return DateD;
    }

    private Date DateD;

    public Integer getIdstudent() {
        return Idstudent;
    }

    public void setIdstudent(Integer idstudent) {
        Idstudent = idstudent;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getContact() {
        return Contact;
    }

    public void setContact(Integer contact) {
        Contact = contact;
    }

    public Integer getCourse() {
        return Course;
    }

    public void setCourse(Integer course) {
        Course = course;
    }

    public Integer getDepartment() {
        return Department;
    }

    public void setDepartment(Integer department) {
        Department = department;
    }

    public Integer getCourlevel() {
        return Courlevel;
    }

    public void setCourlevel(Integer courlevel) {
        Courlevel = courlevel;
    }

    private Integer Department;
    private Integer Courlevel;



    public  Attendancemodel(Integer studentid,String name,Integer course,Integer contact,Integer department,Integer level){
        this.Name=name;
        this.Idstudent=studentid;
        this.Contact=contact;
        this.Department=department;
        this.Courlevel=level;
        this.Course=course;


    }

    public  Attendancemodel(Integer id ,Integer studentid,String name,Integer course,Integer contact,Integer department,Integer level,Date date){
        this.Name=name;
        this.Course=course;
        this.Idstudent=studentid;
        this.Contact=contact;
        this.Department=department;
        this.Courlevel=level;
        this.ID=id;
        this.DateD=date;


    }


}


