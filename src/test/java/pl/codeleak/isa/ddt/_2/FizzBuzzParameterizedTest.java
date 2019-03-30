package pl.codeleak.isa.ddt._2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// TODO Add runner for parameterized tests
public class FizzBuzzParameterizedTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void fizzBuzzWithLoop() {

        Map<Integer, String> params = new HashMap<>();
        params.put(1, "1");
        params.put(2, "2");
        params.put(3, "Fizz");
        params.put(4, "4");
        params.put(6, "Fizz");
        params.put(5, "Buzz");
        params.put(10, "Buzz");
        params.put(15, "FizzBuzz");
        params.put(30, "FizzBuzz");

        // TODO Test and assert in a loop
    }

    @Test
    public void fizzBuzzWithParametersAnnotation() {
        // TODO Create first parameterized test
    }

    @Test
    public void fizzBuzzWithMethodSource() {
        // TODO Parameterize the test with a method source
    }

    @Test
    public void fizzBuzzWitFileSource() {
        // TODO Parameterize the test with csv source
    }
}