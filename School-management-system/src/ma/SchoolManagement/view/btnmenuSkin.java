package ma.SchoolManagement.view;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.util.Duration;

public class btnmenuSkin extends ButtonSkin {

    public btnmenuSkin(Button control) {
        super(control);

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
        fadeIn.setNode(control);
        fadeIn.setToValue(1);
        control.setOnMouseEntered(e -> fadeIn.playFromStart());

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(200));
        fadeOut.setNode(control);
        fadeOut.setToValue(0.7);
        control.setOnMouseExited(e -> fadeOut.playFromStart());

        control.setOpacity(0.7);
    }

}