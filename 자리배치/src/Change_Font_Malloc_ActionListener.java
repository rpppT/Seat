import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Change_Font_Malloc_ActionListener extends JFrame implements ActionListener{
	private JSlider slider = new JSlider(10,30);
	private String des = "FONT_SIZE = ";
	
	private JLabel current_text = new JLabel(des+Jmenu_Assigned_Seat_Function.font_size);
	
	public Change_Font_Malloc_ActionListener() {
		
		slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int len = Main.button.length;
				int font_size = Jmenu_Assigned_Seat_Function.font_size; 
			    int i;
				font_size = slider.getValue();
				
				for(i=0; i<len; i++) {
					Main.button[i].setFont(new Font("TEST", Font.BOLD, font_size));
				}
				Jmenu_Assigned_Seat_Function.font_size = font_size;
				current_text.setText(des+font_size);
				Main.buttonPanel.revalidate();
				Main.buttonPanel.repaint();
			}
		});
        current_text.setFont(new Font("TEST", Font.BOLD, 30));
        add(current_text, BorderLayout.NORTH);
        add(slider,BorderLayout.CENTER);
		setTitle("폰트 크기 변경");
		setResizable(false);
		pack();
		setSize(300,300);
		setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(true);
	}
}
