package spells;

import units.*;
import exceptions.*;

public abstract class Spell {
    public String name;
    public int costMana;
    public int spellPower;

    public Spell(String name, int costMana, int spellPower) {
        this.name = name;
        this.costMana = costMana;
        this.spellPower = spellPower;
    }
    public void action(Unit enemy) throws UnitIsDeadException {}

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("name" + name);
        out.append(" : cost - " + costMana);
        out.append(" -> power " + spellPower);

        return out.toString();

    }
}