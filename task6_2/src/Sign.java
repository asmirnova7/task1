public enum Sign {
    more("больше"),
    less("меньше");
    private String russianTitle;
    Sign(String russianTitle) {
        this.russianTitle = russianTitle;
    };
    public String getRussianTitle() {
        return russianTitle;
    }

    public boolean isValInSign(String val) {
        boolean exists = false;
        for (Sign sign : this.values()) {
            if (val.equals(sign.getRussianTitle())) {
                exists = true;
            }
        }
        return exists;
    }

}
