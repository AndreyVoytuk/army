package weapons;

import units.*;
import exceptions.*;

public class Sword extends Weapon {
    public Sword(Unit owner, String name, int damage) {
        super(owner, name, damage);
    }

    public void action(Unit enemy) throws UnitIsDeadException  {
        enemy.takeDamage(this.damage);
        owner.takeDamage(enemy.getWeapon().damage / 3);
    }
}
