import java.util.ArrayList;

public class Player {

    String name, description;
    ArrayList<Item> items;
    Graph.Node currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
        currentRoom.removeItem(name);
    }

    public Item removeItem(String name){
        Item i = new Item("nothing", "i don't exist");
        for(Item item: items){
            if(item.getName().equals(name)) {
                i = item;
            }
        }
        items.remove(i);
        currentRoom.addItem(i);
        return i;
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

    public void setCurrentRoom(Graph.Node newroom){
        currentRoom=newroom;
    }

    
}
