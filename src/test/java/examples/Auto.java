package examples;

import org.apache.xpath.SourceTree;

public class Auto {

    public void setColor(String carColor){
        System.out.println("The color of the car is " + carColor + ".");
    }

    public void setBrand(String carBrand){
        System.out.println("The brand of the car is " + carBrand + ".");
    }

    public void setDoors(int carDoors){
        System.out.println("The car has " + carDoors + " doors.");
    }

    public void setMotorType(String carMotorType){
        System.out.println("The motor type of the car is " + carMotorType + ".");
    }

    public void calcTorque(int carForce, int carEngineRPM){

        if (carForce < 1 || carEngineRPM < 100){
            System.out.println("Invalid numbers");
        } else {
            System.out.println("The car has a force of " + carForce + ".");
            System.out.println("The car has " + carEngineRPM + " RPMs.");
            int torque = (carForce * 5252) / carEngineRPM;
            System.out.printf("The torque of the car is " + torque + ".");
        }

    }

}
