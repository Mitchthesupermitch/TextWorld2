public class Popstar extends Creature {

    public Popstar(String name, String description, Graph.Node room){
        this.name = name;
        this.description = description;
        currentRoom = room;
    }

    @Override
    public void move() {
        if(isCreatureCloseToPlayer()== true){
            moveTowardsPlayer();
        }
    }
}
