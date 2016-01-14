package units;

import exceptions.*;
import weapons.*;

public class Vampire extends Unit {
    public Vampire(String name, int hp) {
        super(name, hp);
        this.state.isUndead = true;
        this.weapon = new Fangs(this, "Fangs", 20);
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        ensureIsAlive();
        this.weapon.action(enemy);
    }
}
