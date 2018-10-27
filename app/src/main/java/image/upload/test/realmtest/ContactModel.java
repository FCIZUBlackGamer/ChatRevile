package image.upload.test.realmtest;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ContactModel extends RealmObject {
    @PrimaryKey
    int id;
    String name;
    String message;
    String date_time;
    String image;
    String message_state;

    public ContactModel() {
    }

    public ContactModel(int id, String name, String message, String date_time, String image, String message_state) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.date_time = date_time;
        this.image = image;
        this.message_state = message_state;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage_state() {
        return message_state;
    }

}
