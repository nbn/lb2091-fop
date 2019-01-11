package dk.lundogbendsen.foundation.standard;

import java.util.List;

public class DiceCup {

    private List<Die> dice;

    public DiceCup(List<Die> dice) {
        this.dice = dice;
    }

    public void roll() {
        dice.forEach( it -> it.roll() );
    }

    public int sum() {
        return dice.stream().mapToInt(it -> it.get()).sum();
    }

}
