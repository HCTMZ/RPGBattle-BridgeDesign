class Warrior extends Character {
    public Warrior(Weapon weapon) {
        super(weapon);
        this.hp = 100;
    }

    @Override
    public String attack() {
        return "Warrior attacks with " + weapon.getName() + " dealing " + weapon.getDamage() + " damage";
    }
}