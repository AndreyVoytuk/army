package weapons;

import units.*;
import exceptions.*;

public class Claws extends Weapon {
    public int bite;

    public Claws(Unit owner, String name, int damage) {
        super(owner, name, damage);
        this.bite = 1;
    }

    public void action(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(this.damage);
        enemy.getWeapon().counterAction(owner);

        if( !enemy.getState().isUndead ) {
            enemy.setWeapon(new Claws(enemy, "Claws", 30));
            enemy.transformToWerewolf();
        }
    }
    public void counterAction(Unit enemy) throws UnitIsDeadException  {
        enemy.takeDamage(this.damage / 2);
    }
}
