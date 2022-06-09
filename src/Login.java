import java.awt.BorderLayout;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	public static boolean isMatching(String username, String password, Company company) { //it controls is username and passwords matches for customer
		boolean isMatching = false;
		for (int i = 0; i < company.getCustomerCount(); i++) {
			if ((company.getCustomer(i).getUsername()).equalsIgnoreCase(username)) {
				if ((company.getCustomer(i).getPassword()).equalsIgnoreCase(password)) {
					isMatching = true;
					customer = Login.company.getCustomer(i);
				}
				break;
			}

		}
		return isMatching;

	}
	
	

	public static boolean isMatchingAdmin(String username, String password, Company company) { //it controls is username and passwords matches for admin
		boolean isMatching = false;
		for (int i = 0; i < company.getCustomerCount(); i++) {
			if ((company.getAdmin().getUsername()).equalsIgnoreCase(username)) {
				if ((company.getAdmin().getPassword()).equalsIgnoreCase(password)) {
					isMatching = true;
				}
				break;
			}

		}
		return isMatching;

	}

	public static Company company;
	public static Customer customer;
	public static Login frame;
	public static int id;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 591, 397);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location
		
		
		setLocation(x, y);
		company = new Company();
		try {//reads the txt and adds them into the arraylist called rent
			File myObj = new File("carsforrent.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] temp = line.split(";");
				CarForRent rent = new CarForRent(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6],
						Boolean.parseBoolean(temp[7]),Integer.valueOf(temp[8]),temp[9]);
				Login.company.addCarForRent(rent);

			}
			myReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		
		try {//reads the txt and adds them into the arraylist called sale
			File myObj = new File("carsforsale.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] temp = line.split(";");
				// id brand model color year enginetype enginesize image km isused issold price
				CarForSale sale = new CarForSale(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5],
						temp[6], temp[7], Boolean.parseBoolean(temp[8]),Integer.valueOf(temp[9]), Boolean.parseBoolean(temp[10]),
						temp[11]);
				Login.company.addCarForSale(sale);

			}
			myReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		
		Admin admin = new Admin("admin", "gallery", "deuceng@gmail.com", "5050231025", "izmir", "w", "w");
		company.setAdmin(admin);//admin infos
		
///////// reading the registered customers ////////////
		try {
            File myObj = new File("customers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] temp = line.split(";");
                if (temp.length == 10) {
                    Customer customer1 = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4],
                            temp[5], temp[6], temp[7], Integer.parseInt(temp[8]), temp[9]); // polymorpishm
                    company.addCustomer(customer1);
                } else {
                    Customer customer = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4],
                            temp[5], temp[6], temp[7], Integer.parseInt(temp[8])); // polymorpishm
                    company.addCustomer(customer);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		/////////////////////////////////////////////////////////////////////

		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();

		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(428, 96, 127, 32);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				if (isMatchingAdmin(username,password,company) == true) { //first it controls if inputs matches with admin's infos
					AdminPage page = new AdminPage();
					page.setVisible(true);
					setVisible(false);
				}
				else if (isMatching(username, password, company) == true) {//then it controls if inputs matches with customer's infos
					ChoiceScreen page = new ChoiceScreen();
					page.setVisible(true);
					setVisible(false);
				} else { //if thre is no matching
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Wrong Password or Username");

				}
			}
		});

		getRootPane().setDefaultButton(btnNewButton);

		btnNewButton.addMouseListener(new MouseAdapter() { //same controls
			public void mouseClicked(MouseEvent e) {

				String username = textField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				if (isMatchingAdmin(username,password,company) == true) {
					AdminPage page = new AdminPage();
					page.setVisible(true);
					setVisible(false);
				}
				else if (isMatching(username, password, company) == true) {
					ChoiceScreen page = new ChoiceScreen();
					page.setVisible(true);
					setVisible(false);
				} else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Wrong Password or Username");

				}

			}
		});

		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(450, 204, 86, 25);
		panel.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(428, 161, 129, 32);
		panel.add(passwordField);

		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 400, 350);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/login.jpg")).getImage()
				.getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
		panel.add(lblNewLabel);

		btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register page = new Register();
				page.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(444, 278, 99, 21);
		panel.add(btnNewButton_1);

		lblNewLabel_1 = new JLabel("Username/Email");
		lblNewLabel_1.setBounds(428, 76, 127, 13);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(428, 144, 63, 13);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Don't have an account?");
		lblNewLabel_3.setBounds(428, 255, 150, 13);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Welcome to the");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(450, 10, 126, 32);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Car Gallery");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(460, 32, 63, 25);
		panel.add(lblNewLabel_5);

	}
}
