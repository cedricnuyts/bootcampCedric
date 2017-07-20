package examples;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {

    @Test
    public void assertStringContains(){
        String text = "Dit is een tekst om te testen.";
        Assertions.assertThat(text).as("Tekst-controle").contains("tekst om te testen");
    }

    @Test
    public void assertIntegerSmallerThan(){
        int x = 5;
        Assertions.assertThat(x).as("Nummer-controle").isLessThan(6);
    }

    @Test
    public void assertBoolean(){
        boolean test = true;
        Assertions.assertThat(test).as("Boolean-controle").isTrue();
    }

}
