import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Jlist_Event extends MouseAdapter{
	static int action_count;
	static int seat_cnt;

	public static  void ArrangeSeat() {
		
		seat_cnt++;
		
		Main.buttonPanel.removeAll();
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
		for(int i =0 ; i<Main.panel.length; i++)
			Main.buttonPanel.add(Main.panel[i]);
		
		int k  = 0;
		
	 for(int l = 0 ; l <Main.panel.length; l++) {
		for(int i=k; i<Main.row * 2 + k ; i++) {
			Main.button[i] = new JButton();
			Main.button[i].addMouseMotionListener(new JButton_MouseListner());
			Main.button[i].addMouseListener(new JButton_MouseListner());
			Main.panel[l].add(Main.button[i]);
		}
		k = k + Main.row * 2;
	 }

		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
		
		Main.Bring_Student_Info_Menu.setEnabled(true);
		Main.Button_Func_Menu.setEnabled(true);
		
		Jmenu_Assigned_Seat_Function.isCanFixed = false;
		
		JMenu_RowAndCol_Function.this_var.dispose();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2) {

			int idx = JMenu_RowAndCol_Function.list.getSelectedIndex();
			if (idx == 0) {
				Main.row = 5;
				Main.column = 6;
				Main.panel = new JPanel[3];
			} else if (idx == 1) {
				Main.row = 5;
				Main.column = 8;
				Main.panel = new JPanel[4];
			} else if (idx == 2) {
				Main.row = 6;
				Main.column = 6;
				Main.panel = new JPanel[3]; 
			}
			
			for(int i = 0 ; i<Main.panel.length; i++) {
				Main.panel[i] = new JPanel();
				Main.panel[i].setLayout(new GridLayout(Main.row, 2, 0, 10));
			}
			
			Main.button = new JButton[Main.row * Main.column];
			
			Main.buttonPanel.setLayout(new GridLayout(1,Main.panel.length,30,0));
			Main.buttonPanel.revalidate();
			Main.buttonPanel.repaint();

		    Jlist_Event.ArrangeSeat();
		}
	}
}
