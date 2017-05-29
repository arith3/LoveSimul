package namori.love.code;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ExamPan extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExamPan() {
		
		JPanel panel = new JPanel();
		panel.setSize(FrameLayout.FrameWidth, FrameLayout.FrameHeight);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		
		JButton btnNewButton_2 = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textArea, Alignment.TRAILING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(143))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(64)
							.addComponent(btnNewButton_1)
							.addGap(65)
							.addComponent(btnNewButton_2))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

	}
}
