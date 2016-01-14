package weapons;

import units.*;
import exceptions.*;

public class Stick extends Weapon {
    public Stick(Unit owner, String name, int damage) {
        super(owner, name, damage);
    }

    public void action(Unit enemy) throws UnitIsDeadException {
        if ( enemy.getState().isUndead ) {
            enemy.takeDamage(damage * 2);
            enemy.getWeapon().counterAction(owner);
            return;
        }
        enemy.takeDamage(damage);
        enemy.getWeapon().counterAction(owner);
    }
}