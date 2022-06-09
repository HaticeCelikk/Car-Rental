
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

public class AddCarRent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JLabel lblColor;
	private JTextField textField_6;
	private JButton btnNewButton_1;
	private static String filePath;

	public AddCarRent() {
		Register r = new Register(); // To use methods and functions from register class
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 306);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Brand : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(10, 51, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblModel = new JLabel("Model :");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModel.setForeground(SystemColor.text);
		lblModel.setBounds(187, 51, 45, 13);
		contentPane.add(lblModel);

		JLabel lblNewLabel_1 = new JLabel("Year : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(370, 51, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblEngineType = new JLabel("Engine Type :");
		lblEngineType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEngineType.setForeground(SystemColor.text);
		lblEngineType.setBounds(10, 103, 76, 13);
		contentPane.add(lblEngineType);

		JLabel lblEngineSize = new JLabel("Engine Size :");
		lblEngineSize.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEngineSize.setForeground(SystemColor.text);
		lblEngineSize.setBounds(187, 103, 76, 13);
		contentPane.add(lblEngineSize);

		JLabel lblNewLabel_2 = new JLabel("Price Per Hour :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(370, 103, 98, 13);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(10, 63, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 63, 96, 19);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(370, 63, 96, 19);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 116, 96, 19);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(187, 116, 96, 19);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(370, 116, 96, 19);
		contentPane.add(textField_5);

		JLabel lblNewLabel_3 = new JLabel("A D D  C A R");// New cars are added by admin in this block
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(185, 10, 98, 19);
		contentPane.add(lblNewLabel_3);

		btnNewButton = new JButton("P R O C E E D "); // When clicked proceed button to delete selected cars at the same
														// time
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ----------when new cars are adding by admin this block assignes inputs to
				// variables ------------
				Component frame = null;
				String brand = textField.getText();
				String model = textField_1.getText();
				String color = textField_6.getText();
				String year = textField_2.getText();
				String engineType = textField_3.getText();
				String engineSize = textField_4.getText();
				String price = textField_5.getText();
				// -------------------------------------------------------
				boolean goodToAdd = false;
				if (r.isNumber(price) == false || price.isBlank() == true) { // it assures price and year are not string
																				// and not blank
					JOptionPane.showMessageDialog(frame, "Price Must Be An Integer");

				}
				if (r.isNumber(year) == false || year.isBlank() == true) {
					JOptionPane.showMessageDialog(frame, "Year Must Be An Integer");

				}
				if (brand.isBlank() || model.isBlank() || color.isBlank() || engineType.isBlank()
						|| engineSize.isBlank()) {// it controls whether it is blank or not
					JOptionPane.showMessageDialog(frame, "Invalid Entry");

				} else {
					goodToAdd = true;
				}

				int id = Login.company.getLastCarRent().getId() + 1;

				// if there is no image in adding process
				if (filePath == null) {
					filePath = "C:\\Users\\oykus\\eclipse-workspace\\carrental\\images\\nullimage.jpg";
				}

				if (goodToAdd == true) {// if all conditions are correct then it writes to file and adds to arraylist
					try {
						FileWriter fileWritter = new FileWriter("carsforrent.txt", true);
						BufferedWriter bw = new BufferedWriter(fileWritter);

						bw.append("\n" + id + ";" + brand + ";" + model + ";" + color + ";" + year + ";" + engineType
								+ ";" + engineSize + ";" + "true" + ";" + price + ";" + filePath);
						JOptionPane.showMessageDialog(frame, "Succesfully Added!");
						bw.close();
						CarForRent carforrent = new CarForRent(id, brand, model, color, year, engineType, engineSize,
								true, Integer.parseInt(price), filePath);
						Login.company.addCarForRent(carforrent);
					} catch (IOException x) {
						x.printStackTrace();
					}
					AdminPage page = new AdminPage(); // after the adding or deleting operations admin page is refreshed
					page.setVisible(true);
					setVisible(false);

				}

			}
		});
		btnNewButton.setForeground(SystemColor.activeCaption);
		btnNewButton.setBounds(104, 238, 266, 21);
		contentPane.add(btnNewButton);

		lblColor = new JLabel("Color :");
		lblColor.setForeground(Color.WHITE);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setBounds(10, 166, 76, 13);
		contentPane.add(lblColor);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 179, 96, 19);
		contentPane.add(textField_6);

		btnNewButton_1 = new JButton("Add Image");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFileChooser j = new JFileChooser(System.getProperty("user.home") + "/Desktop");
				filePath = null;
				int result = j.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = j.getSelectedFile();
					filePath = selectedFile.getAbsolutePath();
					// select file
				} else if (result == JFileChooser.CANCEL_OPTION) {
					filePath = "";
				}

			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(10, 11, 96, 21);
		contentPane.add(btnNewButton_1);
	}

}
