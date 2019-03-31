package pl.codeleak.isa.ddt._1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void returns_1_WhenNumberIs_1() {
        assertThat(fizzBuzz.calculate(1)).isEqualTo("1");
    }

    @Test
    public void returns_2_WhenNumberIs_2() {
        assertThat(fizzBuzz.calculate(2)).isEqualTo("2");
    }

    @Test
    public void returns_Fizz_WhenNumberIs_3() {
        assertThat(fizzBuzz.calculate(3)).isEqualTo("Fizz");
    }

    @Test
    public void returns_Fizz_WhenNumberIs_6() {
        assertThat(fizzBuzz.calculate(6)).isEqualTo("Fizz");
    }

    @Test
    public void returns_Buzz_WhenNumberIs_5() {
        assertThat(fizzBuzz.calculate(5)).isEqualTo("Buzz");
    }

    @Test
    public void returns_Buzz_WhenNumberIs_10() {
        assertThat(fizzBuzz.calculate(10)).isEqualTo("Buzz");
    }

    @Test
    public void returns_FizzBuzz_WhenNumberIs_15() {
        assertThat(fizzBuzz.calculate(15)).isEqualTo("FizzBuzz");
    }

    @Test
    public void returns_FizzBuzz_WhenNumberIs_30() {
        assertThat(fizzBuzz.calculate(30)).isEqualTo("FizzBuzz");
    }

}