package eNum;

public enum EStatusBill {
    WAITING(1, "Waiting"),

    CONFIRMED(2, "Confirmed"),

    FINISH(3, "Finish"),

    DELETE(4, "Delete"),
    Refuse(5, "Refuse"),
    INPROGRESS(6, "InProgress");


    private int id;
    private String name;

    EStatusBill(int id, String name) {
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

    public static EStatusBill getStatusBillFromInt(int id) {
        for (EStatusBill e : EStatusBill.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static boolean isBillComplete(EStatusBill status) {
        return status == EStatusBill.INPROGRESS || status == EStatusBill.CONFIRMED || status == EStatusBill.WAITING;
    }

}
