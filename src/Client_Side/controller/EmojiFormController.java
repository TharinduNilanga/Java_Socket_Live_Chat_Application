package Client_Side.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EmojiFormController {
    public static String clickedEmoji = null;
    public AnchorPane emojiFormPane;
    public VBox emojiVBox;
    public Label emojiOne = new Label();
    public Label emojiTwo = new Label();
    public Label emojiThree = new Label();
    public Label emojiFour = new Label();
    public Label emojiFive = new Label();
    public Label emojiSix = new Label();
    public Label emojiSeven = new Label();
    public Label emojiEight = new Label();
    public ObservableList<Label> emojiList = FXCollections.observableArrayList();

    public void initialize() {
        String style = "-fx-font-size: 50px;-fx-text-fill: black;-fx-padding: 0 0 0 10;";
        emojiVBox.setSpacing(20);
        emojiOne.setText(new String(Character.toChars(0x1F606)));
        emojiTwo.setText(new String(Character.toChars(0x1F601)));
        emojiThree.setText(new String(Character.toChars(0x1F602)));
        emojiFour.setText(new String(Character.toChars(0x1F609)));
        emojiList.add(emojiOne);
        emojiList.add(emojiTwo);
        emojiList.add(emojiThree);
        emojiList.add(emojiFour);
        emojiFive.setText(new String(Character.toChars(0x1F618)));
        emojiSix.setText(new String(Character.toChars(0x1F610)));
        emojiSeven.setText(new String(Character.toChars(0x1F914)));
        emojiEight.setText(new String(Character.toChars(0x1F642)));
        emojiList.add(emojiFive);
        emojiList.add(emojiSix);
        emojiList.add(emojiSeven);
        emojiList.add(emojiEight);
        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);


        for (int i = 0; i < emojiList.size(); i++) {
            emojiList.get(i).setStyle(style);
            if (i < 4 & i >= 0) {
                hBox1.getChildren().addAll(emojiList.get(i));
            } else {
                hBox2.getChildren().addAll(emojiList.get(i));
            }
            final int index = i;
            emojiList.get(i).setOnMouseClicked(event -> {
                System.out.println("clicked : " + index);
                clickedEmoji = emojiList.get(index).getText();
            });
        }

        emojiVBox.getChildren().add(hBox1);
        emojiVBox.getChildren().add(hBox2);
    }
}
