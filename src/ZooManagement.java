public class ZooManagement {
    private int nbrCages;
    private String zooName;

    public ZooManagement() {
    }

    public ZooManagement(String zooName, int nbrCages) {
        this.zooName = zooName;
        this.nbrCages = nbrCages;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public void setNbrCages(int nbrCages) {
        this.nbrCages = nbrCages;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public void afficherDetails() {
        System.out.println("Nom du zoo: " + zooName + ", Nombre de cages: " + nbrCages);
    }

    @Override
    public String toString() {
        return "ZooManagement{zooName='" + zooName + "', nbrCages=" + nbrCages + "}";
    }
}