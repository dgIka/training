package hibernatepractice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Passport")
public class Passport{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "passport_number")
    private int passportNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Passport() {

    }

    public Person getPerson() {
        return person;
    }

    public Passport( int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport [person=" + person + ", passportNumber=" + passportNumber + "]";
    }
}
