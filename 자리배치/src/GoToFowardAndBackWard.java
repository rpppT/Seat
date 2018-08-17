
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GoToFowardAndBackWard {
	private final static GoToFowardAndBackWard goto_instance = new GoToFowardAndBackWard();
    static Stack<JButton[]> backward_stack = new Stack<>();
	static Stack<JButton[]> foward_stack = new Stack<>();
	static Stack<Integer> panel_length_stack = new Stack<>();
	static Stack<LayoutManager> sub_layout_stack = new Stack<>();
    static Stack<Integer> row_stack = new Stack<>();
	static Stack<Integer> column_stack = new Stack<>();
	static Stack<LayoutManager> main_layout_stack = new Stack<>();
	static Stack<Integer> color_index_stack = new Stack<>();
	
	static int ch_row , ch_column;
	static int previous_len;
	static LayoutManager previous_layout;
	
	static int count;
	
	public static boolean isModified;
	
	public static GoToFowardAndBackWard return_goto_instance() {
		return goto_instance;
	}
	
	/* 수정 코드 */
	public static JButton[] newMemoryAddress(JButton [] src, int len) {
		JButton [] ret_new_button = new JButton[len];
		for(int i = 0 ; i< len; i++) {
			ret_new_button[i] = new JButton(src[i].getText());
			if(!src[i].isEnabled()) {
				ret_new_button[i].setEnabled(false);
			}if(src[i].getBackground() == Color.PINK) {
				ret_new_button[i].setBackground(Color.PINK);
			}
		}
		return ret_new_button;
	}

	public static void Save_previous_data() {
		ch_row =  Main.row;
		ch_column = Main.column;
		row_stack.push(Main.row);
		column_stack.push(Main.column);
		panel_length_stack.push(Main.panel.length);
		sub_layout_stack.push(Main.panel[0].getLayout());
		main_layout_stack.push(Main.buttonPanel.getLayout());
		backward_stack.push(newMemoryAddress(Main.button, Main.button.length));
		Main.goBackward_Menu.setEnabled(true);
	}

	public static void stack_same_func(int len, JButton [] pop_stack_button) {
		int P_len = panel_length_stack.pop();
//		int pp_len =  Pseud
		int row  = row_stack.pop();
//		int column = column_stack.pop();
		int i, j;
		int k = 0 ;

		LayoutManager sub_layout = sub_layout_stack.pop();

	
		
		
	
		if(count++ > 0) {
			if(previous_len != P_len) {
				Main.buttonPanel.removeAll();
				Main.buttonPanel.revalidate();
				Main.buttonPanel.repaint();
				P_len = previous_len;
				Main.buttonPanel.setLayout(previous_layout);
			}else {
				Main.buttonPanel.setLayout(main_layout_stack.pop());
			}
		}
		
		Main.panel = new JPanel[P_len];
		for(i = 0 ; i < P_len; i++) {
			Main.panel[i] = new JPanel();
			Main.panel[i].setLayout(sub_layout);
			Main.buttonPanel.add(Main.panel[i]);
		}
	  for(j = 0 ; j < P_len; j++) {
		for ( i =k; i < row * 2 + k; i++) {
			boolean isEnabled = pop_stack_button[i].isEnabled();
			
			
			if(isEnabled) {
				Main.button[i] = new JButton(pop_stack_button[i].getText());
			}else {
				Main.button[i] = new JButton(pop_stack_button[i].getText());
				Main.button[i].setEnabled(false);
			}
			if(pop_stack_button[i].getBackground() == Color.PINK) {
				Main.button[i].setBackground(Color.PINK);
			}
			Main.button[i].setFont(new Font("test", Font.BOLD, Jmenu_Assigned_Seat_Function.font_size));
			Main.button[i].addMouseMotionListener(new JButton_MouseListner());
			Main.button[i].addMouseListener(new JButton_MouseListner());
			Main.panel[j].add(Main.button[i]);
		}
	      k += row * 2;
	      Main.buttonPanel.add(Main.panel[j]);
	  }
	  previous_len = P_len;
	  previous_layout =  Main.buttonPanel.getLayout();
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
	}
	public static void Foward() { 
		if(foward_stack.size() <= 0) {
			Main.goFowarRd_Menu.setEnabled(false);
			return;
		}
		Main.buttonPanel.removeAll();
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
		JButton [] pop_stack_button =  foward_stack.pop();

		
		row_stack.push(Main.row);
		column_stack.push(Main.column);
		panel_length_stack.push(Main.panel.length);
		sub_layout_stack.push(Main.panel[0].getLayout());
		main_layout_stack.push(Main.buttonPanel.getLayout());
		backward_stack.push(newMemoryAddress(Main.button, Main.button.length));
		
		
		
		int len = pop_stack_button.length;
		Main.button = new JButton[len];
		
		stack_same_func(len,pop_stack_button);

		Main.goBackward_Menu.setEnabled(true);
	}

	public static void BackWard() {
	 if(backward_stack.size()<= 0) {
		 Main.goBackward_Menu.setEnabled(false);
		 return;
	 }
	 
		Main.buttonPanel.removeAll();
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();

		JButton [] pop_stack_button =  backward_stack.pop();
		
		
		
		row_stack.push(Main.row);
		column_stack.push(Main.column);
		panel_length_stack.push(Main.panel.length);
		sub_layout_stack.push(Main.panel[0].getLayout());
		main_layout_stack.push(Main.buttonPanel.getLayout());
		foward_stack.push(newMemoryAddress(Main.button, Main.button.length));
		
		int len = pop_stack_button.length;
		Main.button = new JButton[len];
		
		stack_same_func(len,pop_stack_button);
		
		Main.goFowarRd_Menu.setEnabled(true);
	}

}
