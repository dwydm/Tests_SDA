package mocks.game;

import java.util.Map;

public class MessageCenter {
    private UserService userService;
    private SendService sendService;

    public MessageCenter(UserService userService, SendService sendService) {
        this.userService = userService;
        this.sendService = sendService;
    }

    public MessagesCounter sendMessageToAll(Map<String, String> messages) {
        MessagesCounter messagesCounter = new MessagesCounter();
        for (Map.Entry<String, String> entry : messages.entrySet()) {
            MessageType messageType = sendMessage(entry.getKey(), entry.getValue());
            messagesCounter.processMessage(messageType);
        }
        return messagesCounter;
    }

    private MessageType sendMessage(String userName, String message) {
        if (userService.existsByName(userName)) {
            User user = userService.getUserByName(userName);
            return sendService.sendMessage(user, message);
        }
        return MessageType.UNKNOWN;
    }
}
