import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Scanner;

import static sun.audio.AudioPlayer.player;
import static sun.rmi.transport.proxy.CGIHandler.commands;

public class Main {

private static HashMap<String, Command> commands;

public static void main(String[] args) {
        initCommands();
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

        Player p = new Player("you", null);
        g.addChicken("chicken"," oooked", g.getNode("kitchen"));
        g.addWumpus("wumpus","scared", g.getNode("closet"));
        g.addPop("Barack Obama","gonna succ u", g.getNode("balcony"));

        p.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        do{
        if(p.currentRoom.containsChicken()==true){
        System.out.println("There is chicken in room");
        }else if(p.currentRoom.containsWumpus()==true){
        System.out.println("There is wumpus in room");
        }else if(p.currentRoom.containsPopstar()==true){
        System.out.println("There is popstar in room");
        }
        System.out.println("> ");
        response = s.nextLine();
        Command command = lookupCommand(response);
        command.execute();
        g.moveCreatures();
        }while (!response.equals("quit"));
        }

private static Command lookupCommand(String response) {
        String commandWord = getFirstWordIn(response);
        Command c = commands.get(commandWord);
        if(c == null) return new EmptyCommand();
        c.Init(response);
        return c;
        }

private static String getFirstWordIn(String response) {
        String[] words = response.split(" ");
        return words[0];
        }

private static  void initCommands() {
        commands.put("take", new takeCommand(p, g));
        commands.put("look", new lookCommand(p));
        commands.put("add room", new AddRoomCommand(p, g));
        commands.put("go", new goCommand(p, g));
        commands.put("drop", new dropCommand(p, g));

        }
        }
