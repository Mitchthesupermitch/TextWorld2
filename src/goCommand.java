public class goCommand implements Command {
    Player p ;
    private String roomName;
    Graph g;

    public goCommand(Player p) {
        this.p = p;
    }

    @Override
    public void Init(String userString) {
        this.roomName = getLastWordIn(userString);
    }

    public boolean execute(){
        boolean success = p.setCurrentRoom(p.getCurrentRoom().getNeighbor(roomName));
        return success;
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split("");
        return words[words.length-1];
    }
}
