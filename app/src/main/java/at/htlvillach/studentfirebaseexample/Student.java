package at.htlvillach.studentfirebaseexample;

/**
 * Created by pupil on 3/22/19.
 */

public class Student {
    private String id = "";
    private String firstname = "";
    private String lastname = "";
    public Student(){

    }

    public Student( String id, String firstname, String lastname){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
