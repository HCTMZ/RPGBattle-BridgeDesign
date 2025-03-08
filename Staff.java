class Staff implements Weapon {
    @Override
    public String getName() {
        return "Magic Staff";
    }

    @Override
    public int getDamage() {
        return 10;
    }
}