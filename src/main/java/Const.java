public enum Const {
    URL ("https://api.nasa.gov/planetary/apod?api_key=yynnQdcdQOuYO9aRVOqndbljHaedKhbdlbdfUBfE"),
    FILEEXTENSIONTXT (".txt"),
    TYPEFILEIMAGE ("image"),
    TYPEFILEVIDEO ("video"),
    ;


    private String item;

    Const(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
