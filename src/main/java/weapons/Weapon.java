package weapons;

import units.*;
import exceptions.*;

public abstract class Weapon {
    public Unit owner;
    public String name;
    public int damage;

    public Weapon(Unit owner, String name, int damage) {
        this.owner = owner;
        this.name = name;
        this.damage = damage;
    }

    public void action(Unit enemy) throws UnitIsDeadException  {}
    public void counterAction(Unit enemy) throws UnitIsDeadException  {}

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append(name + ". His dmg= " + damage);

        return out.toString();
    }
}
