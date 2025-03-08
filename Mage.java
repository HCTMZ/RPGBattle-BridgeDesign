class Mage extends Character {
    public Mage(Weapon weapon) {
        super(weapon);
        this.hp = 50;
    }
    
    @Override
    public String attack() {
        return "Mage attacks with " + weapon.getName() + " dealing " + weapon.getDamage() + " damage";
    }
}