package units;

import spellcasters.*;
import weapons.*;
import spells.*;
import interfaces.*;
import exceptions.*;

public class Ato {
    public static void main(String[] args) throws UnitIsDeadException, OutOfManaException {
        Berserker berserk = new Berserker("Berserk", 150);
        Vampire vampire = new Vampire("Vampire", 120);
        Priest priest = new Priest("Priest", 120, 200);
        Wizard wizard = new Wizard("Wizard", 120, 160);
        Necromancer necromancer = new Necromancer("Necromancer", 120, 140);
        Werewolf werewolf = new Werewolf("Werewolf", 120);

        // System.out.println(berserk);
        // System.out.println(vampire);
        // System.out.println(priest);

        // priest.attack(necromancer);
        // priest.attack(berserk);

        // System.out.println(berserk);
        // System.out.println(wizard);

        // wizard.cast("Fireball", priest);
        // necromancer.cast("Fireball", priest);

        // System.out.println(priest);
        // System.out.println(necromancer);

        // wizard.cast("Fireball", priest);

        // System.out.println(" + hp of observable: " + necromancer);
        System.out.println( werewolf);

    /*    wizard.cast("Heal", berserk);
        System.out.println(berserk);
        */

        // vampire.attack(berserk);
        werewolf.attack(berserk);
        System.out.println( werewolf);
        System.out.println( berserk);

        werewolf.transform();
        werewolf.attack(berserk);

        System.out.println( werewolf);
        System.out.println( berserk);
        
        werewolf.transform();
        werewolf.attack(berserk);





        System.out.println("After_____________");
        System.out.println(berserk);
        System.out.println( werewolf);
        // System.out.println(vampire);
        // System.out.println(wizard);

    }
}