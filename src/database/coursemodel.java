package database;

public class coursemodel {
    private  int count=0;

    private int Id;
    private String Semester;

    private int level;

    private String Coursename;
    private int Department;


    public String getCourse() {
        return Coursename;
    }


    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        Level = Level;
    }





    private String Level;





    public int getId() {
        return Id;
    }


    public String getSemester() {
        return Semester;
    }


    public void setSemester(String Semester) {
        Semester = Semester;
    }





    public int getlevel() {
        return level;
    }

    public void setlevel(int level) {
        level = level;
    }




    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String Coursename) {
        Coursename = Coursename;
    }

    public int getDepartment() {
        return Department;
    }

    public coursemodel(String Coursename, int level,  String semester,int Department){
        this.Coursename=Coursename;
        this.level=level;
        this.Semester=semester;
        this.Department=Department;

    }
    public coursemodel(int id,String Coursename, int level,String semester,int Department){

        this.Coursename=Coursename;
        this.level=level;
        this.Semester=semester;
        this.Department=Department;
        this.Id=id;



    }





}
