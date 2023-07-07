package eNum;

public enum EGender {
    male(1,"MALE"),
    female(2,"FEMALE"),
    other(3,"OTHER");
    private int id;
    private String name;



     EGender(int id, String name) {
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

    public static EGender getGenderFromInt(int id) {
        for (EGender e : EGender.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
