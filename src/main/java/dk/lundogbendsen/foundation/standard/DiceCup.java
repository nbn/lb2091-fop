package dk.lundogbendsen.foundation.standard;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.List;


@Slf4j
@ToString
@EqualsAndHashCode
public class DiceCup {

    @Getter
    private  String name;


    private List<Die> dice;
//
//    public DiceCup(int number) {
//        this.dice = new ArrayList<>();
//        for (int i = 0; i <number; i++) {
//            this.dice.add(new BasicDie());
//        }
//    }

    public DiceCup(List<Die> dice) {
        this(dice, "No name");
    }

    public DiceCup(List<Die> dice, String name) {
        this.dice = dice;
        this.name = name;
        log.info("Im constructed now");
    }


    public void roll() {
        dice.forEach( it -> it.roll() );
    }

    public int sum() {
        return dice.stream().mapToInt(it -> it.get()).sum();
    }


    public void setName(String name) {
        this.name = name;
        log.info("Setting new name " + name);
    }

    @Override
    public String toString() {
        return name + " " + sum();
    }

    @PostConstruct
    private void init() {
        log.info("During init method");
    }

}
