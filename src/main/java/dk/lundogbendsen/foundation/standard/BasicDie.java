package dk.lundogbendsen.foundation.standard;

import lombok.ToString;

import java.util.Random;

@ToString
@MyAnnotation(greeting = "basicDie")
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
