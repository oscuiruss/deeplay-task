package test;

import org.junit.Test;
import main.Solution;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {
    @Test
    public void checkTest1() {
        String field = "STWSWTPPTPTTPWPP";
        String species = "Human";
        assertEquals(10, Solution.getResult(field, species));
    }

    @Test
    public void checkTest2() {
        String field = "STWSWTPPTPTTPWPP";
        String species = "Woodman";
        assertEquals(12, Solution.getResult(field, species));
    }

    @Test
    public void checkTest3() {
        String field = "STWSWTPPTPTTPWPP";
        String species = "Swamper";
        assertEquals(15, Solution.getResult(field, species));
    }
}
