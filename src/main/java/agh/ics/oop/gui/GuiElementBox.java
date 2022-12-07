package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IWorldElement;
import agh.ics.oop.MapDirection;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private final VBox verticalBox;

    public GuiElementBox(IWorldElement element) throws FileNotFoundException {
        verticalBox = new VBox();
        Image image = new Image(new FileInputStream(element.getPicture()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        if (element instanceof Animal) {
            Label label = new Label((element.getPosition().toString()));
            verticalBox.getChildren().addAll(imageView, label);
        }
        else{
            verticalBox.getChildren().add(imageView);
        }

        verticalBox.setAlignment(Pos.CENTER);
    }

    public VBox getVerticalBox() {
        return verticalBox;
    }
}
