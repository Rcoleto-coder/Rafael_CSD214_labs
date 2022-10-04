
package lab1.q4;

import lab1.q3.Person;

/**
 * @author Rafael Coleto
 * Date: 9/26/2022
 *
 */

public class App {
    public void run(){

        try{
            Person p1 =new Person("First", "Last",22, "1234", Person.Gender.MALE);
            Person p2 =new Person("First", "Last",22, "1234", Person.Gender.MALE);
            Person p3 =new Person("First", "Last", 20, "12345", Person.Gender.MALE);
            Person p4=p1;

            if(p1 == p2)
                System.out.println("equal");
            else
                System.out.println("not equal");


            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);

            Car c1 = new Car("Chevrolet", "Camaro", 2012, 1234, p1);
            Car c2 = new Car("Chevrolet", "Camaro", 2012, 1234, p1);
            Car c3 = new Car("Chevrolet", "Camaro", 2012, 12345, p1);
            Car c4 = c1;

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);




        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
