package spellcasters;

import spells.*;

public class Wizard extends Spellcaster {
    public Wizard(String name, int hp, int mana) {
        super(name, hp, mana);
        addSpell(new Heal("Heal", 15, 30));
    }
}