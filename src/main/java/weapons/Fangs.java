package weapons;

import units.*;
import exceptions.*;

public class Fangs extends Weapon {
    public int bite;

    public Fangs(Unit owner, String name, int damage) {
        super(owner, name, damage);
        this.bite = 1;
    }

    public void action(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(this.damage);
        enemy.getWeapon().counterAction(owner);

        owner.addHp(enemy.getState().hpMax / 10);

        if( !enemy.getState().isWerewolf && !enemy.getState().isUndead) {
            enemy.setWeapon(new Fangs(enemy, "Fangs", 40));
            enemy.transformToVampire();
        }
    }
    public void counterAction(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(this.damage / 2);
        owner.addHp(enemy.getState().hpMax / 10);
    }
}