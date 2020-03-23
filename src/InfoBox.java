import javax.swing.*;
import java.awt.*;

public class InfoBox extends JPanel {

    private JLabel label;

    public InfoBox() {
        super();
        label = new JLabel();
        label.setFont(new Font(getFont().getName(), Font.BOLD, 20));
        label.setForeground(Color.RED);
        add(label);
    }

    public void setInfo(String info) {
        label.setText(info);
    }
}
