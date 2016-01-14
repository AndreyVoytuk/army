package spellcasters;

import java.util.HashSet;
import weapons.*;
import exceptions.*;
import spells.*;
import interfaces.*;
import units.*;


public class Necromancer extends Spellcaster implements Observer {
    protected HashSet<Observable> observables = new HashSet<Observable>();

    public Necromancer(String name, int hp, int mana) {
        super(name, hp, mana);
        this.state.isUndead = true;
        addSpell(new Fireball("Fireball", 30, 40));
        this.weapon = new Dagger(this, "Dagger", 20);

    }

    public void takeDamage(int damage) throws UnitIsDeadException {
        ensureIsAlive();

        if ( this.state.hp < damage ) {
            notifyObservables();
            this.state.hp = 0;
            return;
        }

        this.state.hp -= damage;
    }

    public void cast(String spell, Unit enemy) throws OutOfManaException, UnitIsDeadException {
        spendMana(this.spellbook.get(spell).costMana);
        this.spellbook.get(spell).action(enemy);

        addObservable(enemy);
        enemy.addObserver(this);
    }
    public void addObservable(Observable observable) {
        observables.add(observable);
        System.out.println("added Observable");
    }
    public void removeObservable(Observable observable) {
        observables.remove(observable);
        System.out.println("removed Observable");

    }
    public void notifyObservables() {
        for ( Observable observable : observables ) {
            observable.removeObserver(this);
        }
    }
    public void showObservable() {
        for ( Observable observable : observables ) {
            System.out.println(observable);
        }
    }
}
