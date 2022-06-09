import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_4;

	public static boolean isString(String s) { // it controls if the input is full string
		String numbers = "1234567890";
		String symbols = "\".,!'^+%&/()=?_-*;:>£#$½{[]}|";
		boolean isString = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < numbers.length(); j++) {
				if (s.charAt(i) == numbers.charAt(j)) {
					isString = false;
					;
				}
			}

			for (int k = 0; k < symbols.length(); k++) {
				if (s.charAt(i) == symbols.charAt(k)) {
					isString = false;
					;
				}
			}

		}
		return isString;
	}

	public static boolean isAlreadyTaken(String s, Company company) {// it controls if the input is full string
		boolean isTaken = false;
		for (int i = 0; i < company.getCustomerCount(); i++) {
			if ((company.getCustomer(i).getUsername()).equalsIgnoreCase(s)) {
				isTaken = true;
			}

		}
		return isTaken;

	}

	public static boolean noNumbers(String s) {// it controls if the input has dont include numbers
		String numbers = "1234567890";

		boolean noNumbers = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < numbers.length(); j++) {
				if (s.charAt(i) == numbers.charAt(j)) {
					noNumbers = false;
					;
				}
			}
		}
		return noNumbers;
	}

	public static boolean isNumber(String s) {// it controls if the input is full numbers
		String strings = "qwertyuýopðüasdfghjklþizxcvbnmöç.,:;\"!'^+%&/()=?_-é<>£#$½{[]}|";
		boolean isNumber = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < strings.length(); j++) {
				if (s.charAt(i) == strings.charAt(j)) {
					isNumber = false;

				}
			}
		}
		return isNumber;

	}

	public static boolean noSymbols(String s) { // it controls if the input has dont include symbols
		String symbols = "\",!'^+%&/()=?-*;:>£#$½{[]}|";
		boolean noSymbols = true;
		for (int i = 0; i < s.length(); i++) {
			for (int k = 0; k < symbols.length(); k++) {
				if (s.charAt(i) == symbols.charAt(k)) {
					noSymbols = false;
					;
				}
			}
		}
		return noSymbols;
	}

	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 408, 663);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		setLocation(x, y);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(109, 10, 185, 178);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png")).getImage()
				.getScaledInstance(185, 178, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setBounds(35, 378, 52, 35);
		lblNewLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png")).getImage()
				.getScaledInstance(44, 35, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel1, BorderLayout.WEST);

		JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setBounds(35, 301, 40, 28);
		lblNewLabel2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/email.png")).getImage()
				.getScaledInstance(40, 30, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel2, BorderLayout.WEST);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 348, 78, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(34, 224, 65, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Surname");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(34, 268, 94, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(34, 425, 78, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(35, 508, 69, 20);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Budget");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(36, 548, 160, 20);
		contentPane.add(lblNewLabel_7);

		textField = new JTextField();
		textField.setBounds(109, 221, 244, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(109, 261, 244, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(109, 301, 244, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(109, 341, 244, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(109, 381, 144, 27);
		contentPane.add(passwordField);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(109, 421, 244, 27);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(109, 501, 244, 27);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(109, 541, 244, 27);
		contentPane.add(textField_7);

		final JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBackground(new Color(173, 216, 230));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char) 0); // password = JPasswordField
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(254, 384, 122, 21);
		contentPane.add(chckbxNewCheckBox);
		///////////////////////////////////////////////////////////////////////////////////////
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // it assignes inputs to variables
				String name = textField.getText();
				String surname = textField_1.getText();
				String city = textField_6.getText();
				String email = textField_2.getText();
				String username = textField_3.getText();
				String password = passwordField.getText();
				String phone = textField_5.getText();
				String budget = textField_7.getText();
				String gender = textField_4.getText();

				boolean availableToRegister = true;// it controls inputs is not blank or the false input
				Component frame = null;
				if (isString(name) == false || isString(surname) == false || name.isBlank() == true
						|| surname.isBlank() == true) {
					JOptionPane.showMessageDialog(frame, "Invalid Name/Surname entry");
					availableToRegister = false;
				}

				if (isString(city) == false || city.isBlank() == true) {
					JOptionPane.showMessageDialog(frame, "Invalid city name entry");
					availableToRegister = false;
				}

				if (noSymbols(username) == false || username.isBlank() == true) {
					JOptionPane.showMessageDialog(frame, "Invalid username");
					availableToRegister = false;
				}

				if (isNumber(phone) == false || phone.isBlank() == true) {
					JOptionPane.showMessageDialog(frame, "Invalid phone number");
					availableToRegister = false;
				}

				boolean genderAvailable = false;
				if (gender.isBlank() != false) {
					genderAvailable = true;
				}

				if (isNumber(budget) == true && budget.isBlank() != true) {
					Integer.parseInt(budget);
				} else {
					JOptionPane.showMessageDialog(frame, "Budget must be an integer");
					availableToRegister = false;
				}

				Login.id = Login.company.getLastCustomer().getId();
				if (availableToRegister == true) {// it writes registered customer to the file then the registration is
													// succesfull
					if (isAlreadyTaken(username, Login.company) == false) {
						int id = Login.id;
						try {
							FileWriter fileWritter = new FileWriter("customers.txt", true);
							BufferedWriter bw = new BufferedWriter(fileWritter);

							if (genderAvailable == true) {
								bw.append(("\n" + (id + 1) + ";" + name + ";" + surname + ";" + email + ";" + phone
										+ ";" + city + ";" + username + ";" + password + ";" + budget + ";" + gender));
							} else if (genderAvailable != true)
								bw.append(("\n" + (id + 1) + ";" + name + ";" + surname + ";" + email + ";" + phone
										+ ";" + city + ";" + username + ";" + password + ";" + budget));

							JOptionPane.showMessageDialog(frame, "Succesfully Registered");
							bw.close();
						} catch (IOException x) {
							x.printStackTrace();
						}
						Login page = new Login();
						page.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "This username is already taken");

					}

				} else {
					JOptionPane.showMessageDialog(frame, "Registration is not completed");

				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(138, 581, 122, 35);
		contentPane.add(btnNewButton);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 461, 244, 27);
		contentPane.add(textField_4);

		JLabel lblNewLabel_4 = new JLabel("Gender \r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(35, 461, 65, 28);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_8 = new JLabel("(Optional)");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(35, 483, 70, 13);
		contentPane.add(lblNewLabel_8);

	}
}