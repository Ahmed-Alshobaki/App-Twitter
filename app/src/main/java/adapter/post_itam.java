package adapter;

public class post_itam {
    String image;
    String name;
    String username;
    String textbody;
    String time;
    int like ;

    public post_itam(String name, String username, String textbody, String time, int like) {
        this.name = name;
        this.username = username;
        this.textbody = textbody;
        this.time = time;
        this.like = like;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTextbody() {
        return textbody;
    }

    public void setTextbody(String textbody) {
        this.textbody = textbody;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
