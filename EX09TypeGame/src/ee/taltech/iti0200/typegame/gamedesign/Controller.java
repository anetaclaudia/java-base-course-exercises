package ee.taltech.iti0200.typegame.gamedesign;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Controller {
    @FXML
    Label char1;
    @FXML
    Label char2;
    @FXML
    Label char3;
    @FXML
    public Label score;
    @FXML
    Button startButton;

    int scoreValue = 0;
    private static final int FADE_ANIMATION_DURATION = 300;
    public static final int CORRECT_LETTER_POINTS = 100;
    public static final int FALSE_LETTER_POINTS = -50;
    private static final int PANE_HEIGHT = 400;
    private static final int PANE_WIDTH = 600;
    private static final int TWO_LETTERS_SIZE = 64;
    private static final String STRING_FOR_GAME = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    boolean canPressKeyboard = false;

    List<Label> characters = new LinkedList<>();

    public void startGame() {
        scoreValue = 0;
        changeLabelLocation(char1);
        changeLabelLocation(char2);
        changeLabelLocation(char3);
        score.setText(String.format("SCORE: %s", scoreValue));
        canPressKeyboard = true;
    }

    private String getRandomChar() {
        Random r = new Random();
        int randomInt = r.nextInt(STRING_FOR_GAME.length());
        return STRING_FOR_GAME.substring(randomInt, randomInt + 1);
    }

    private void changeLabelLocation(Label label) {
        int height = PANE_HEIGHT - TWO_LETTERS_SIZE, width = PANE_WIDTH - TWO_LETTERS_SIZE;

        Random r = new Random();
        double newLayoutX = r.nextInt(width);
        double newLayoutY = r.nextInt(height);

//        Label labelBuffer = new Label();
//        Bounds bounds2 = label.getBoundsInParent();
        label.setLayoutX(newLayoutX);
        label.setLayoutY(newLayoutY);
//        Bounds bounds = label.getBoundsInParent();
        while ((label.getBoundsInParent().intersects(startButton.getBoundsInParent()))
                || (label.getBoundsInParent().intersects(score.getBoundsInParent()))) {
            newLayoutX = r.nextInt(width);
            newLayoutY = r.nextInt(height);
            label.setLayoutX(newLayoutX);
            label.setLayoutY(newLayoutY);
        }
    }

//            || (char1.getBoundsInParent().intersects(bounds))
//            || (char2.getBoundsInParent().intersects(bounds))
//            || (char3.getBoundsInParent().intersects(bounds)))

    private void fadeIn(Label label, FadeTransition fadeIn, String charToAdd) {
        label.setTextFill(Color.BLACK);
        changeLabelLocation(label);
        label.setText(charToAdd);
        fadeIn.setDuration(Duration.millis(FADE_ANIMATION_DURATION));
        fadeIn.setNode(label);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        fadeIn.setOnFinished(e -> {
            fadeIn.stop();
            canPressKeyboard = true;
        });
        fadeIn.playFromStart();
    }

    private void fadeOut(Label label, FadeTransition fadeOut, String charToAdd) {
        canPressKeyboard = false;
        label.setTextFill(Color.GREEN);
        fadeOut.setDuration(Duration.millis(FADE_ANIMATION_DURATION));
        fadeOut.setNode(label);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(true);
        fadeOut.setOnFinished(e -> fadeIn(label, fadeOut, charToAdd));
        fadeOut.playFromStart();
    }

    @FXML
    public void editChars(KeyEvent event) {
        String wholeString = event.getCode().toString();
        String characterToCheck = wholeString.charAt(wholeString.length() - 1) + "";
        String charsOnScreen = "";
        boolean added = false;
        for (Label character : characters) {
            if (character.getText().equals(characterToCheck)) {
                for (Label label : characters) {
                    charsOnScreen += label.getText();
                }
                String charToBeAdded = getRandomChar();
                while (charsOnScreen.contains(charToBeAdded)) {
                    charToBeAdded = getRandomChar();
                }
                FadeTransition fadeTransition = new FadeTransition();
                fadeOut(character, fadeTransition, charToBeAdded);
                scoreValue += CORRECT_LETTER_POINTS;
                score.setText(String.format("SCORE: %s", scoreValue));
                added = true;
                break;
            }
        }
        if (!added) {
            scoreValue += FALSE_LETTER_POINTS;
            score.setText(String.format("SCORE: %s", scoreValue));
        }
    }

    @FXML
    public void initialize() {
        char1.setText(getRandomChar());
        char2.setText(getRandomChar());
        char3.setText(getRandomChar());
        score.setText(String.format("SCORE: %s", scoreValue));
        characters = List.of(char1, char2, char3);
    }
}
