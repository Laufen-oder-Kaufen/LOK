/***
 * this class represents any actor or skill that can be represented in a menu
 */
abstract class MenuActor {
    private int id;
    private String name;
    private int image;
    private int icon;

    public MenuActor(int id, String name, int image, int icon) {
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

    public int getImage() {
        return image;
    }

    public int getIcon() {
        return icon;
    }
}
