abstract class Character {
    protected Weapon weapon;
    protected int hp;

    public Character(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equipWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(getClass().getSimpleName() + " equipped with " + newWeapon.getName());
    }

    public abstract String attack();
    
    public int getHP() {
        return hp;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
}