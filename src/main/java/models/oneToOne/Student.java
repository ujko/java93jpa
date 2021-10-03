package models.oneToOne;

import javax.persistence.*;

@Entity
@Table(name = "studenci")
public class Student {
    @Id
    @GeneratedValue
    private int studentId;

    private String studentName;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "my_book_id")
    private StudentBook studentBook;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public StudentBook getStudentBook() {
        return studentBook;
    }

    public void setStudentBook(StudentBook studentBook) {
        this.studentBook = studentBook;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
