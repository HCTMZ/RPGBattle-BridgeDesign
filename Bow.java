class Bow implements Weapon {
    @Override
    public String getName() {
        return "Longbow";
    }

    @Override
    public int getDamage() {
        return 15;
    }
}
