package mocks.game;

import java.util.HashMap;
import java.util.Map;

public class Game {
    public static void main(String[] args) {
        Map<String, String> messages = new HashMap<>();
        messages.put("Tomasz", "Hello dev"); // admin
        messages.put("Jacek", "Hello tester"); // mod
        messages.put("Genowefa","Hello pm"); //nie ma

        UserService userService = new UserService();
        SendService sendService = new SendService();
        MessageCenter messageCenter = new MessageCenter(userService, sendService);

        MessagesCounter messagesCounter = messageCenter.sendMessageToAll(messages);
        System.out.println(messagesCounter.getFromAdmin());
        System.out.println(messagesCounter.getFromModerator());
    }
}
