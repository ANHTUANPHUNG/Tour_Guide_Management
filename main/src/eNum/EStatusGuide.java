package eNum;

public enum EStatusGuide {
    AVAILABLE(1,"Available"),
    UNAVAILABLE(2,"UnAvailable");
private int id;
private String name;

    EStatusGuide(int id, String name) {
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
    public static EStatusGuide getStatusGuideFromInt(int id) {
        for (EStatusGuide e : EStatusGuide.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

}
