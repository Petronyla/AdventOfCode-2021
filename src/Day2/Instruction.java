package Day2;

public class Instruction {
    String direction;
    int distance;

    public Instruction(String direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
