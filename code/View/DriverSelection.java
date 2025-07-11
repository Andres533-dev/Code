package Proyecto.Code.src.View;
import Proyecto.Code.src.Controler.Driver;
import Proyecto.Code.src.Controler.DriverController;
import Proyecto.Code.src.Model.DriverData;
import Proyecto.Code.src.Model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class DriverSelection extends Create {
	private User user;
	public DriverSelection(User user) throws IOException {
		this.user=user;
		super("Driver Selection");
	}

	@Override
	protected JPanel createPanel() throws IOException {
		String[]carTypes=new String[]{"Xl","Normal","Fast"};
		JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));

		for (int i = 1; i <= 3; i++) {
			Driver dc=new Driver(carTypes[i-1],user);
			JPanel subPanel = createSubPanel(carTypes[i-1] + i + dc.toString());
			addImageToPanel(subPanel);
			addButtonToPanel(subPanel);
			panel.add(subPanel);
		}
		return panel;
	}
	private JPanel createSubPanel(String labelText) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
		subPanel.setBackground(Color.CYAN);
		subPanel.setBorder(new LineBorder(Color.BLACK, 2));
		subPanel.setPreferredSize(new Dimension(200, 150));

		if (!labelText.isEmpty()) {
			JLabel label = new JLabel(labelText);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			subPanel.add(label);
		}

		return subPanel;
	}

	private void addImageToPanel(JPanel panel) {
		ImageIcon originalIcon = new ImageIcon("car.jpg");
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(imageLabel);
	}

	private void addButtonToPanel(JPanel panel) {
		JButton button = new JButton("Select");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Añadir espacio entre los componentes
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(button);
	}
}