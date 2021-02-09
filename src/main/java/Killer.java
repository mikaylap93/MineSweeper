public interface Killer {
    void addMurdered(Murdered murdered);
    void removeMurdered(Murdered murdered);
    void kill();
}
