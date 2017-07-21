package examples;

public class AutoAdvanced {

    public String brand;

    //Constructor (A constructor will always run)
    public AutoAdvanced(String brand, int force, int rpm){
        this.brand = brand;
        System.out.println("Auto is ready to drive.");
        System.out.println("Brand of the car is " + brand + ".");
        calcTorque(force, rpm);
    }

    //Methode (A method needs to be called, for example in the constructor)
    public void calcTorque(int force, int rpm){
        int torque = (force * 5252) / rpm;
        System.out.println("Torque = " + torque);
    }

    //Methode
    public void printBrand(){
        System.out.println(brand);
    }
}
