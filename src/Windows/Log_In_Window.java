package Windows;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log_In_Window extends JFrame {
    private int Width = 500;
    private int Height = 500;
    private final JLayeredPane LP = new JLayeredPane();
    private final Canvas Canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            //super.paint(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monaco",Font.BOLD,46));
            String APP_NAME = "Fitness T";
            g.drawString(APP_NAME, 140, 100);
            g.setFont(new Font("Monaco",Font.BOLD,23));
            g.drawString("User Name: ", 30,175);
            g.drawString("Password: ",45,241);
        }
    };
    private final JButton Log_IN = new JButton();
    private final JButton Sign_Up = new JButton();
    private final JPasswordField Password_Field = new JPasswordField();
    private final JTextField User_Name_Field = new JTextField();

    public Log_In_Window(){
        this.setBounds(300,300,500,500);
        Initial_Log_In();
        Initial_Sign_Up();
        Initial_Canvas();
        Initial_LP();
        Initial_Password_Field();
        Initial_Name_Field();
        LP.add(Canvas,0);
        LP.add(Password_Field,0);
        LP.add(User_Name_Field,0);
        LP.add(Log_IN,0);
        LP.add(Sign_Up,0);
        this.add(LP);
        this.setVisible(true);
    }
    public void Change_Width_Height(int x, int y){
        this.Width = x;
        this.Height = y;
    }
    private void Initial_Sign_Up(){
        this.Sign_Up.setBounds(176,300,100,50);
        this.Sign_Up.setBackground(Color.BLACK);
        this.Sign_Up.setText("Sign Up");
        this.Sign_Up.setOpaque(true);
        this.Sign_Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TBC.
            }
        });
    }
    private void Initial_Log_In(){
        this.Log_IN.setBounds(290,300,100,50);
        this.Log_IN.setBackground(Color.BLACK);
        this.Log_IN.setText("Log in");
        this.Log_IN.setOpaque(true);
        this.Log_IN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TBC.
            }
        });
    }
    private void Initial_Canvas(){
        this.Canvas.setBounds(0,0,this.Width,this.Height);
        this.Canvas.setBackground(Color.BLACK);
    }
    private void Initial_Password_Field(){
        this.Password_Field.setBounds(180,225,200,25);
        this.Password_Field.setOpaque(true);
    }
    private void Initial_Name_Field(){
        this.User_Name_Field.setBounds(180,155,200,25);
        this.User_Name_Field.setOpaque(true);
    }
    private void Initial_LP(){
        this.LP.setBounds(0,0,this.Width,this.Height);
        this.LP.setOpaque(true);
    }

    public static void main(String[] args) {
        new Log_In_Window();
    }
}
