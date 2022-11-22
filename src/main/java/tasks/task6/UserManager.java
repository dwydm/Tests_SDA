package tasks.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {
    private List<User> users = new ArrayList<>();

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getAdmins() {
        return users.stream()
                .filter(User::isAdmin)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        User user1 = new User(1, "Tomasz", true);
        User user2 = new User(2, "Jacek", false);
        User user3 = new User(3, "Placek", true);
        List<User> lista = new ArrayList<>(Arrays.asList(user1, user2, user3));
        UserManager userManager = new UserManager();
        userManager.setUsers(lista);
        System.out.println(userManager.getAdmins());
    }
}

