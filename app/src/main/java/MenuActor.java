import java.util.concurrent.atomic.AtomicInteger;

/***
 * this class represents any actor or skill that can be represented in a menu
 */
abstract class MenuActor {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private String image;
    private String icon;

    public MenuActor() {
        id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
