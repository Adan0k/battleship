import java.util.ArrayList;

public class Ship {
    private String name;
    private int size;
    private Boolean defeated = false;
    private ArrayList<Position> positions = new ArrayList<>();


    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Boolean getDefeated() {
        return defeated;
    }

    public void setDefeated(Boolean defeated) {
        this.defeated = defeated;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }
}
