package net.golovach.eshop.jdbc;

public class PostgreUser {

    private int id;
    private String name;
    private String password;

    public PostgreUser() {
    }

    public PostgreUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public PostgreUser(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
       /* StringBuilder sb = new StringBuilder();

        sb.append("User data:");
        sb.append("\n");
        sb.append("id: " + id);
        sb.append("\n");
        sb.append("name: " + name);
        sb.append("\n");
        sb.append("password: " + password);

        return sb.toString();*/

       return "User{id: " + id
               + ", name: " + name
               + ", password: " + password
               + "}";

    }
}
