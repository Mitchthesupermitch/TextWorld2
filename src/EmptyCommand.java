public class EmptyCommand implements Command {
    String nothing;
    @Override
    public void Init(String userString) {
        this.nothing = getLastWordIn(userString);

    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split("");
        return words[words.length-1];
    }

    @Override
    public boolean execute() {
        return false;
    }
}
