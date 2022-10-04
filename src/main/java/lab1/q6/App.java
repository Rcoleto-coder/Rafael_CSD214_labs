package lab1.q6;
import lab1.q4.Car;
import lab1.q3.Person;
/**
 * @author Rafael Coleto
 * Date: 10/03/2022
 * Car lot application
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final int NUMCARS = 100;
    private Car[] unsoldCars = new Car[NUMCARS];
    private Car[] soldCars = new Car[NUMCARS];
    private int unsoldCurrentIndex = 0;
    private int soldCurrentIndex = 0;
    private Scanner input = new Scanner(System.in);
    private String menu = ""
            + "----------------\n"
            + " 1. Add a Car\n"
            + " 2. Edit a car\n"
            + " 3. Delete an unsold Car\n"
            + " 4. Delete a sold Car\n"
            + " 5. List unsold Cars\n"
            + " 6. List sold Cars\n"
            + " 7. Sell a Car\n"
            + "99. Exit\n"
            + "----------------Please enter the operation to perform (1 to 7 or 99)";

    public void run(){


        boolean done=false;
        while (!done) {
            System.out.println("" + menu);
            try {
                int selection = input.nextInt();

                switch (selection) {
                    case 1:
                        add();
                        break;
                    case 2:
                        edit();
                        break;
                    case 3:
                        System.out.println("Which car would you like to delete ?:");
                        int choice = input.nextInt();
                        input = new Scanner(System.in); // reset the scanner
                        deleteUnsoldCars(choice);
                        break;
                    case 4:
                        deleteSoldCars();
                        break;
                    case 5:
                        listUnsoldCars();
                        break;
                    case 6:
                        listSoldCars();
                        break;
                    case 7:
                        listUnsoldCars();
                        System.out.println("Which car would you like to sell ?:");
                        int chosenCar = input.nextInt();
                        input = new Scanner(System.in); // reset the scanner
                        sellCar(chosenCar);
                        break;
                    case 99:
                        done=true;
                        break;
                    default:
                        System.out.println("You chose incorrectly");

                }
            } catch (InputMismatchException e) {
                System.out.println("You entered an incorrect option, please try again.");
            } catch(UnsupportedOperationException e){
                System.out.println("Unsupported operation.");
            }
        }
        System.exit(0);
    }

    private void add() {
        Car c=new Car();
        input = new Scanner(System.in); // reset the scanner

        System.out.println("Enter the make");
        c.setMake(getInput(c.getMake()));
        System.out.println("Enter the model");
        c.setModel(getInput(c.getModel()));
        System.out.println("Enter the year");
        c.setYear(getInput(c.getYear()));
        unsoldCars[unsoldCurrentIndex]=c;
        unsoldCurrentIndex++;
    }

    private void edit() {

        System.out.println("Which car would you like to edit ?:");
        int choice = input.nextInt();
        input = new Scanner(System.in); // reset the scanner
        if ((choice < unsoldCurrentIndex + 1) && choice > 0) {
            Car c = unsoldCars[choice - 1];
            System.out.println("Make: " + c.getMake());
            c.setMake(getInput(c.getMake()));
            System.out.println("Model: " + c.getModel());
            c.setModel(getInput(c.getModel()));
            System.out.println("Year: " + c.getYear());
            c.setYear(getInput(c.getYear()));
        } else {
            System.out.println("Choice out of bounds");
        }
        System.out.println("");
    }

    private void listUnsoldCars() {
        System.out.println("--------------------");
        System.out.println("List of unsold cars");
        System.out.println("--------------------");
        for(int i=0;i<unsoldCars.length;i++){
            Car c=unsoldCars[i];
            if(c==null)
                break;
            System.out.println( (i+1)+". "+c.getMake() + " - " + c.getModel()+ " - " + c.getYear());
        }
    }

    private void listSoldCars() {
        System.out.println("---------------------");
        System.out.println("List of sold cars");
        System.out.println("---------------------");
        for(int i=0;i<soldCars.length;i++){
            Car c=soldCars[i];
            if(c==null)
                break;
            System.out.println( (i+1)+". "+c.getMake() + " - " + c.getModel()+ " - " + c.getYear());
        }
    }

    private void deleteUnsoldCars(int choice){

        if((choice < unsoldCars.length && choice >0)){
            for (int i = choice-1; i < unsoldCars.length-1; i++) {
                unsoldCars[i] = unsoldCars[i + 1];
            }
            unsoldCars[unsoldCars.length - 1] = null;

        }else{
            System.out.println("Choice out of bounds");
        }
        unsoldCurrentIndex--;
    }
    private void deleteSoldCars(){
        System.out.println("Which car would you like to delete ?:");
        int choice = input.nextInt();
        input = new Scanner(System.in); // reset the scanner
        if((choice < soldCars.length && choice >0)){
            for (int i = choice-1; i < soldCars.length-1; i++) {
                soldCars[i] = soldCars[i + 1];
            }
            soldCars[soldCars.length - 1] = null;

        }else{
            System.out.println("Choice out of bounds");
        }
        soldCurrentIndex--;
    }

    private void sellCar(int chosenCar){
        var newOwner = new Person();

        if((chosenCar < unsoldCars.length && chosenCar >0)){
            var car = unsoldCars[chosenCar-1];

            System.out.println("Enter owner first name: ");
            newOwner.setFirstname(getInput(newOwner.getFirstname()));
            System.out.println("Enter owner last name: ");
            newOwner.setLastname(getInput(newOwner.getLastname()));
            car.setOwner(newOwner);
            soldCars[soldCurrentIndex]=car;
            soldCurrentIndex++;
            deleteUnsoldCars(chosenCar);

        }else{
            System.out.println("Choice out of bounds");
        }
    }

    private String getInput(String s) {
        String ss = input.nextLine();
        if (ss.trim().isEmpty()) {
            return s;
        }
        Scanner input2 = new Scanner(ss);
        return input2.nextLine();
    }

    private int getInput(int i) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return i;
        }
        Scanner input2 = new Scanner(s);
        return input2.nextInt();
    }
    private double getInput(double i) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return i;
        }
        Scanner input2 = new Scanner(s);
        return input2.nextDouble();
    }




}
