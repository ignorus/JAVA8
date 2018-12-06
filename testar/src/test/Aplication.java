package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Aplication {

    @Test
    @DisplayName("Testar se bibliotecas funcionam")
    public void Test(){
        int i = 300;
        Assertions.assertEquals(300, i);
    }
}
