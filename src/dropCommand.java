public class dropCommand implements Command {
    Graph graph;
    String itemName;
    Player p ;

    public dropCommand(Player p, Graph graph) {
        this.p = p;
        this.graph = graph;
    }

    @Override
    public void Init(String userString) {
        this.itemName = getLastWordIn(userString);
    }

    public boolean execute(){
        boolean success = p.removeItem(itemName);
        return success;
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split("");
        return words[words.length-1];
    }
}
