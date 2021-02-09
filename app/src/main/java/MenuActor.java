import java.util.concurrent.atomic.AtomicInteger;

/***
 * this class represents any actor or skill that can be represented in a menu
 *
 * count: automatic count of existing Objects
 * id: automatically incrementing ID of Actor
 * name
 * image: placeholder for future image file
 * icon: placeholder for future icon file
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

    public MenuActor setName(String name) {
        this.name = name;
        return this;
    }

    public MenuActor setImage(String image) {
        this.image = image;
        return this;
    }

    public MenuActor setIcon(String icon) {
        this.icon = icon;
        return this;
    }
}
