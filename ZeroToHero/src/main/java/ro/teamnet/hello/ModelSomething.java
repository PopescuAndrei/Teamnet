package ro.teamnet.hello;

/**
 * Created by Andrei on 4/22/2015.
 */
public class ModelSomething {
    private String title;
    private String description;
    private int aNumber;

    public ModelSomething(String title, String description, int aNumber) {
        this.title = title;
        this.description = description;
        this.aNumber = aNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getaNumber() {
        return aNumber;
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }
}
