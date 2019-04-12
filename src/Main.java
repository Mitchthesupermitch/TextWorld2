import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", "a hall with a painting of ur mum in it");
        g.addNode("closet", "a closet with no clothes and only toilets");
        g.addNode("dungeon","a dungeon for people who pur milk before cereal");        g.addNode("dungeon","a dungeon for people who pur milk before cereal");
        g.addNode("kitchen","place with food");
        g.addNode("yard","a yard with fruits and also chickens");
        g.addNode("bedroom","a place to sleep");
        g.addNode("bathroom","a place to bathe");
        g.addNode("balcony","be careful it's really far from the ground");
        g.addNode("void","don't come here");
        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("hall", "kitchen");
        g.addUndirectedEdge("hall", "yard");
        g.addUndirectedEdge("hall", "bedroom");
        g.addUndirectedEdge("hall", "bathroom");
        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("bedroom", "balcony");
        g.addUndirectedEdge("bedroom", "bathroom");
        g.addDirectedEdge("balcony", "void");
        g.addUndirectedEdge("kitchen", "yard");
        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("bedroom", "closet");
        g.getNode("hall").addItem(new Item("cat","really fat"));
        g.getNode("hall").addItem(new Item("hat","really handsome"));
        g.getNode("hall").addItem(new Item("mat","really flat"));
        g.getNode("hall").addItem(new Item("rat","also really fat"));

        Player p = new Player("you", "nice");
        g.addChicken("chicken"," oooked", g.getNode("kitchen"));
        g.addWumpus("wumpus","scared", g.getNode("closet"));
        g.addPop("Barack Obama","gonna succ u", g.getNode("balcony"));

        p.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        do{
            System.out.println("You are in the "+p.getCurrentRoom().getName());
            if(p.currentRoom.containsChicken()==true){
                System.out.println("There is chicken in room");
            }else if(p.currentRoom.containsWumpus()==true){
                System.out.println("There is wumpus in room");
            }else if(p.currentRoom.containsPopstar()==true){
                System.out.println("There is popstar in room");
            }
            System.out.println("What do you want to do? >");
            response = s.nextLine();
            Graph.Node next = p.getCurrentRoom().getNeighbor(response);
            if(response.equals("quit")){
                System.out.println("goodbye");
            }else if(response.length()>=4 && response.substring(0,3).equals("go ") && p.getCurrentRoom().getNeighbor(response.substring(3))!=null){
                p.setCurrentRoom(p.getCurrentRoom().getNeighbor(response.substring(3)));
            }else if(response.equals("look")){
                System.out.println("You are in "+p.getCurrentRoom().getDescription()+". You can go to: " + p.getCurrentRoom().getNeighborNames()+". There are these items in the room: "+p.getCurrentRoom().getItems());
            }else if(response.length()>=6 && response.substring(0,5).equals("take ")){
                Item i = p.getCurrentRoom().removeItem(response.substring(5));
                p.addItem(i);
                System.out.println("You picked up "+i.getName());

            }else if(response.length()>=6 && response.substring(0,5).equals("drop ")){
                Item i = p.removeItem(response.substring(5));
                p.getCurrentRoom().addItem(i);
                System.out.println("You dropped "+i.getName());

            }else {
                System.out.println("Enter 'quit' to quit.");
                System.out.println("Enter 'go <roomname>' to enter a room.");
                System.out.println("Enter 'look' to see what rooms you can go to and what items are in the room.");
                System.out.println("Enter 'take <itemname>' to take an item.");
                System.out.println("Enter 'drop <itemname>' to drop an item.");
            }
            g.moveCreatures();
        }while (!response.equals("quit"));
    }
}
