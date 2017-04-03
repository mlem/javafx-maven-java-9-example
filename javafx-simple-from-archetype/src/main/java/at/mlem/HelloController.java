package at.mlem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.event.HyperlinkEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable
{
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @FXML private Menu tiereMenu;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tiereMenu.getItems().stream().forEach(
                menuItem -> {
                    menuItem.setOnAction(event -> {
                        MenuItem source = (MenuItem) event.getSource();
                        firstNameField.setText(source.getText());
                    });
                }
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

}
