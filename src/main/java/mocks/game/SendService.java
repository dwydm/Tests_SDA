package mocks.game;

public class SendService {
    public MessageType sendMessage(User fromUser, String info) {
        if (fromUser.getRank().equals("ADMIN")) {
            return MessageType.FROM_ADMIN;
        }
        if (fromUser.getRank().equals("MOD")) {
            return MessageType.FROM_MOD;
        }
        return MessageType.FROM_USER;
    }
}
