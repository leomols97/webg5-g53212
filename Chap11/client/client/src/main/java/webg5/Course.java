package webg5;

public class Course {
    String id;
    String title;
    int ECTS;

    public Course(String id, String title, int ECTS) {
        this.id = id;
        this.title = title;
        this.ECTS = ECTS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int eCTS) {
        ECTS = eCTS;
    }
}