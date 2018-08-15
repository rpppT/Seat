import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Jmenu_StudentsFrame extends JFrame implements ActionListener
{
	public static final long serialVersionUID = 1111111111111111111L;
	static Jmenu_StudentsFrame dataFrame;	
	static JButton[] button = new JButton[2];
	
	public Jmenu_StudentsFrame() {
		this(new JButton("학생 수 입력"), new JButton("학생 이름 입력"));
		dataFrame = this;
		
		setPreferredSize(new Dimension(150,150));
		pack();
		setLocation(500,500);
		setResizable(false);
		setVisible(false);
	}
	
	Jmenu_StudentsFrame(JButton bt1 , JButton bt2){
		button[0] = bt1;
		button[1] = bt2;
		
		button[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jmenu_Students_Input_Num.s_input.setVisible(true);
			}
		});
		
		button[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student_TextField_Frame.textField = new  JTextField[Jmenu_Students_Input_Num.total];
				Student_TextField_Frame.total_student = Jmenu_Students_Input_Num.total;
				Student_TextField_Frame.textFrame.setVisible(true);
				Student_TextField_Frame.textFrame.SetTextValue();
			}
		});
		button[1].setEnabled(false);
		
		setLayout(new GridLayout(2,1));
		
		add(button[0]);
		add(button[1]);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Student_TextField_Frame.textField = new JTextField[Jmenu_Students_Input_Num.total];
		Student_TextField_Frame.total_student = Jmenu_Students_Input_Num.total;
		Student_TextField_Frame.textFrame.SetTextValue();
		Student_TextField_Frame.textFrame.setVisible(true);
	}
}
