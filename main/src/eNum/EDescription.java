package eNum;

public enum EDescription {
    Name(1),
    Age(2),
    Address(3),
    Gender(4),
    Phone (5),
    Language(6),
    Status(7),
    FeedBack(8),
    Rate(9),
    Hashtag(10 );

    private int id;

    EDescription(int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public static EDescription getDescriptionFromInt(int id) {
        for (EDescription e : EDescription.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
