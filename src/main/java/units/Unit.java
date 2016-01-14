package units;

import java.util.HashSet;
import interfaces.*;
import exceptions.*;
import weapons.*;

public abstract class Unit implements Observable {
    protected State state;
    protected Weapon weapon;
    protected HashSet<Observer> observers = new HashSet<Observer>();

    public Unit(String name, int hp) {
        this.state = new State(name, hp);
    }

    protected void ensureIsAlive() throws UnitIsDeadException {
        if (this.state.hp == 0 ) {
            throw new UnitIsDeadException();
        }
    }

    public State getState() {
        return this.state;
    }
    public Weapon getWeapon() {
        return this.weapon;
    }
    public void setWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
    }

    public void addHp(int hp) {

        this.state.hp += hp;
        if( this.state.hp > this.state.hpMax ) {
            this.state.hp = this.state.hpMax;
        }
    }
 
    public void attack(Unit enemy) throws UnitIsDeadException {}

    public void transformToVampire() {
        state.isUndead = true;
        this.state = new State(this.state.name +" transform to Vampire ", state.hpMax*2);
    }
    public void transformToWerewolf() {
        state.isWerewolf = true;
        this.state = new State(this.state.name + " transform to Werewolf", state.hpMax*2);
    }

    public void takeDamage(int damage) throws UnitIsDeadException {
        this.ensureIsAlive();

        if( this.state.hp < damage ) {
            this.state.hp = 0;
            notifyObservers();
            return;
        }

        this.state.hp -= damage;
    }

    public void takeMagicDamage(int magicDamage) throws UnitIsDeadException {
        this.takeDamage(magicDamage);
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("added Observer");

    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("removed Observer");

    }

    public void notifyObservers() {
        for( Observer observer : observers) {
            ((Unit)(observer)).addHp(this.state.hpMax / 10);    //????
            observer.removeObservable(this);
        }
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append(state + " weapon -> " + weapon);

        return out.toString();
    }
}
