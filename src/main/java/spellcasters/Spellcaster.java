package spellcasters;

import java.util.HashMap;
import exceptions.*;
import spells.*;
import weapons.*;
import units.*;

public abstract class Spellcaster extends Unit {
    protected int mana;
    protected int manaLimit;
    protected HashMap<String, Spell> spellbook = new HashMap<String, Spell>();

    public Spellcaster(String name, int hp, int mana) {
        super(name, hp);
        this.mana = mana;
        this.manaLimit = mana;
        this.weapon = new Stick(this, "Stick", 10);

        addSpell(new Fireball("Fireball", 30, 40));
        addSpell(new Heal("Heal", 30, 30));
    }

    public void attack(Unit enemy) throws UnitIsDeadException {}
    public void cast(String spell, Unit enemy) throws OutOfManaException, UnitIsDeadException {
        if ( this.mana == 0 ) {
            this.attack(enemy);
            throw new OutOfManaException();
        }
        spendMana(this.spellbook.get(spell).costMana);
        this.spellbook.get(spell).action(enemy);
    }
    public void addMana(int mana) {
        this.mana += mana;

        if( this.mana >= this.manaLimit ) {
            this.mana = this.manaLimit;
        }
    }
    public void spendMana(int costMana) throws OutOfManaException {
        if( costMana > this.mana ) {
            throw new OutOfManaException();
        }

        this.mana -= costMana;
    }

    public void addSpell(Spell newSpell) {
        this.spellbook.put(newSpell.name, newSpell);
    }
    @Override
    public String toString() {
        StringBuffer out = new StringBuffer(super.toString());

        out.append(" Mana/manaLimit: " + mana + "/" + manaLimit);

        return out.toString();
    }
}
