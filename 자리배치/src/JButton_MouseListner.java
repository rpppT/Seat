import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class JButton_MouseListner extends MouseAdapter implements MouseMotionListener {
	static String draggedButtonText = "";

	static JButton draggedButton;
	static JButton movedButton;

	static boolean isCalledDraggedMethod;

	public final static ArrayList<JButton> Enabled_Button_List = new ArrayList<>();

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			JButton Enabled_Button = (JButton) e.getSource();
			if (!e.isMetaDown() && Enabled_Button.getBackground() != Color.pink) { // 좌클릭 더블
				if (Enabled_Button.isEnabled()) {
					Enabled_Button.setText("비활성화");
					Enabled_Button.setEnabled(false);
					Enabled_Button_List.add(Enabled_Button);
					for (int i = 0; i < Main.button.length; i++) {
						if (Main.button[i] == Enabled_Button)
							Main.MouseDraggedDisabledButton.add(i);
					}
				} else {
					Enabled_Button_List.remove(Enabled_Button);
					Enabled_Button.setText("");
					Enabled_Button.setEnabled(true);
				}
			} else if (Enabled_Button.isEnabled() && e.isMetaDown()) {
				JButton Fixed_Button = (JButton) e.getSource();
				boolean isAccess = false;

				if (Enabled_Button.isEnabled() && Jmenu_Assigned_Seat_Function.isCanFixed
						&& !Enabled_Button.getText().equals("")) {
					if (Fixed_Button.getBackground() != Color.PINK) {
						Fixed_Button.setBackground(Color.PINK);
					} else {
						Fixed_Button.setBackground(new JButton().getBackground());
					}
					isAccess = true;
				}
				if (Enabled_Button.isEnabled() && !Enabled_Button.getText().equals("") && !isAccess) {
					if (Fixed_Button.getBackground() != Color.PINK) {
						Fixed_Button.setBackground(Color.PINK);
					} else {
						Fixed_Button.setBackground(new JButton().getBackground());
					}
				}
			}
		}
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		draggedButton = (JButton) (arg0.getSource());

		if (!Enabled_Button_List.contains(draggedButton)) {
			draggedButtonText = draggedButton.getText();
			isCalledDraggedMethod = true;
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (!draggedButtonText.equals("") && draggedButton != null && isCalledDraggedMethod
				&& (arg0.getSource()) instanceof JButton) {
			movedButton = (JButton) (arg0.getSource());
			if (!Enabled_Button_List.contains(movedButton)) {
				String t_text = movedButton.getText();

				draggedButton.setText(t_text);
				movedButton.setText(draggedButtonText);
			}
		}
		isCalledDraggedMethod = false;
	}
}
