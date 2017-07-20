package testcases;

import org.testng.annotations.Test;

public class conditionExercises {

    public void bootcampAgeChecker(int age){

        if (age >= 65){
            System.out.println("Deelnemer niet toegelaten, check bij de manager.");
        } else if (age > 21){
            System.out.println("Deelnemer toegelaten");
        } else if (age < 21) {
            System.out.println("Deelnemer is te jong");
        } else {
            System.out.println("Er is geen requirement voor gelijk aan 21");
        }
    }

    @Test
    public void testMember(){
        bootcampAgeChecker(19);
        bootcampAgeChecker(21);
        bootcampAgeChecker(24);
        bootcampAgeChecker(64);
        bootcampAgeChecker(65);
    }
}
