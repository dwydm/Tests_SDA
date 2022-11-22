package tasks.task6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserManagerTest {

    @Test
    void shouldReturnTwoAdmins() {
        User user1 = new User(1, "Jacek", true);
        User user2 = new User(2, "Placek", false);
        User user3 = new User(4, "Tomasz", true);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        UserManager userManager = new UserManager();
        userManager.setUsers(userList);

        List<User> actual = userManager.getAdmins();

        assertThat(actual)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                // List<User>
                .extracting("isAdmin")
                // true, false, true
                .filteredOn(element -> element.equals(true))
                // true, true
                .containsExactly(true, true);
    }
}