import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;
import java.util.Random;
//import java.util.concurrent.ExecutionException;

public class SignUpTwo extends JFrame implements ActionListener{

    JTextField panNumberTextField, aadharNumberTextField;
    JComboBox rel, cat, inc, edqua, occ;
    JRadioButton yes1, no1, yes2, no2;
    JButton next;

    Random ran = new Random();
    long random = Math.abs(ran.nextLong() % 9000L + 1000L);
    String formno = "";

    SignUpTwo(String formno){

        this.formno = formno;
        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Relegion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        rel = new JComboBox(valReligion);
        rel.setBounds(300, 140, 400, 30);
        rel.setBackground(Color.WHITE);
        add(rel);

        JLabel catagory = new JLabel("Category:");
        catagory.setFont(new Font("Raleway", Font.BOLD, 20));
        catagory.setBounds(100, 190, 200, 30);
        add(catagory);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        cat = new JComboBox(valcategory);
        cat.setBounds(300, 190, 400, 30);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valincome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        inc = new JComboBox(valincome);
        inc.setBounds(300, 240, 400, 30);
        inc.setBackground(Color.WHITE);
        add(inc);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 300, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 300, 30);
        add(qualification);

        String valEducation[] = {"Non Graduate", "Graduate", "Post Graduate", "Doctrate", "Others"};
        edqua = new JComboBox(valEducation);
        edqua.setBounds(300, 315, 400, 30);
        edqua.setBackground(Color.WHITE);
        add(edqua);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 360, 200, 30);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retired", "Other"};
        occ = new JComboBox(valOccupation);
        occ.setBounds(300, 360, 400, 30);
        occ.setBackground(Color.WHITE);
        add(occ);


        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100, 410, 200, 30);
        add(panNumber);

        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumberTextField.setBounds(300, 410, 400, 30);
        add(panNumberTextField);

        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumber.setBounds(100, 470, 200, 30);
        add(aadharNumber);

        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumberTextField.setBounds(300, 470, 400, 30);
        add(aadharNumberTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 520, 200, 30);
        add(seniorCitizen);

        yes1 = new JRadioButton("Yes");
        yes1.setBounds(300, 520, 70, 30);
        yes1.setBackground(Color.white);
        add(yes1);

        no1 = new JRadioButton("No");
        no1.setBounds(450, 520, 70, 30);
        no1.setBackground(Color.white);
        add(no1);

        ButtonGroup senCit = new ButtonGroup();
        senCit.add(yes1);
        senCit.add(no1);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 570, 200, 30);
        add(existingAccount);

        yes2 = new JRadioButton("Yes");
        yes2.setBounds(300, 570, 70, 30);
        yes2.setBackground(Color.white);
        add(yes2);

        no2 = new JRadioButton("No");
        no2.setBounds(450, 570, 70, 30);
        no2.setBackground(Color.white);
        add(no2);

        ButtonGroup existAc = new ButtonGroup();
        existAc.add(yes2);
        existAc.add(no2);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this::actionPerformed);
        add(next);

        getContentPane().setBackground(Color.white);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String sreligion = (String) rel.getSelectedItem();
        String scatagory = (String) cat.getSelectedItem();
        String sincome = (String) inc.getSelectedItem();
        String seducation = (String) edqua.getSelectedItem();
        String soccupation = (String) occ.getSelectedItem();

        String seniorcitizen = null;
        if (yes1.isSelected()){
            seniorcitizen = "Yes";
        }
        else if (no1.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (yes2.isSelected()) {
            existingaccount = "Yes";
        }
        else if (no2.isSelected()) {
            existingaccount = "No";
        }

        String span = panNumberTextField.getText();
        String sadhaar = aadharNumberTextField.getText();

        try {
            ConnectDatabase c = new ConnectDatabase();
            String query = "INSERT INTO signuptwo VALUES('"+formno+"', '"+sreligion+"', '"+scatagory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sadhaar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
