package examples;

import org.testng.annotations.Test;

public class AboutMethods {

    @Test
    public void printProduct(){

        int x = 4;
        int y = 5;

        //int z = multiply(x,y);
        //System.out.println(z);
        System.out.println(multiply(x, y));
    }

    private int multiply(int x, int y){
        //int z = x * y;
        //return z;
        return x * y;
    }
}
