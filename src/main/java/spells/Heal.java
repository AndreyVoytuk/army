package spells;

import units.*;
import exceptions.*;

public class Heal extends Spell {
    public Heal(String name, int spellPower, int costMana) {
        super(name, costMana, spellPower);
    }

    public void action(Unit enemy) throws UnitIsDeadException {
     
        enemy.addHp(spellPower);
        System.out.println("Heal addHp");
    }
}