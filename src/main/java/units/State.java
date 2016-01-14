package units;

import exceptions.*;
import weapons.*;

public class State {
    public String name;
    public int hp;
    public int hpMax;
    public boolean isWerewolf;
    public boolean isWizard;
    public boolean isUndead;

    public State(String name , int hp) {
        this.name = name;
        this.hp = hp;
        this.hpMax = hp;
        this.isWerewolf = false;
        this.isWizard = false;
        this.isUndead = false;

    }
    @Override
    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append(name + " is HP/HpMax: " + hp + "/" + hpMax);

        return out.toString();
    }
}
