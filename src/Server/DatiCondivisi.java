package Server;

public class DatiCondivisi {
    private boolean luce;

    public DatiCondivisi() {
        this.luce = false;
    }

    public boolean isLuceAccesa() {
        return luce;
    }

    public synchronized void accendiLuce() {
        this.luce = true;
    }

    public synchronized void spegniLuce() {
        this.luce = false;
    }
}
