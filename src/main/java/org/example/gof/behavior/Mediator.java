package org.example.gof.behavior;

import java.util.ArrayList;
import java.util.List;

//подразумевает добавление стороннего объекта (посредника) для управления
//	взаимодействием между двумя объектами (коллегами). Шаблон помогает уменьшить связанность (coupling) классов, общающихся друг с другом,
//	ведь теперь они не должны знать о реализациях своих собеседников. (убирает сильную связанность между sender и receiver)

public class Mediator {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        User user1 = new ChatUser(mediator, "Pankaj");
        User user2 = new ChatUser(mediator, "Lisa");
        User user3 = new ChatUser(mediator, "Saurabh");
        User user4 = new ChatUser(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi All");
    }
}

class ChatMediator  {
    private final List<User> users;

    public ChatMediator() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}

class ChatUser extends User {
    public ChatUser(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + ": Sending Message ----- " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Received Message : " + msg);
    }
}