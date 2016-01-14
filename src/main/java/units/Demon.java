package units;

import exceptions.*;
import spellcasters.Warlock;
import weapons.*;

import java.io.IOException;

public class Demon extends Soldier {
    public Warlock boss;

    public Demon(String name, int hp, Warlock boss) throws IOException {
        super(name, hp);
        this.boss = boss;
    }

    public void takeDamage(int dmg) throws UnitIsDeadException {
        if ( dmg > this.state.hp ) {
            this.state.hp = 0;
            return;
        }

        super.takeDamage(dmg);
    }
}