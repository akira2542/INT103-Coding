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

    public Student(long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    
	protected void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
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
            club.unsubscribe(this);
            return true;
        }
        return false;
    }
     public boolean setClubInfo(Club club, String newName){
        if (newName != null){ 
        club.setInfo(this, newName);
        return true;
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


}
