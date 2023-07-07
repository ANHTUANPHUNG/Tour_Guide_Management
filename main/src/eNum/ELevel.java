package eNum;

public enum ELevel {
    vip(1,"Vip"),
    normal(2,"Normal");

    private int id;
    private String name;



    ELevel(int id, String name) {
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
