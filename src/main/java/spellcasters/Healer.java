package spellcasters;

import spells.*;

public class Healer extends Spellcaster {
    Healer(String name, int hp, int mana) {
        super(name, hp, mana);
        addSpell(new Fireball("Fireball", 15, 40));
    }
}