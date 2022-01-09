package inacio;

public class User {
    private String password;
    private String salt;
    private String hashedPassword;

    //constructor
    public User(String password) {
        this.password = password;
        this.salt = "";
        this.hashedPassword = "";
    }
    //getters and setters

    //password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //salt
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    //hashed password
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
