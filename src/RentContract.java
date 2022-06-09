
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RentContract extends JFrame {

	private JPanel contentPane;

	public RentContract(final CarForRent temp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 1043, 704);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location
		
		
		setLocation(x, y);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(temp.getBrand());
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		lblNewLabel.setBounds(407, 10, 301, 72);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Model: " + temp.getModel());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(707, 141, 198, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Engine Type: " + temp.getEngineType());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(707, 184, 245, 40);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Year: " + temp.getYear());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(707, 238, 231, 37);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Color: " + temp.getColor());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(707, 290, 231, 33);
		contentPane.add(lblNewLabel_5);

		ImageIcon image_2 = new ImageIcon(temp.getImage()); // image showing operations
		ImageIcon imageIcon_2 = new ImageIcon(image_2.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));

		JLabel lblNewLabel_7 = new JLabel(imageIcon_2);
		lblNewLabel_7.setBounds(67, 102, 641, 444);
		contentPane.add(lblNewLabel_7);

		JButton btnNewButton = new JButton("RENT NOW");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i < Login.company.getCarsForRent().size(); i++) {
						if (temp.getId() == Login.company.getCarsForRent().get(i).getId()) {
							if (Login.customer.getBudget() - SelectDay.howManyDays * temp.getPricePerHour() >= 0) {// it
																													// calculates
																													// total
																													// cost

								Login.customer.setBudget(
										Login.customer.getBudget() - SelectDay.howManyDays * temp.getPricePerHour());
								JOptionPane.showMessageDialog(contentPane, "Successfully Rented");// it refreshes budget
																									// when customer has
																									// enough money
								temp.setAvailable(false);

								FileWriter fileWritter = new FileWriter("contrat.txt", true);// writes to the file
								BufferedWriter bw = new BufferedWriter(fileWritter);

								bw.append("\n" + Login.customer + "#" + Login.company.getCarsForRent().get(i) + "#"
										+ SelectDay.howManyDays + "#" + "RENT");

								bw.close();
							} else {
								JOptionPane.showMessageDialog(contentPane, "Insufficient balance");
								break;
							}

						}

					}

					FileWriter fileWritter = new FileWriter("carsforrent.txt");
					for (int j = 0; j < Login.company.getCarsForRent().size(); j++) {
						String temp = Login.company.getCarsForRent().get(j).toString();
						fileWritter.write(temp + "\n");
					}
					fileWritter.close();
				} catch (IOException x) {
					x.printStackTrace();
				}

				try {

					FileWriter fWriter = new FileWriter("customers.txt");
					for (int j = 0; j < Login.company.getCustomerCount(); j++) {
						String temp = Login.company.getCustomer(j).toString();
						fWriter.write(temp + "\n");
					}

					fWriter.close();

				}

				catch (IOException a) {

					System.out.print(a.getMessage());
				}

			}
		});
		btnNewButton.setBounds(699, 421, 239, 55);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_9 = new JLabel("Total Cost : " + SelectDay.howManyDays * temp.getPricePerHour());
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(707, 363, 206, 33);
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RentScreen screen = new RentScreen(0);
				screen.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 10, 58, 27);
		btnNewButton_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("back.png")).getImage()
				.getScaledInstance(70, 21, Image.SCALE_SMOOTH)));
		contentPane.add(btnNewButton_1);

	}
}