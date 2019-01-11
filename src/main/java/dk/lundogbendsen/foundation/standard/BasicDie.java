package dk.lundogbendsen.foundation.standard;

import java.util.Random;

public class BasicDie implements Die {

    private int no = 6;

    @Override
    public void roll() {
        no = new Random().nextInt(6) + 1;
    }

    @Override
    public int get() {
        return no;
    }
}
