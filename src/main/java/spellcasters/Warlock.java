package spellcasters;

import units.Demon;
import exceptions.*;

import java.io.IOException;

public class Warlock extends Spellcaster {
    protected Demon demon;

    public Warlock(String name, int hp, int mana) {
        super(name, hp, mana);
        this.demon = null;
    }

    public void summon() throws OutOfManaException, IOException {
        if ( demon == null ) {
            spendMana(this.mana / 3);
            this.demon = new Demon("Demon", 150, this);
        }
    }

    private void showDemon() throws NoDemonException {
        if ( demon == null) {
            throw new NoDemonException();
        }

        System.out.println(demon);
    }

}