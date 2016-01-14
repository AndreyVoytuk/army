package units;

import exceptions.*;
import weapons.*;

public class Berserker extends Unit {
    public Berserker(String name, int hp) {
        super(name, hp);
        this.weapon = new Dagger(this, "Dagger", 30);
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        this.weapon.action(enemy);
        // enemy.weapon.counterAction(this);
    }

    public void takeMagicDamage(int magicDmg) {}

}