package lab1.q3;
/**
 * @author Rafael Coleto
 * Date: 9/26/2022
 * This application creates person objects
 */
public class App {

    public void run(){
        try{
            Person p1 = new Person();
            Person p2 = new Person("Rafael", "Coleto",34,"1234", Person.Gender.MALE);
            Person p3 = new Person("July", "Doe",25,"9999", Person.Gender.FEMALE);
            Person p4 = new Person("Joe","Doe",23);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(Person.getCOUNT());
            p1 = null;
            System.gc();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
