import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeFont extends JFrame{
	private JSlider slider = new JSlider(10,30);
	private String des = "FONT_SIZE = ";
	private JLabel current_text = new JLabel(des+Jmenu_Assigned_Seat_Function.font_size);
	static ChangeFont chfont;
	
	public ChangeFont() {
		chfont = this;
		slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				GoToFowardAndBackWard.Save_previous_data();
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
	public void visbile() {
		setVisible(true);
	}
}
