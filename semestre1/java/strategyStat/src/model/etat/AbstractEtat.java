package model.etat;

import model.machine.Machine;

public abstract class AbstractEtat implements IEtat {
    protected static Machine machine ;
    public AbstractEtat(Machine machine){
        this.machine = machine ;
    }
}
