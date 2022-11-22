package mocks.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageCenterTest {

    @InjectMocks
    MessageCenter messageCenter;

    @Mock
    UserService userService;

    @Mock
    SendService sendService;

    @Test
    void shouldSendMessageFromAdmin() {
        //given
        Map<String, String> messages = new HashMap<>();
        messages.put("Tomasz", "Hello dev"); // admin
        messages.put("Jacek", "Hello tester"); // mod
        messages.put("Genowefa", "Hello pm"); // user
        messages.put("Katarzyna", "Hello pm"); //nie ma

        User tomasz = new User(1, "Tomasz", "ADMIN");
        User jacek = new User(2, "Jacek", "MOD");
        User genowefa = new User(3, "Genowefa", "USER");
        User katarzyna = new User(4, "Katarzyna", "USER");

        //when

        when(userService.existsByName(anyString())).thenReturn(true);

//        when(userService.existsByName("Tomasz")).thenReturn(true);
//        when(userService.existsByName("Jacek")).thenReturn(true);
//        when(userService.existsByName("Genowefa")).thenReturn(true);
//        when(userService.existsByName("Katarzyna")).thenReturn(true);
//
        when(userService.getUserByName("Tomasz")).thenReturn(tomasz);
        when(userService.getUserByName("Jacek")).thenReturn(jacek);
        when(userService.getUserByName("Genowefa")).thenReturn(genowefa);
        when(userService.getUserByName("Katarzyna")).thenReturn(katarzyna);

        when(sendService.sendMessage(any(), anyString())).thenReturn(MessageType.FROM_ADMIN);

//        when(sendService.sendMessage(tomasz, "Hello dev")).thenReturn(MessageType.FROM_MOD);
//        when(sendService.sendMessage(jacek, "Hello tester")).thenReturn(MessageType.FROM_MOD);
//        when(sendService.sendMessage(genowefa, "Hello pm")).thenReturn(MessageType.FROM_USER);

        MessagesCounter actual = messageCenter.sendMessageToAll(messages);
        //then
        assertThat(actual.getFromAdmin()).isEqualTo(4);
        assertThat(actual.getFromModerator()).isEqualTo(0);

    }
}