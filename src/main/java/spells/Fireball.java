package spells;

import units.*;
import exceptions.*;

public class Fireball extends Spell {
    public Fireball(String name, int costMana, int spellPower) {
        super(name, costMana, spellPower);
    }

    public void action(Unit enemy) throws UnitIsDeadException {
        enemy.takeMagicDamage(spellPower);
    }
}