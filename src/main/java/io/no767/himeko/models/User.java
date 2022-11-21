package io.no767.himeko.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    public String id;
    public String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, name='%s']",
                this.id, this.name);
    }
}
