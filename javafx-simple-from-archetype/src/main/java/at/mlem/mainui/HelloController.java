package at.mlem.mainui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class HelloController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    private static final Pattern BLANK_PATTERN = Pattern.compile(" ");
    private static final KeyCombination PASTE_COMBINATION = new KeyCodeCombination(KeyCode.V,
            KeyCombination.CONTROL_DOWN);
    @FXML
    private Menu tiereMenu;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tiereMenu.getItems().forEach(
                menuItem -> menuItem.setOnAction(event -> {
                    MenuItem source = (MenuItem) event.getSource();
                    firstNameField.setText(source.getText());
                })
        );
    }

    public void sayHello() {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isEmpty(firstName)) {
            builder.append(firstName);
        }

        if (!StringUtils.isEmpty(lastName)) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(lastName);
        }

        if (builder.length() > 0) {
            String name = builder.toString();
            log.debug("Saying hello to " + name);
            messageLabel.setText("Hello " + name);
        } else {
            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
            messageLabel.setText("Hello mysterious person");
        }
    }

    public void paste(KeyEvent keyEvent) {
        if (PASTE_COMBINATION.match(keyEvent) && !(keyEvent.getTarget() instanceof TextField)) {
            log.debug("entering paste operation on {} on target {} ({})", PASTE_COMBINATION, keyEvent.getTarget(), keyEvent);
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            if (clipboard.hasString()) {
                String[] clipboardTokens = clipboard.getString().split(BLANK_PATTERN.pattern());
                if (clipboardTokens.length >= 1) {
                    firstNameField.setText(clipboardTokens[0]);
                    if (clipboardTokens.length >= 2) {
                        lastNameField.setText(Stream.of(clipboardTokens).skip(1).collect(joining(" ")));
                    }
                }
            }
            keyEvent.consume();
        }
    }
}
