import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;

public abstract class Creature {
    Graph.Node currentRoom;
    String name;
    String description;
    Player p;

    public abstract void move();

    protected Graph.Node getRandomAdjacentRoom(){
        ArrayList<Graph.Node> rooms = new ArrayList<Graph.Node>();
        for(Graph.Node node : currentRoom.getNeighbors()){
            rooms.add(node);
        }
        return rooms.get((int)(Math.random()*rooms.size()));
    }

    protected Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    protected boolean moveToRoom(Graph.Node n){
        if(currentRoom.getNeighbors().contains(n)){
            currentRoom = n;
            return true;
        }
        return false;
    }

    protected void moveRandom(){
        currentRoom = getRandomAdjacentRoom();
    }

    protected void moveTowardsPlayer(){
        Graph.Node room = currentRoom;
        do{
            room = currentRoom.getRandomNeighbor();
        }while(isRoomCloserToPlayer(room) == false);
        currentRoom = room;
    }

    protected void moveAwayFromPlayer(){
        Graph.Node room = currentRoom;
        do{
            room = currentRoom.getRandomNeighbor();
        }while(isRoomCloserToPlayer(room) == true);
        currentRoom = room;
    }

    protected int getDistanceBetween(Graph.Node roomOne, Graph.Node roomTwo){
        Graph.Node room;
        Graph.Node n = roomOne;
        int smallestDistance = 100000000;
        int count = 0;
        for(int i = 0; i<1000; i++) {
            do {
                room = n.getRandomNeighbor();
                n = room;
                count++;
            } while (!roomTwo.getNeighbors().contains(room));
            if (count<smallestDistance){
                smallestDistance = count;
            }
        }
        return smallestDistance;
    }

    protected boolean isCreatureCloseToPlayer(){
        int distanceBetweenPlayerAndCreature = getDistanceBetween(p.getCurrentRoom(), currentRoom);
        if(distanceBetweenPlayerAndCreature <= 2) {
            return true;
        }
        return false;
    }

    protected boolean isRoomCloserToPlayer(Graph.Node n){
        int distanceBetweenPlayerAndRoom = getDistanceBetween(p.getCurrentRoom(), n);
        int distanceBetweenCreatureAndRoom = getDistanceBetween(currentRoom, n);
        if(distanceBetweenCreatureAndRoom <= distanceBetweenPlayerAndRoom) {
            return false;
        }else{
            return true;
        }
    }

    protected String getName(){
        return name;
    }
}
