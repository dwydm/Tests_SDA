package mocks.game;

public class MessagesCounter {
    private int fromAdmin;
    private int fromModerator;

    public int getFromAdmin() {
        return fromAdmin;
    }

    public int getFromModerator() {
        return fromModerator;
    }

    public void processMessage(MessageType messageType) {
        if (messageType.equals(MessageType.FROM_ADMIN)) {
            fromAdmin++;
        }
        if (messageType.equals(MessageType.FROM_MOD)) {
            fromModerator++;
        }
    }
}
