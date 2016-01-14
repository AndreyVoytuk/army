package weapons;

import units.*;
import exceptions.*;

public class Dagger extends Weapon {
    public Dagger(Unit owner, String name, int damage) {
        super(owner, name, damage);
    }

    public void action(Unit enemy) throws UnitIsDeadException  {
        enemy.takeDamage(this.damage);
        enemy.getWeapon().counterAction(owner);
    }
    public void counterAction(Unit enemy) throws UnitIsDeadException  {
        enemy.takeDamage(this.damage / 3);
    }

}
