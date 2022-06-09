
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

public class AddCarSale extends JFrame {

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
	private JLabel lblKm;
	private JTextField textField_7;
	private JButton btnNewButton_1;

	private static String filePath;

	public AddCarSale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 506, 306);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location
		
		
		setLocation(x, y);
		final Register r = new Register(); // To use methods and functions from register class
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(10, 11, 96, 21);
		contentPane.add(btnNewButton_1);

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

		JLabel lblNewLabel_2 = new JLabel("Price :");
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

		JLabel lblNewLabel_3 = new JLabel("A D D  C A R"); // New cars are added by admin in this block
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(185, 10, 98, 19);
		contentPane.add(lblNewLabel_3);

		final JCheckBox c = new JCheckBox("Second Handed");
		c.setForeground(new Color(0, 0, 139));
		c.setBackground(SystemColor.inactiveCaption);
		c.setBounds(370, 178, 116, 21);
		contentPane.add(c);

		btnNewButton = new JButton("P R O C E E D ");// When clicked proceed button to delete selected cars at the same
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
				String km = textField_7.getText();
				boolean isUsed = false;
				// ---------------------------------------------------------
				if (c.isSelected() == true) {
					isUsed = true;
				}

				boolean goodToAdd = false;
				if (r.isNumber(price) == false || price.isBlank()) {// it assures they are not string and not blank

					JOptionPane.showMessageDialog(frame, "Price Must Be An Integer");

				}
				if (r.isNumber(km) == false || km.isBlank()) {
					JOptionPane.showMessageDialog(frame, "Kilometer Must Be An Integer");

				}
				if (r.isNumber(year) == false || year.isBlank()) {
					JOptionPane.showMessageDialog(frame, "Year Must Be An Integer");

				}

				if (brand.isBlank() || model.isBlank() || color.isBlank() || engineType.isBlank()
						|| engineSize.isBlank()) {// it controls whether it is blank or not
					JOptionPane.showMessageDialog(frame, "Invalid Entry");
				}

				else {
					goodToAdd = true;
				}

				int id = Login.company.getLastCarSale().getId() + 1;

				// if there is no image in adding process
				if (filePath == null) {
					filePath = "C:\\Users\\oykus\\eclipse-workspace\\carrental\\images\\nullimage.jpg";
				}

				if (goodToAdd == true) {// if all conditions are correct then it writes to file and adds to arraylist
					try {
						FileWriter fileWritter = new FileWriter("carsforsale.txt", true);
						fileWritter.append("\n" + id + ";" + brand + ";" + model + ";" + color + ";" + year + ";"
								+ engineType + ";" + engineSize + ";" + km + ";" + isUsed + ";" + price + ";" + "false"
								+ ";" + filePath);

						JOptionPane.showMessageDialog(frame, "Succesfully Added!");
						fileWritter.close();
						CarForSale carforsale = new CarForSale(id, brand, model, color, year, engineType, engineSize,
								km, isUsed, Integer.parseInt(price), false, filePath);
						Login.company.addCarForSale(carforsale);
					} catch (IOException x) {
						x.printStackTrace();
					}
					AdminPage page = new AdminPage();// after the adding or deleting operations admin page is refreshed
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

		lblKm = new JLabel("KM :");
		lblKm.setForeground(Color.WHITE);
		lblKm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKm.setBounds(187, 166, 76, 13);
		contentPane.add(lblKm);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(187, 179, 96, 19);
		contentPane.add(textField_7);

	}
}