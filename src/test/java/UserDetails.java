public class UserDetails {
    private NameDetails name;
    private String _id;

    public void setName(NameDetails name) {
        this.name = name;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public NameDetails getName() {
        return name;
    }
}
