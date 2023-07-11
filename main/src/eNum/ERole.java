package eNum;

public enum ERole {
    ADMIN(1,"ADMIN"),
    GUIDETOUR(2,"GUIDETOUR"),

    CLIENT(3,"CLIENT");
    private int id;
    private String name;



    ERole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
