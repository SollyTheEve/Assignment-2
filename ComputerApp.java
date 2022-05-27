package computerapp;					//Computer lab application package
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.gmail.linganiso.Computer;	//Import Computer class allocated different package
import com.gmail.slinganiso.NegativeValues; 	//Import the NegativeValues exception allocated different package

/**
 *
 * @author Linganiso Solethu 219325561
 */

public class ComputerApp extends JFrame implements ActionListener 	//The extends jframe and the implementation of ActionListener 
{

    private final ArrayList<Computer> clist = new ArrayList<>();	
    private Computer objectComputer = null;

    private final JPanel hbs = new JPanel();
    private final JPanel hba = new JPanel();
    
    JButton btnShowComputers = new JButton("Show Computers");
    JButton btnClear = new JButton("Clear");
    JButton btnExit = new JButton("Exit App");
    JButton btnPlus = new JButton("+");
    
    private final JLabel lblComputerlab = new JLabel("Computer Lab");
    private final JLabel lblIPAddress = new JLabel("IP Address");
    private final JLabel lblValue = new JLabel("Value");

    private final JTextField txtIPAddress = new JTextField();
    private final JTextField txtValue = new JTextField();

    public ComputerApp() {

        super("Lab App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Set default close operation
        setBounds(500,250,500,250);								//Set the bounds of the application 
        setLayout(null); 										//Set the appliction layout to null

        hbs.setBounds(0, 0, 500, 40);
        hbs.setLayout(null);
        hbs.add(lblComputerlab);
        lblComputerlab.setBounds(0, 0, 500, 40);
        hbs.add(lblComputerlab);
        add(hbs);

        hba.setBounds(0, 30, 480, 170);
        hba.setLayout(new GridLayout(5, 2, 4, 4));
        hba.add(lblIPAddress);
        hba.add(txtIPAddress);
        hba.add(lblValue);
        hba.add(txtValue);

        hba.add(btnPlus);
        btnPlus.addActionListener(this);
        hba.add(btnShowComputers);
        btnShowComputers.addActionListener(this);
        hba.add(btnClear);
        btnClear.addActionListener(this);
        hba.add(btnExit);
        btnExit.addActionListener(this);
        add(hba);

        setLocationRelativeTo(null); 	//Set the Application to the center
        setVisible(true);				//Set the Application to be visible
    }

    private void clear() {
    	txtIPAddress.setText(null);
        txtValue.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnPlus) {

            try {
            	
                String sIPAddress = txtIPAddress.getText();
                if (Float.parseFloat(txtValue.getText()) >= 0) {

                    float fValue = Float.parseFloat(txtValue.getText());

                    objectComputer = new Computer(sIPAddress, fValue);
                    clist.add(objectComputer);

                    JOptionPane.showMessageDialog(null, "Computer Inserted", "Info", 1);
                    clear();
                } else {
                    throw new NegativeValues("Invalid input");
                }
            } catch (NumberFormatException nException) {
                JOptionPane.showMessageDialog(null, "Value input invalid",null, 2);
            } catch (NegativeValues ef) {
                JOptionPane.showMessageDialog(null, "Negative value ",null, 2);
            }
        } else if (source == btnShowComputers) {
            String computers = "";
            for (Computer comp : clist) {
                computers += comp.toString();
            }
            JOptionPane.showMessageDialog(null, computers, "Computers", JOptionPane.INFORMATION_MESSAGE);
        }
		else
		if(source==btnClear)
		{
			txtIPAddress.setText("");	//Clear the text field IP Address
			txtValue.setText("");		//Clear the text field Value
		}
		else
		if(source==btnExit)
			System.exit(0);		//Application exit
	}
    

    public static void main(String[] args) {
    	ComputerApp computerApp = new ComputerApp();
    }
}
