import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectDay extends JFrame {

	private JPanel contentPane;
	public static int howManyDays;
	public SelectDay() {
		//to show the page middle of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 294, 202);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location
		
		
		setLocation(x, y);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 

		JLabel lblNewLabel = new JLabel("How Many Days?");
		lblNewLabel.setBounds(88, 34, 144, 44);
		contentPane.add(lblNewLabel);

		String[] days = { "1", "2", "3", "4", "5", "6", "7" };
		JComboBox comboBox = new JComboBox(days);
		comboBox.setBounds(88, 88, 93, 21);
		contentPane.add(comboBox); 

		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RentScreen page = new RentScreen(0);
				page.setVisible(true);
				setVisible(false);
				howManyDays = Integer.parseInt((String) comboBox.getSelectedItem());
			}

		});
		btnNewButton.setBounds(88, 119, 93, 21);
		contentPane.add(btnNewButton);

	}
}
