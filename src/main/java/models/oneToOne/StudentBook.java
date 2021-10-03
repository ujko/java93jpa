package models.oneToOne;

import javax.persistence.*;

@Entity
@Table(name = "ksiazki")
public class StudentBook {
    @Id
    @GeneratedValue
    private int bookId;

    private String bookName;

    @OneToOne(mappedBy = "studentBook")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "StudentBook{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", student=" + student +
                '}';
    }
}
