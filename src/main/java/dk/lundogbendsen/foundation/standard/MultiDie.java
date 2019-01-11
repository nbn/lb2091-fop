package dk.lundogbendsen.foundation.standard;

import java.util.Random;

public class MultiDie implements Die {

    private int no = 100;

    @Override
    public void roll() {
        no = new Random().nextInt(100) + 1;
    }

    @Override
    public int get() {
        return no;
    }
}
