import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField ammout;
    JButton withdraw, back;
    String pinnumber;
    Withdrawl(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter amount you want to withdraw: ");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        ammout = new JTextField();
        ammout.setFont(new Font("Ralway", Font.BOLD, 22));
        ammout.setBounds(170, 350, 320, 25);
        image.add(ammout);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this::actionPerformed);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this::actionPerformed);
        image.add(back);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transations("").setVisible(true);
        } else if (ae.getSource() == withdraw) {
            String withdrawlAmmount = ammout.getText();
            Date data = new Date();
            if (withdrawlAmmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {

                    ConnectDatabase conn = new ConnectDatabase();
                    String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+data+"', 'Withdraw', '"+withdrawlAmmount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +withdrawlAmmount+ " withdrawl successfully!");
                    setVisible(false);
                    new Transations(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
