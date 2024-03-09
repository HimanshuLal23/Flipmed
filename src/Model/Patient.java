package Model;

import java.util.UUID;

public class Patient {

    private String name;
    private UUID id;
    public Patient(String name,UUID id) {
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
