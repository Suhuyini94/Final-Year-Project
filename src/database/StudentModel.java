package database;

public class StudentModel {
    private  int count=0;

    private int Id;
    private String studentname;
    private String Address;
    private int Contact;
    private int Course;
    private java.sql.Date Date;
    private String Company;
    private String Identity;

    public String getCountry() {
        return Country;
    }
    public int getCourse() {
        return Course;
    }
    public void setCountry(String country) {
        Country = country;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        Level = Level;
    }

    public void setProducts(String products) {
        Products = products;
    }

    private String Country;
    private String name;
    private String Level;
    private  String Products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentName() {
        return studentname;
    }
    public String getProducts() {
        return Products;
    }

    public void setStudentName(String studentname) {
        studentname = studentname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getIdentity() {
       return Identity;
    }

    public StudentModel(String address, String company, int contact, int course, String country, String Level, String identity){

        this.Address=address;
        this.Company=company;
        this.Contact=contact;
        this.Country=country;
        this.Level=Level;
        this.Identity=identity;
        this.Course=course;



    }
    public StudentModel(int id, String address, String company, int contact, int course, String country, String Level, String identity){

        this.Address=address;
        this.Company=company;
        this.Contact=contact;
        this.Country=country;
        this.Level=Level;
        this.Identity=identity;
        this.Id=id;
        this.Course=course;


    }





}
