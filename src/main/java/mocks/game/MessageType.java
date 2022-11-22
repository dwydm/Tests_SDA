package mocks.game;

public enum MessageType {
    FROM_ADMIN(1), FROM_MOD(2), FROM_USER(3), UNKNOWN(4);
    private int type;

    MessageType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
