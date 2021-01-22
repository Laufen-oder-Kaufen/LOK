/***
 * this class represents any actor or skill that can be represented in a menu
 */
abstract class MenuActor {
    private int id;
    private String name;
    private String image;
    private String icon;

    public MenuActor(int id, String name, String image, String icon) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.icon = icon;
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
}
