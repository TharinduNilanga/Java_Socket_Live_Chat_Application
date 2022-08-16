package client.model;

import java.io.Serializable;

public class Message implements Serializable {
    String name;
    String message;
    String emoji;
    String image;

    public Message() {
    }

    public Message(String name, String message,String emoji, String image) {
        this.name = name;
        this.message = message;
        this.emoji = emoji;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", emoji='" + emoji + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
