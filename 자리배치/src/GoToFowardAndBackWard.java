
import java.awt.Font;
import java.util.Stack;

import javax.swing.JButton;

public class GoToFowardAndBackWard {
	private final static GoToFowardAndBackWard goto_instance = new GoToFowardAndBackWard();
	final static Stack<JButton[]> backward_stack = new Stack<>();
	final static Stack<JButton[]> foward_stack = new Stack<>();
	
	public static GoToFowardAndBackWard return_goto_instance() {
		return goto_instance;
	}
	
	public static JButton[] newMemoryAddress(JButton [] src, int len) {
		JButton [] ret_new_button = new JButton[len];
		for(int i = 0 ; i< len; i++)
			ret_new_button[i] = new JButton(src[i].getText());
		return ret_new_button;
	}
	public static void Save_previous_data() {
		backward_stack.push(newMemoryAddress(Main.button, Main.button.length));
		Main.goBackward_Menu.setEnabled(true);
	}

	public static void stack_same_func(int len, JButton [] pop_stack_button) {
		for (int i = 0; i < len; i++) {
			String inspect_text = pop_stack_button[i].getText();
			
			if(!inspect_text.equals("비활성화")) {
				Main.button[i] = new JButton(pop_stack_button[i].getText());
			}else {
				Main.button[i] = new JButton(pop_stack_button[i].getText());
				Main.button[i].setEnabled(false);
			}
			Main.button[i].setFont(new Font("test", Font.BOLD, Jmenu_Assigned_Seat_Function.font_size));
			Main.button[i].addMouseMotionListener(new JButton_MouseListner());
			Main.button[i].addMouseListener(new JButton_MouseListner());
			Main.buttonPanel.add(Main.button[i]);
		}

		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
		
//		Heap_Info.update();
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
		
		foward_stack.push(newMemoryAddress(Main.button, Main.button.length));
		
		int len = pop_stack_button.length;
		Main.button = new JButton[len];
		
		stack_same_func(len,pop_stack_button);
		
		Main.goFowarRd_Menu.setEnabled(true);
	}

}
