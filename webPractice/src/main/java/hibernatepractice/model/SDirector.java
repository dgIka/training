package hibernatepractice.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Director")
public class SDirector {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "director")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private School school;

    public SDirector() {
    }

    public SDirector(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
        school.setDirector(this);
    }

    @Override
    public String toString() {
        return "SDirector [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
