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
    private String schoolNumber;


    @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private SDirector director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public SDirector getDirector() {
        return director;
    }

    public void setDirector(SDirector director) {
        this.director = director;
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
