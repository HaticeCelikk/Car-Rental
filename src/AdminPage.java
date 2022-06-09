
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 1200, 687);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location

		setLocation(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CAR");
		lblNewLabel.setBounds(122, 58, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("AVAILABILITY  ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(225, 58, 118, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CAR ID");
		lblNewLabel_2.setBounds(12, 58, 45, 13);
		contentPane.add(lblNewLabel_2);

		for (int i = 0; i < Login.company.getCarsForRent().size(); i++) {
			JPanel panel = new JPanel();

			panel.setName(String.valueOf(Login.company.getCarsForRent().get(i).getId()));// setting names to the panels
																							// according to car's id so
																							// program determines which
																							// car is selected

			JButton btnNewButton_1 = new JButton("Change Status");// it allows admin to change available and not
																	// available
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < Login.company.getCarsForRent().size(); i++) {
						String tempCar = Integer.toString(Login.company.getCarsForRent().get(i).getId());
						// temp=Login.company.getCarsForSale().get(i)
						if (panel.getName().equalsIgnoreCase(tempCar)) {
							if (Login.company.getCarsForRent().get(i).isAvailable() == false) {
								Login.company.getCarsForRent().get(i).setAvailable(true);// changing status of the
																							// selected car

							} else {
								Login.company.getCarsForRent().get(i).setAvailable(false);// changing status of the
																							// selected car
							}

						}
					}
				}
			});
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(Color.DARK_GRAY);
			btnNewButton_1.setBounds(362, 8, 118, 21);
			panel.add(btnNewButton_1);

			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(10, 81 + 44 * i, 617, 33);
			contentPane.add(panel);
			panel.setLayout(null);

			JLabel lblNewLabel_4 = new JLabel(Login.company.getCarsForRent().get(i).getBrand() + " "
					+ Login.company.getCarsForRent().get(i).getModel());
			lblNewLabel_4.setBounds(110, 12, 91, 13);
			panel.add(lblNewLabel_4);
			String availability;
			boolean a;

			if (Login.company.getCarsForRent().get(i).isAvailable() == true) {

				availability = "AVAILABLE";
				a = true;

			} else {
				availability = " NOT AVAILABLE";
				a = false;
			}

			JLabel lblNewLabel_5 = new JLabel(availability); // colorization
			if (a) {
				lblNewLabel_5.setForeground(Color.green);
			} else {
				lblNewLabel_5.setForeground(Color.red);
			}

			lblNewLabel_5.setBounds(242, 12, 126, 13);
			panel.add(lblNewLabel_5);

			JLabel lblNewLabel_3 = new JLabel(String.valueOf(Login.company.getCarsForRent().get(i).getId()));
			lblNewLabel_3.setBounds(10, 12, 45, 13);
			panel.add(lblNewLabel_3);

			JButton btnNewButton_2_1 = new JButton("Delete Car");
			btnNewButton_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < Login.company.getCarsForRent().size(); i++) {
						String tempCar = Integer.toString(Login.company.getCarsForRent().get(i).getId());

						if (panel.getName().equalsIgnoreCase(tempCar)) {
							Login.company.getCarsForRent().remove(i);// deleting selected car from the arraylist

						}
					}

				}
			});
			btnNewButton_2_1.setForeground(Color.WHITE);
			btnNewButton_2_1.setBackground(Color.DARK_GRAY);
			btnNewButton_2_1.setBounds(489, 8, 117, 21);
			panel.add(btnNewButton_2_1);

		}
		JButton btnNewButton = new JButton("PROCEED");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// after deleting the selected cars from arraylist this button deletes them from
				// the file
				try {
					FileWriter fileWritter = new FileWriter("carsforrent.txt");
					BufferedWriter bw = new BufferedWriter(fileWritter);
					for (int j = 0; j < Login.company.getCarsForRent().size(); j++) {
						String temp = Login.company.getCarsForRent().get(j).toString();
						bw.write(temp + "\n");
						AdminPage ad = new AdminPage();
						ad.setVisible(true);
						setVisible(false);

					}
					bw.close();
				} catch (IOException x) {
					x.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(501, 54, 117, 21);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_31 = new JLabel("CAR");
		lblNewLabel_31.setBounds(797, 58, 45, 13);
		contentPane.add(lblNewLabel_31);

		JLabel lblNewLabel_1_1 = new JLabel("YEAR");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBackground(SystemColor.menu);
		lblNewLabel_1_1.setBounds(852, 58, 118, 13);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("CAR ID");
		lblNewLabel_2_1.setBounds(687, 58, 45, 13);
		contentPane.add(lblNewLabel_2_1);

		///////////// SALE PART /////////////////
		for (int i = 0; i < Login.company.getCarsForSale().size(); i++) {
			JPanel panel1 = new JPanel();
			panel1.setName(String.valueOf(Login.company.getCarsForSale().get(i).getId()));
			panel1.setBackground(Color.LIGHT_GRAY);
			panel1.setBounds(687, 81 + 44 * i, 490, 33);
			contentPane.add(panel1);
			panel1.setLayout(null);

			JLabel lblNewLabel_6 = new JLabel(String.valueOf(Login.company.getCarsForSale().get(i).getId()));
			lblNewLabel_6.setBounds(10, 10, 45, 13);
			panel1.add(lblNewLabel_6);

			JLabel lblNewLabel_7 = new JLabel(Login.company.getCarsForSale().get(i).getBrand() + " "
					+ Login.company.getCarsForSale().get(i).getModel());
			lblNewLabel_7.setBounds(97, 10, 150, 13);
			panel1.add(lblNewLabel_7);

			JLabel lblNewLabel_8 = new JLabel(Login.company.getCarsForSale().get(i).getYear());
			lblNewLabel_8.setBounds(257, 10, 66, 13);
			panel1.add(lblNewLabel_8);

			JButton btnNewButton_2_1_1 = new JButton("Delete Car");
			btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < Login.company.getCarsForSale().size(); i++) {
						String tempCar = Integer.toString(Login.company.getCarsForSale().get(i).getId());

						if (panel1.getName().equalsIgnoreCase(tempCar)) {
							Login.company.getCarsForSale().remove(i);

						}
					}

				}
			});
			btnNewButton_2_1_1.setForeground(Color.WHITE);
			btnNewButton_2_1_1.setBackground(Color.DARK_GRAY);
			btnNewButton_2_1_1.setBounds(363, 6, 117, 21);
			panel1.add(btnNewButton_2_1_1);

		}
		JButton btnNewButton_11 = new JButton("PROCEED");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileWriter fileWritter = new FileWriter("carsforsale.txt");
					BufferedWriter bw = new BufferedWriter(fileWritter);
					for (int j = 0; j < Login.company.getCarsForSale().size(); j++) {
						String temp = Login.company.getCarsForSale().get(j).toString();
						bw.write(temp + "\n");
						AdminPage ad = new AdminPage(); // refreshing the admin page
						ad.setVisible(true);
						setVisible(false);
					}
					bw.close();
				} catch (IOException x) {
					x.printStackTrace();
				}

			}
		});
		btnNewButton_11.setForeground(Color.DARK_GRAY);
		btnNewButton_11.setBackground(Color.ORANGE);
		btnNewButton_11.setBounds(1048, 54, 117, 21);
		contentPane.add(btnNewButton_11);

		// adding cars to rent
		JButton btnNewButton_2 = new JButton("ADD CAR");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCarRent page = new AddCarRent();
				page.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(12, 10, 109, 38);
		contentPane.add(btnNewButton_2);

		// adding cars to sale
		JButton btnNewButton_2_1 = new JButton("ADD CAR");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCarSale page = new AddCarSale();
				page.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(687, 10, 109, 38);
		contentPane.add(btnNewButton_2_1);

		JLabel lblNewLabel_9 = new JLabel("C A R S   T O   R E N T ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(225, 23, 222, 25);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("C A R S  T O  S A L E");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(874, 23, 222, 25);
		contentPane.add(lblNewLabel_9_1);

		JButton btnNewButton_3 = new JButton("Show All Contrats");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Contract page = new Contract();
				page.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setBounds(457, 19, 161, 25);
		contentPane.add(btnNewButton_3);

	}
}
