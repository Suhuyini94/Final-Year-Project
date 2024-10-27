package database;

public class lecturermodel {


    private int Id;



    private String Lecturename;
    private int coursename;


    public String getLecturename() {
        return Lecturename;
    }





    public int getId() {
        return Id;
    }





    public int getcourse() {
        return coursename;
    }

    public void setcourse(int coursename) {
        coursename = coursename;
    }






    public lecturermodel(String lecture, int course){
        this.Lecturename=lecture;
        this.coursename=course;


    }
    public lecturermodel(int id,String lecture, int course){

        this.Lecturename=lecture;
        this.coursename=course;
        this.Id=id;



    }





}
