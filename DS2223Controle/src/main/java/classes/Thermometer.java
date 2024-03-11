package classes;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.sort;

public class Thermometer {

    private final int[] temps;

    public Thermometer(int[] temps) {
        this.temps = temps;
    }

    public int getClosestTempToZero() {

        int closestTemp = 0;
        int distance = Integer.MAX_VALUE;

        if (this.temps.length == 0 || this.temps.length > 10000) {
            return 0;
        }

        for (int temp : temps) {
            if (Math.abs(temp) < distance || (Math.abs(temp) == distance && temp > 0))
                closestTemp = temp;

            distance = Math.abs(temp);
        }
        return closestTemp;
    }
}
