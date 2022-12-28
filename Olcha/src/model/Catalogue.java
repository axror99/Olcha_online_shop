package model;

public class Catalogue extends BaseModel{

    private int id;
    private static int generateId=1;
    private int prenatId;

    public Catalogue() {
        id=generateId++;
    }

    public int getPrenatId() {
        return prenatId;
    }

    public void setPrenatId(int prenatId) {
        this.prenatId = prenatId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", prenatId=" + prenatId +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
