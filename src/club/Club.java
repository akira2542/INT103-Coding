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
    CLOSED, OPEN
}

public class Club {
    private final String fullName;
    private final String nickName;
    private Student[] members;
    private int count;
    private status clubstatus;

    public Club(String fullName, String nickName, int maxMembers) {
        this.fullName = (fullName == null) ? "no fullname" : fullName;
        this.nickName = (nickName == null) ? "no nickname" : nickName;
        if (maxMembers > 0) {
            this.members = new Student[maxMembers];
        } else {
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
        if (clubstatus == status.CLOSED || members.length <= this.count) {
            System.out.println("the club is full");
            return false;
        }
        if (student != null) {
            this.members[this.count] = new Student(student.getStudentId(), student.getStudentName(),
                    student.getDepartment());
            this.count++;
            if (this.count >= members.length) {
                this.clubstatus = status.CLOSED;
            }
            return true;
        }
        return false;
    }

    protected boolean unsubscribe(Student student) {
        int lastIndex = this.count - 1;
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) return false;
            if (members[i].equals(student)) {
                if (i == lastIndex) {
                    members[i] = null;
                    this.count--;
                    if (!isfull()) {
                        this.clubstatus = status.OPEN;
                    }
                    return true;
                } else if (i < lastIndex) {
                    System.out.println(this.count);
                    members[i] = new Student(members[lastIndex].getStudentId(), members[lastIndex].getStudentName(),
                            members[lastIndex].getDepartment());
                    members[lastIndex] = null;
                    this.count--;
                    if (!isfull()) {
                        this.clubstatus = status.OPEN;
                    }
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean isfull() {
        return this.count >= members.length;
    }

    protected boolean setInfo(Student student, String newName, String newDepartment) {
        Student tempmember = findStudent(student);
        if (tempmember != null) {
            tempmember.setStudentName(newName);
            tempmember.setDepartment(newDepartment);
            return true;
        }
        return false;
    }

    private Student findStudent(Student student) {
        for (Student member : members) {
            if (member != null && member.equals(student)) {
                return member;
            }
        }
        return null;
    }

    public String getStudentList() {
        StringBuilder s1 = new StringBuilder();
        for (Student member : members) {
            if (member != null) {
                s1.append(member.getStudentId()).append(" ").append(member.getStudentName()).append(" ")
                        .append(member.getDepartment()).append(" | ");
            } else {
                break;
            }
        }
        return "{ " + this.count + " Members : " + s1 + " }";
    }

}
