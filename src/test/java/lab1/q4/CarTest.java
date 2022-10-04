package lab1.q4;
/**
 * @author Rafael Coleto
 * Date: 9/26/2022
 * This is a test for the Equals method from Car class
 */
import lab1.q3.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testEquals() throws Exception {
        Person p1 =new Person("First", "Last",22, "1234", Person.Gender.MALE);
        Person p2 =new Person("First", "Last",22, "1234", Person.Gender.MALE);
        Person p3 =new Person("First", "Last", 20, "12345", Person.Gender.MALE);
        Person p4=p1;


        assertTrue(p1.equals(p2), "Both people must be equal");
        assertTrue(p4.equals(p1), "Both people must be equal");
        assertFalse(p1.equals(p3),"Both people must NOT be equal");

        Car c1 = new Car("Chevrolet", "Camaro", 2012, 1234, p1);
        Car c2 = new Car("Chevrolet", "Camaro", 2012, 1234, p1);
        Car c3 = new Car("Chevrolet", "Camaro", 2012, 12345, p1);
        Car c4 = c1;

        assertTrue(c1.equals(c2), "Both cars must be equal");
        assertTrue(c4.equals(c1), "Both cars must be equal");
        assertFalse(c1.equals(c3),"Both cars must NOT be equal");



    }
}