public class Wumpus extends Creature {

    public Wumpus(String name, String description, Graph.Node room, Player p){
        this.name = name;
        this.description = description;
        currentRoom = room;
        this. p = p;
    }

    @Override
    public void move() {
            Graph.Node nextRoom = getRandomAdjacentRoom();
            if (isCreatureCloseToPlayer() == true) {
                moveAwayFromPlayer();
            }
    }
}
