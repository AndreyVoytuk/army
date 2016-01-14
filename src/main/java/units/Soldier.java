package units;

import exceptions.*;
import weapons.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Soldier extends Unit {
    public Soldier(String name, int hp) throws IOException {
        super(name, hp);
        this.weapon = new Sword(this, "Sword", 10);
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        ensureIsAlive();

        this.weapon.action(enemy);
    }
}

