package hibernatepractice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "School")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "school_number")
    private int schoolNumber;


    @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private SDirector director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public SDirector getDirector() {
        return director;
    }

    public void setDirector(SDirector director) {
        this.director = director;
    }

    public School(int schoolNumber, SDirector director) {
        this.schoolNumber = schoolNumber;
        this.director = director;
    }

    public School() {
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolNumber='" + schoolNumber + '\'' +
                ", director=" + director.getName() + " id = " + director +
                '}';
    }
}
