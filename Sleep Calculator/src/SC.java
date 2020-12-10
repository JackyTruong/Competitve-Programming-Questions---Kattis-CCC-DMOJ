import javax.swing.*;

public class SC {
    private JPanel panel1;
    private JTextField enterTodaySDateTextField;
    private JTextField a24TextField;
    private JTextField a15TextField;
    private JTextField a6TextField;
    private JTextField a12TextField;
    private JTextField a1991TextField;
    private JTextField a2008TextField;
    private JButton calculateButton;
    private JButton exitButton;
    private JTextField youHaveBeenAliveTextField;
    private JTextArea youHaveSlept51008TextArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SC");
        frame.setContentPane(new SC().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
