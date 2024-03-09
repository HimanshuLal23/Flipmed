package Model;

import java.util.UUID;

public class Doctor {
    private String name;
    private UUID id;
    public Doctor(String name,UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
