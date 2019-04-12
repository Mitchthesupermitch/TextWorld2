public class takeCommand implements Command {
    Graph graph;
    String itemName;
    Item item;
    Player p ;

    public takeCommand(Player p, Graph graph) {
        this.p = p;
        item = p.currentRoom.getItem(itemName);
        this.graph = graph;
    }

    @Override
    public void Init(String userString) {
        this.itemName = getLastWordIn(userString);
    }

    public boolean execute(){
        boolean success = p.addItem(item);
        return success;
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split("");
        return words[words.length-1];
    }

}
