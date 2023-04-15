import javax.swing.*;

public class Main {

    private JFrame window;

    public void Start(){
        window = new JFrame("Calculator");
        window.setSize(280, 350);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
               new Start();
            }
        });


    }

}