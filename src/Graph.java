import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Graph {
    private HashMap<String, Node> nodes;
    private HashMap<String, Creature> creatures;
    private HashMap<String, Player> player;

    public Graph(){
        nodes = new HashMap<String, Node>();
    }

    public void addChicken(String name, String description, Graph.Node currentRoom){
        creatures.put(name, new Chicken(name, description, currentRoom));
    }
    public void addPlayer(String name, Graph.Node currentRoom){
        player.put(name, new Player(name, currentRoom));
    }

    public void addWumpus(String name, String description, Graph.Node currentRoom){
        creatures.put(name, new Chicken(name, description, currentRoom));
    }

    public void addPop(String name, String description, Graph.Node currentRoom){
        creatures.put(name, new Chicken(name, description, currentRoom));
    }

    public boolean addNode(String name, String description){
        nodes.put(name, new Node(name, description));
        return true;
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = null;
        Node n2 = null;
        for(String name : nodes.keySet()) {
            if(name.equals(name1)){
                n1 = nodes.get(name);
            }
            if(name.equals(name2)){
                n2=nodes.get(name);
            }
        }
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1=null;
        Node n2=null;
        for(String name : nodes.keySet()) {
            if(name.equals(name1)){
                n1 = nodes.get(name);
            }else if(name.equals(name2)){
                n2=nodes.get(name);
            }
        }
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public Creature getCreature(String name) {
        return creatures.get(name);
    }

    public Player getPlayer(String name) {
        return player.get(name);
    }


    public void moveCreatures() {
        for(String name : creatures.keySet()){
            creatures.get(name).move();
        }
    }

            public class Node{

                private String name;
                private ArrayList<Item> items;
                private ArrayList<Node> neighbors;
                private String description;

                public Node(String name, String description) {
                    items = new ArrayList<Item>();
                    neighbors = new ArrayList<Node>();
                    this.description=description;
                    this.name = name;
                }


                public String getItems() {
                    String list ="";
                    for(Item item: items){
                        list+= item.getName()+" ";
                    }
                    return list;
        }

        public String getCreatures() {
            String list ="";
            for(String name : creatures.keySet()) {
                list += creatures.get(name) + " ";
            }
            return list;
        }

        public void addItem(Item item){
            items.add(item);
        }
        public Item getItem(String name){
                    Item i = new Item("nothing","does not exist");
                    for(Item item: items){
                        if(item.getName().equals(name)) {
                            i = item;
                        }
                    }
                    return i;
                }

        public Item removeItem(String name){
            Item i = getItem(name);
            items.remove(i);
            return i;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Node n){
            neighbors.add(n);
        }

        public String getNeighborNames(){
            String names = "";
            if(neighbors.size() == 0){
                return "nowhere";
            }
            for(Node n : neighbors){
                names = names + n.getName()+" ";
            }
            return names;
        }

        protected Node getRandomNeighbor(){
            return neighbors.get((int)(Math.random()*neighbors.size()));
        }

        public Node getNeighbor(String name){
            Node node = null;
            for (Node n : neighbors){
                if(n.getName().equals(name)){
                    node = n;
                }
            }
            return node;
        }

        public ArrayList<Node> getNeighbors(){
            return neighbors;
        }

        public String getDescription() {
            return description;
        }

        public boolean containsChicken() {
            for(String name : creatures.keySet()){
                //if(creatures.get(name))
                //don't know how to do this part
            }
            return false;
        }

        public boolean containsWumpus() {
            return false;
        }

        public boolean containsPopstar() {
            return false;
        }
    }
    }
