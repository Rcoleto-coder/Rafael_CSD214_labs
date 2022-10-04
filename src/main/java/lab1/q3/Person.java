package lab1.q3;
/**
 * @author Rafael Coleto
 * Date: 9/26/2022
 * This class contains atributes and methods for a Person object
 */
import java.util.Objects;

public class Person {

    public enum Gender{
        FEMALE,
        MALE,
        TRANSGENDER,
        NON_BINARY,
        NOT_SPECIFIED
    }

    // class static variables
    protected static int COUNT;

    // instance variables
    private String firstname;
    private String lastname;
    private int  age;
    private String SIN;
    private Gender gender;


    //Constructors
    public Person(){

        COUNT++;
        this.firstname = "default firstname";
        this.lastname = "default lastname";
        this.age = 0;
        this.SIN = "0000";
        this.gender = Gender.NOT_SPECIFIED;
    }

    public Person(String firstname, String lastname, int age, String SIN, Gender gender) throws Exception {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        setAge(age);
        this.SIN = SIN;
        this.gender = gender;
    }

    public Person(String firstname, String lastname, int age) {
        this(); // calls the no argument constructor. It has to be called first
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    //Getters

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getSIN() {
        return SIN;
    }

    public Gender getGender() {return gender;}

    public static int getCOUNT() {
        return COUNT;
    }

    //Setters

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) throws Exception {
        if (age < 0){
            throw new Exception("Negative ages not allowed");

        }
        this.age = age;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", SIN='" + SIN + '\'' +
                ", Gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && firstname.equals(person.firstname) && lastname.equals(person.lastname) && SIN.equals(person.SIN) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age, SIN, gender);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalizing");
        COUNT--;
        System.out.println(COUNT);

    }

}
