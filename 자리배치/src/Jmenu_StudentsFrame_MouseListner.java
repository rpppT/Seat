import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;


public class Jmenu_StudentsFrame_MouseListner  extends MouseAdapter{
	@Override
	public void mousePressed(MouseEvent e) {
		JList list = (JList)e.getSource();
		if(e.getClickCount() == 2) {
			Jmenu_Students_Input_Num.total = (int)list.getSelectedValue();
			Jmenu_StudentsFrame.button[1].setEnabled(true);
			Jmenu_StudentsFrame.dataFrame.revalidate();
			Jmenu_StudentsFrame.dataFrame.repaint();
			Jmenu_Students_Input_Num.s_input.dispose();
		}
	}
}
