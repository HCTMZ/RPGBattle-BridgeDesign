public class Enemy extends Character {
    public Enemy(Weapon weapon) {
        super(weapon);
        this.hp = 100;
    }

    @Override
    public String attack() {
        return "Enemy retaliates with " + weapon.getName() + " dealing " + weapon.getDamage() + " damage";
    }
    
}
