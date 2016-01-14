package weapons;

import units.*;
import exceptions.*;

public class Arbalest extends Weapon {
    public Arbalest(Unit owner, String name, int damage) {
        super(owner, name, damage);
    }

    public void action(Unit target) throws UnitIsDeadException {
        target.takeDamage(damage);
    }

}