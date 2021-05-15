package braces.fields;
/**
 * Class space marine
 */
public class SpaceMarine implements Comparable<SpaceMarine> {
    private long id; //The field value must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private String name; //Can't be null, String can't be empty
    private Coordinates coordinates; //Can't be null
    private java.time.LocalDate creationDate; //Can't be null, the value of this field must be generated automatically
    private long health; //Can be null, Field value must be greater than 0
    private long height;
    private AstartesCategory category; //Can be null
    private MeleeWeapon meleeWeapon; //Can't be null
    private Chapter chapter; //Can't be null
    public long getId() {
        return id;
    }
    public boolean setId(long id) {
        if (id < 0) return false;
        this.id = id;
        return true;
    }
    public String getName() {
        return name;
    }
    public boolean setName(String name) {
        if (name == null || name.equals("")) return false;
        this.name = name;
        return true;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public boolean setCoordinates(Coordinates coordinates) {
        if (coordinates == null) return false;
        this.coordinates = coordinates;
        return true;
    }
    public Long getHealth() {
        return health;
    }
    public boolean setHealth(Long health) {
        if (health == null || health <= 0) return false;
        this.health = health;
        return true;
    }
    public long getHeight() {
        return height;
    }
    public void setHeight(long height) {
        this.height = height;
    }
    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(java.time.LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public AstartesCategory getCategory() {
        return category;
    }
    public boolean setCategory(AstartesCategory category) {
        if (category == null) return false;
        this.category = category;
        return true;
    }
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }
    public boolean setMeleeWeapon(MeleeWeapon meleeWeapon) {
        if (meleeWeapon == null) return false;
        this.meleeWeapon = meleeWeapon;
        return true;
    }
    public Chapter getChapter() {
        return chapter;
    }
    public boolean setChapter(Chapter chapter) {
        if (chapter == null) return false;
        this.chapter = chapter;
        return true;
    }
    public void info() {
        System.out.println("Id : " + id + "\n" +
                "Name : " + name + "\n" +
                "Coordinates x ¸ y : " + coordinates.getXCoordinate() + ", " + coordinates.getYCoordinate() + "\n" +
                "Creation date : " + getCreationDate() + "\n" +
                "Health : " + health + "\n" +
                "Height : " + height+ "\n" +
                "Astartes Category : " + category + "\n" +
                "Melee Weapon : " + meleeWeapon + "\n" +
                "Chapter name : " + chapter.getName() + "\n" +
                "Chapter Parent Legion : " + chapter.getParentLegion() + "\n" +
                "Marines Count : " + chapter.getMarinesCount() + "\n" +
                "Chapter World : " + chapter.getWorld() + "\n" +
                "-----------------");
    }

    @Override
    public int compareTo(SpaceMarine o) {
        return (int) (health - o.getHealth());
    }
}
