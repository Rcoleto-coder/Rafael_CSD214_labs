package lab1.q4;

import lab1.q3.Person;
import java.util.Objects;
/**
 * @author Rafael Coleto
 * Date: 9/26/2022
 * This class contains atributes and methods for a Car object
 */
public class Car {

    //class variable
    private static int COUNT;

    //instance variables
    private String make;
    private String model;
    private int  year;

    private int VIN;
    private Person owner;

    //Constructors

    public Car(){
        setCOUNT(1);
        this.make = "default make";
        this.model = "default model";
        this.year = 9999;
        this.VIN = 0000;
        this.owner = new Person();
    }

    public Car(String make, String model, int year, int vin, Person owner) {
        this();
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = vin;
        this.owner = owner;
    }

    public Car(String make, String model, int year) {
        this();
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String make, String model, int year, Person owner) {
        this();
        this.make = make;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    public Car(String make) {
        this();
        this.make = make;
    }
    //Getters

    public static int getCOUNT() {
        return COUNT;
    }

    public static void setCOUNT(int COUNT) {
        Car.COUNT += COUNT;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    //Methods

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", VIN=" + VIN +
                ", owner=" + owner.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && VIN == car.VIN && make.equals(car.make) && model.equals(car.model) && owner.equals(car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, VIN, owner);
    }

    @Override
    protected void finalize() throws Throwable {
        setCOUNT(-1);
        super.finalize();
        System.out.println("car destroyed");
    }


}


