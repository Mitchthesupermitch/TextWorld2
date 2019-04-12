public class Chicken extends Creature {

    public Chicken(String name, String description, Graph.Node room){
        this.name = name;
        this.description = description;
        currentRoom = room;
    }

    @Override
    public void move() {
        currentRoom=getRandomAdjacentRoom();
    }
}
