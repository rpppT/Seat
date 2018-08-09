import java.awt.Color;
import java.awt.Font;

public class ImagePanel_BackGround_Change implements Runnable {
	@Override
	public void run() {
		Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.GRAY, Color.PINK, Color.CYAN };
		int i = 0;

		while (true) {
			try {
				Thread.sleep(100);
				Jmenu_Assigned_Seat_Function.font_size = (int) (Math.random() * 30 + 10);
				Main.buttonPanel.setBackground(color[(int) (Math.random() * color.length)]);
				Main.imagePanel.setBackground(color[(int) (Math.random() * color.length)]);
				if (Jlist_Event.seat_cnt >= 1) {
					Main.button[(int) (Math.random() * Main.button.length)]
							.setBackground(color[(int) (Math.random() * color.length)]);
//					for (int j = 0; j < Main.button.length; j++)
//						Main.button[j].setFont(new Font("TEST", Font.BOLD, Jmenu_Assigned_Seat_Function.font_size));
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
