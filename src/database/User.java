package database;

public class User {



    private Integer id;
    private  String username;
    private String firstname;
    private String lastname;
    private Integer course;

    public Integer getId() {
        return id;
    }
    public Integer getcourse() {
        return course;
    }
    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return account;
    }

    private String password;
    private  String account;



    public User(String firstname,String lastname,String username,String account,String password,int course){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.account=account;
        this.password=password;
        this.course=course;
    }
    public User(String firstname,String lastname,String username,String account,String password){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.account=account;
        this.password=password;

    }

    public User(Integer id,String firstname,String lastname,String username,String account,String password){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.account=account;
        this.password=password;

        this.id=id;
    }
    public User(Integer id,String firstname,String lastname,String username,String account,int course){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.account=account;
        this.course=course;
        this.id=id;
    }

    public User(Integer id,String firstname,String lastname,String username,String account){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.account=account;

        this.id=id;
    }

}
