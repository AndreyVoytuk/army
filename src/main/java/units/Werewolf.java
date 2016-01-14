package units;

import exceptions.*;
import weapons.*;

public class Werewolf extends Unit {
    protected State stateWolf;
    protected Weapon weaponWolf;

    public Werewolf(String name, int hp) {
        super(name, hp);
        this.weapon = new Sword(this, "Sword", 20);
        this.state.isWerewolf = true;

        stateWolf = new State("Werewolf", hp*2);
        weaponWolf = new Claws(this, "Claws", 20);
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        ensureIsAlive();
        this.weapon.action(enemy);
    }

    public void takeMagicDamage(int magicDmg) throws UnitIsDeadException{
        ensureIsAlive();

        if( state.isWerewolf ) {
            super.takeDamage(magicDmg * 2);
        }

        super.takeDamage(magicDmg);

    }

    public void transform() {
        State tmpState = this.state;
        Weapon tmpWeapon = this.weapon;

        this.state = stateWolf;
        this.weapon = weaponWolf;

        stateWolf = tmpState;
        weaponWolf = tmpWeapon;

        state.hp = (state.hpMax * stateWolf.hp) / stateWolf.hpMax;
    }
}