import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{

    private JTextField output;
    private static double result, actual=0;
    private boolean start;
    private static String operator="=";
    private JButton buttonAdd,buttonSubtract,buttonDivine,buttonMultiply,buttonClear,buttonDelete
            ,buttonEquals, buttonDat;
    private JButton buttonsOfNumbers[];


    public Calculator(){

        JPanel mainPanel = new JPanel();
        start=true;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/icons/calculator.png");
        setIconImage(icon);

        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();
        JPanel row4 = new JPanel();
        JPanel row5 = new JPanel();
        JPanel row6 = new JPanel();

        row1.setLayout(new BoxLayout(row1,BoxLayout.LINE_AXIS));
        row2.setLayout(new BoxLayout(row2,BoxLayout.LINE_AXIS));
        row3.setLayout(new BoxLayout(row3,BoxLayout.LINE_AXIS));
        row4.setLayout(new BoxLayout(row4,BoxLayout.LINE_AXIS));
        row5.setLayout(new BoxLayout(row5,BoxLayout.LINE_AXIS));


        output = new JTextField(16);
        buttonAdd= new JButton("+");
        buttonAdd.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonAdd.addActionListener(this);
        buttonSubtract = new JButton("-");
        buttonSubtract.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonSubtract.addActionListener(this);
        buttonDivine = new JButton("/");
        buttonDivine.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonDivine.addActionListener(this);
        buttonMultiply = new JButton("x");
        buttonMultiply.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonMultiply.addActionListener(this);
        buttonClear = new JButton("Clr");
        buttonClear.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonClear.addActionListener(this);
        buttonDelete = new JButton("Del");
        buttonDelete.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonDelete.addActionListener(this);
        buttonEquals = new JButton("=");
        buttonEquals.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonEquals.addActionListener(this);
        buttonDat = new JButton(".");
        buttonDat.setFont(new Font("Monospaced",Font.BOLD,28));
        buttonDat.addActionListener(this);

        buttonsOfNumbers = new JButton[11];
        buttonsOfNumbers[10]=buttonDat;
        for(int i=0;i<buttonsOfNumbers.length-1;i++){
            buttonsOfNumbers[i]= new JButton(String.valueOf(i));
            buttonsOfNumbers[i].setFont(new Font("Monospaced",Font.BOLD,28));
            buttonsOfNumbers[i].addActionListener(this);
        }



        row1.add(Box.createHorizontalGlue());
        row1.add(buttonClear);
        row1.add(buttonDelete);
        row2.add(buttonsOfNumbers[7]);
        row2.add(buttonsOfNumbers[8]);
        row2.add(buttonsOfNumbers[9]);
        row2.add(buttonMultiply);
        row3.add(buttonsOfNumbers[4]);
        row3.add(buttonsOfNumbers[5]);
        row3.add(buttonsOfNumbers[6]);
        row3.add(buttonSubtract);
        row4.add(buttonsOfNumbers[1]);
        row4.add(buttonsOfNumbers[2]);
        row4.add(buttonsOfNumbers[3]);
        row4.add(buttonAdd);
        row5.add(buttonsOfNumbers[10]);
        row5.add(buttonsOfNumbers[0]);
        row5.add(buttonEquals);
        row5.add(buttonDivine);





        output.setMaximumSize(new Dimension(185, 20));
        output.setFont(new Font("Monospaced", Font.BOLD, 27));
        output.setDisabledTextColor(new Color(0, 0, 0));
        output.setMargin(new Insets(0, 5, 0, 0));
        output.setText("0");
        output.setEditable(false);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
        mainPanel.add(output);
        mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
        ;        mainPanel.add(row1);
        mainPanel.add(row2);
        mainPanel.add(row3);
        mainPanel.add(row4);
        mainPanel.add(row5);
        mainPanel.add(row6);
        add(mainPanel);
        setResizable(false);


        setSize(225,328);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = ((JButton)e.getSource()).getText();
        if("+-=/x".indexOf(value)>=0) {
            calculate(value);
        }else {
            if("DelClr".indexOf(value)>=0) {
                removalNumber(value);
            }
            else{
                insertNumber(value);
            }
        }

    }


    public void calculate(String s){
        actual=Double.parseDouble(output.getText());
        if(operator.equals("=")){
            result=actual;
        }
        if(operator.equals("+")) result+=actual;
        if(operator.equals("-")) result-=actual;
        if(operator.equals("x")) result*=actual;
        if(operator.equals("/") && actual!=0) result/=actual;
        if(operator.equals("/") && actual==0) {

            output.setText("ERROR!");

        }else{
            output.setText(""+result);
        }
        operator=s;
        start=true;

    }

    public void insertNumber(String s){
        if (start){
            output.setText("");
            start=false;
        }
        if(s.equals("DelClr")){
            removalNumber(s);
        }else{
            output.setText(output.getText()+s);
        }

    }

    public void removalNumber(String s){
         if(s=="Del")output.setText(output.getText().substring(0, output.getText ().length() - 1));
         if(s=="Clr") output.setText("");
    }
}
