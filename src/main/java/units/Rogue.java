package units;

import exceptions.*;
import weapons.*;

public class Rogue extends Unit {
    public Rogue(String name, int hp) {
        super(name, hp);
        this.weapon = new Arbalest(this, "Arbalest", 30);
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        ensureIsAlive();
        
        this.weapon.action(enemy);
    }
}