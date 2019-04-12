import java.util.ArrayList;

public class Player {

    String name;
    ArrayList<Item> items;
    Graph.Node currentRoom;

    public Player(String name, Graph.Node room) {
        this.name = name;
        this.currentRoom = room;
        items = new ArrayList<Item>();
    }

    public boolean addItem(Item item){
        items.add(item);
        currentRoom.removeItem(name);
        return true;
    }

    public boolean removeItem(String name){
        Item i = new Item("nothing", "i don't exist");
        for(Item item: items){
            if(item.getName().equals(name)) {
                i = item;
            }
        }
        items.remove(i);
        currentRoom.addItem(i);
        return true;
    }


    public String getItems() {
        String list ="";
        for(Item item: items){
            list+= item.getName()+" ";
        }
        return list;
    }



    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    public boolean setCurrentRoom(Graph.Node newroom){
        currentRoom=newroom;
        return true;
    }

    
}
