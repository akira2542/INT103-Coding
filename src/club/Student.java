/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club;


/**
 *
 * @author int105
 */
public class Student {
        private long studentId;
        private String studentName;
        private String department;

    public Student(long studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }
    
	protected void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    protected void setDepartment(String department) {
        this.department = department;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public String getDepartment() {
        return department;
    }
    
    public boolean subscribeToClub(Club club){
        if (club != null){
        club.subscribe(this);
        return true;
        }
        return false;
    }
    
    public boolean unSubToClub(Club club){
        if (club != null){
            return club.unsubscribe(this);
        }
        return false;
    }
     public boolean setClubInfo(Club club, String newName,String newDepartment){
        if (newName != null && newDepartment != null){ 
            return club.setInfo(this, newName,newDepartment);
        }
        return false;
     }   


    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return this.studentId == other.studentId;
    }
    
    //test
//    public static void main(String[] args) {
//        Student student = new Student(100,"Hello1");
//        Student student2 = new Student(200,"Hello2");
//        Student student3 = new Student(100,"Hello3");
//        Club club = new Club("Hey","Yo",5);
//        student.subscribeToClub(club);
//        student2.subscribeToClub(club);
//        student3.subscribeToClub(club);
//        System.out.println(club.getStudentList());
//        System.out.println(student.unSubToClub(club));
//        System.out.println(club.getStudentList());
//        student.setClubInfo(club, "newName");
//        System.out.println(club.getStudentList());
//    }

}
