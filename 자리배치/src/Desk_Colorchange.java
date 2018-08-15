import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desk_Colorchange implements ActionListener, Runnable {
	Color[] color = { Color.BLACK, Color.WHITE, Color.CYAN, Color.BLUE, Color.GRAY, Color.RED, Color.GREEN,
			Color.ORANGE, Color.PINK, Color.YELLOW };
	boolean isVisit;
	Thread thread = new Thread(this);

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(50);
				for (int i = 0; i < color.length; i++) {
					int rand = (int) (Math.random() * color.length);
					Main.desk.setBackground(color[rand]);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("fsdf");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!isVisit) {
			thread.start();
		} else {
			thread.interrupt();
		}
	}
}
