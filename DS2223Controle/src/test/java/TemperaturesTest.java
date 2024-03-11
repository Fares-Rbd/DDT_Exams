import org.junit.jupiter.api.Test;
import classes.Thermometer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TemperaturesTest {

    @Test
    void should_return_0_if_empty() {
        int[] temps = {};
        Thermometer thermo = new Thermometer(temps);
        assertEquals(0, thermo.getClosestTempToZero());
    }

    @ParameterizedTest
    @CsvSource({"0,-4,0", "2,-2,2", "5,-5,5", "1,3,1", "3,-3,3"})
    void should_return_5_if_has_5_and_minus_5(int temp1, int temp2, int result) {
        int[] temps = {temp1, temp2};
        Thermometer thermo = new Thermometer(temps);
        assertEquals(result, thermo.getClosestTempToZero());
    }

    @Test
    void should_return_0_if_length_is_zero_or_length_more_than_10000() {

        int[] temps = {};
        Thermometer thermo = new Thermometer(temps);
        assertEquals(0, thermo.getClosestTempToZero());


        Thermometer thermo2 = new Thermometer(temps);
        assertEquals(0, thermo2.getClosestTempToZero());
    }

}
