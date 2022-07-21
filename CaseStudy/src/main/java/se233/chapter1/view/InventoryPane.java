package se233.chapter1.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import se233.chapter1.Launcher;
import se233.chapter1.model.item.BasedEquipment;

import java.util.ArrayList;

import static se233.chapter1.controller.AllCustomHandler.*;

public class InventoryPane extends ScrollPane {
    private ArrayList<BasedEquipment> equipmentsArray;
    public InventoryPane() {}
    private Pane getDetailsPane() {
        Pane invInfoPane = new HBox(10);
        invInfoPane.setBorder(null);
        invInfoPane.setPadding(new Insets(25,25,25,25));
        if (equipmentsArray!=null) {
            ImageView[] imageViewList = new ImageView[equipmentsArray.size()];
            for (int i=0; i<equipmentsArray.size(); i++) {
                imageViewList[i] = new ImageView();
                imageViewList[i].setImage(new Image(Launcher.class.getResource(equipmentsArray.get(i).getImgPath()).toString()));

                // InventoryPane(s) are event sources, bind event sources to it
                int finalI = i;
                imageViewList[i].setOnDragDetected(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        onDragDetected(event, equipmentsArray.get(finalI), imageViewList[finalI]);
                    }
                });

                // EXERCISE 3.
                imageViewList[i].setOnDragDone(new EventHandler<DragEvent>() {
                    @Override
                    public void handle(DragEvent event) {
                        if (event.isAccepted()) {
                            removeItemInvPane(event);
                        }
                    }
                });
            }

            invInfoPane.getChildren().addAll(imageViewList);
        }
        return invInfoPane;
    }

    public void drawPane(ArrayList<BasedEquipment> equipmentsArray) {
        this.equipmentsArray = equipmentsArray;
        Pane invInfo = getDetailsPane();
        this.setStyle("-fx-background-color:Red;");
        this.setContent(invInfo);
    }
}