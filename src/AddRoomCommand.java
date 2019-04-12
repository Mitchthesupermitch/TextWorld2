public class AddRoomCommand implements Command {
    Player p ;
    private String roomName;
    Graph g;

    public AddRoomCommand(Player p , Graph g) {
        this.p = p;
        this.g = g;
    }

    @Override
    public void Init(String userString) {
        this.roomName = getLastWordIn(userString);
    }

    public boolean execute(){
        boolean success = g.addNode(roomName, "new room");
        return success;
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split("");
        return words[words.length-1];
    }
}
