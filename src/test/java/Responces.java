

public class Responces {
    private String upvotes;
    private String userUpvoted;
    private String _id;
    private String text;
    private String type;
    private UserDetails user;

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public void setUserUpvoted(String userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public String getUserUpvoted() {
        return userUpvoted;
    }

    public String get_id() {
        return _id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public UserDetails getUser() {
        return user;
    }
}
