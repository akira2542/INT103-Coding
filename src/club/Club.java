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
 enum status {
CLOSED,OPEN
}

public class Club {
    private final String fullName;
    private final String nickName;
    private Student[] members;
    private int count;
    private status clubstatus;
    
    public Club(String fullName, String nickName, int maxMembers) {
        this.fullName = (fullName == null)? "no fullname": fullName;
        this.nickName = (nickName == null)? "no nickname": nickName;
        if (maxMembers > 0){
        this.members = new Student[maxMembers];
        }
        else{
        this.members = new Student[5];
        }
        this.count = 0;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public status getClubstatus() {
        return this.clubstatus;
    }

    
    protected boolean subscribe(Student student) {
        if (clubstatus == status.CLOSED || members.length <= this.count){
        return false;
        }
        if (student != null){
         this.members[this.count] = new Student(student.getStudentId(),student.getStudentName());
         this.count++;
         if(this.count >= members.length){
             this.clubstatus = status.CLOSED;
         }
         return true;
        }
            return false;   
    }
    
    protected boolean unsubscribe(Student student) {
            for (int i = 0; i < members.length; i++) {
                if (members[i].equals(student)){
                 if (i == --this.count) {
                    members[i] = null; 
                    this.count--;
                    if (!isfull()) {
                        this.clubstatus = status.OPEN;
                    }
                    return true;
                 }
                 if (i < --this.count) {
                    members[i] = new Student(members[--this.count].getStudentId(),members[--this.count].getStudentName()); 
                    members[--this.count] = null;
                    this.count--;
                    if (!isfull()) {
                        this.clubstatus = status.OPEN;
                    }
                    return true;
                 }
                return false;
                }   
        }
        return false;    
     }

     private boolean isfull() {
         return this.count >= members.length;
     }
    
     protected boolean setInfo(Student student, String newName) {
        Student tempmember = findStudent(student); 
        if (tempmember != null) {
                tempmember.setStudentName(newName);
                return true;
         }
         return false;
     }
    
    private Student findStudent(Student student){
        for (Student member : members) {
            if (member.equals(student)){
             return member;
            }
        }
        return null;
    }

 
    
    
    public String getStudentList() {
        StringBuilder s1 = new StringBuilder();
        for (Student member : members) {
            if (member != null) {
            s1.append(member.getStudentId()).append(" ").append(member.getStudentName()).append("\n");
            }break;
        }
        return "{List Members : "+s1+" }";
    }
        
        
}
