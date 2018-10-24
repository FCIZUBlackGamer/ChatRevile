package image.upload.test.realmtest;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
    @PrimaryKey
    int Id;
    @Required
    String Email;
    String Password;
    String Name;
    String Image;
    String Age;
    String Gender;

    public User(int id, String name, String image, String email, String password, String age, String gender) {
        Id = id;
        Name = name;
        Image = image;
        Email = email;
        Password = password;
        Age = age;
        Gender = gender;
    }

    public User() {
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public String getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    public String getGender() {
        return Gender;
    }

    public String getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

}
