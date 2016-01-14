package spellcasters;

import exceptions.*;
import spells.*;
import weapons.*;
import units.*;

public class Priest extends Spellcaster {
    public Priest(String name, int hp, int mana) {
        super(name, hp, mana);
        addSpell(new Fireball("Fireball", 15, 40));
        this.weapon = new Stick(this, "Stick", 20);
    }
    public void attack(Unit enemy) throws UnitIsDeadException {
        ensureIsAlive();
        
        this.weapon.action(enemy);
    }
}