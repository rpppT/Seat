import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Jlist_Event extends MouseAdapter{
	static int action_count;
	static int seat_cnt;
	public static  void ArrangeSeat() {
		seat_cnt++;
		
		Main.buttonPanel.removeAll();
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
		for(int i=0; i<Main.button.length; i++) {
			Main.button[i] = new JButton();
			Main.button[i].addMouseMotionListener(new JButton_MouseListner());
			Main.button[i].addMouseListener(new JButton_MouseListner());
			Main.buttonPanel.add(Main.button[i]);
		}	
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
		
		Main.Bring_Student_Info_Menu.setEnabled(true);
//		Main.Student_Data_Input_Menu.setEnabled(true);
		Main.Button_Func_Menu.setEnabled(true);
		
		Jmenu_Assigned_Seat_Function.isCanFixed = false;
		
		JMenu_RowAndCol_Function.this_var.dispose();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2) {
			action_count++;

			int idx = JMenu_RowAndCol_Function.list.getSelectedIndex();
		
			if(idx == 0){
				if(action_count == 1) 
				Jmenu_Assigned_Seat_Function.font_size = 20;
				Main.row = 5;
				Main.column = 6;
			}else if(idx == 1){	
				if(action_count == 1) 
				Jmenu_Assigned_Seat_Function.font_size = 12;
				Main.row = 5;
				Main.column = 8;
			}else if(idx == 2) {
				if(action_count == 1) 
				Jmenu_Assigned_Seat_Function.font_size = 20;
				Main.row = 6;
				Main.column = 6;
			}
			Main.button = new JButton[Main.row * Main.column];
			
			
			Main.buttonPanel.setLayout(new GridLayout(Main.row, Main.column,20, 15));
			Main.buttonPanel.revalidate();
			Main.buttonPanel.repaint();
			
			ArrangeSeat();
		}
	}
}
