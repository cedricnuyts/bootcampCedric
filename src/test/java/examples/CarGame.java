package examples;

import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void startGame(){
        Auto auto = new Auto();
        auto.setColor("Red");
        auto.setBrand("Mercedes");
        auto.setDoors(4);
        auto.setMotorType("Diesel");
        auto.calcTorque(136, 4500);

        Auto autoTwo = new Auto();
        autoTwo.setColor("Pimple Purple");
        auto.setBrand("BMW");
        auto.setDoors(4);
        auto.setMotorType("Gasoline");
        auto.calcTorque(182, 5500);
    }

    @Test
    public void startGameTwo(){
        AutoAdvanced autoAdvanced = new AutoAdvanced("Mercedes", 136, 4500);
        //autoAdvanced.printBrand();
    }
}
