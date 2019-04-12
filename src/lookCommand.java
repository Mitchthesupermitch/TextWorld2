public class lookCommand implements Command {

    Player p ;

    public lookCommand(Player p) {
        this.p = p;
    }

    @Override
    public void Init(String userString) {
        System.out.println("You are in "+p.getCurrentRoom().getDescription()+". You can go to: " + p.getCurrentRoom().getNeighborNames()+". There are these items in the room: "+p.getCurrentRoom().getItems());

    }

    public boolean execute(){
        boolean success = true;
        return success;
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split("");
        return words[words.length-1];
    }

}
