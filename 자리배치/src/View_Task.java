import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View_Task extends JFrame{
	public View_Task() {
		try {
			Process ps = Runtime.getRuntime().exec("tasklist");
			BufferedReader br = new  BufferedReader(new InputStreamReader(ps.getInputStream()));
			
			JTextArea t_area = new JTextArea();
			t_area.setEnabled(false);
			t_area.setSize(new Dimension(500, 600));
			t_area.setDisabledTextColor(Color.BLACK);;
			String data;
			
			
//			while((data = br.readLine()) != null) {
//				t_area.append(data+"\n");
//			}
//			br = new BufferedReader(new FileReader(System.getProperty("user.dir")));
			Main.buttonPanel.add(new JScrollPane(t_area));
			Main.buttonPanel.repaint();
			Main.buttonPanel.revalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
