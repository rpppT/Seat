
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ScreenShot extends JFrame implements Runnable {
	public static final long serialVersionUID = 1111111111111111111L;// 클래스 버전 아이디
	public static ScreenShot screenshot;
	
	private static int Screenshot_Count;
	private final static File file = new File(System.getProperty("user.home") + "/Desktop/Screenshot.gif");

	final static JMenu Menu = new JMenu("문서로 인쇄");
	final static JMenuBar Menubar = new JMenuBar();
	
	final static JMenuItem interrupt_thead = new JMenuItem("thread interrupt");
	final static JMenuItem dispatch_thread = new JMenuItem("thread dispatch");
	
	final static JMenu thread_menu = new JMenu("스레드 기능");
	
	static boolean isInterupted;
	static boolean threadRun;
	
	public ScreenShot() {
		setTitle("Applicatoin Monitoring");
		screenshot = this;
		
		interrupt_thead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isInterupted = true;
			}
		});
		dispatch_thread.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!threadRun) {
					Thread thread = new Thread(ScreenShot.screenshot);
					thread.start();
					threadRun = true;
				}
				isInterupted = false;
			}
		});
		
		thread_menu.add(interrupt_thead);
		thread_menu.add(dispatch_thread);
		
		Menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					File method_file = new File(System.getProperty("user.home") + "\\JavaAppData\\인쇄.jar");
					if (!method_file.exists()) {
						JOptionPane.showMessageDialog(null, "문서 인쇄 파일 존재 x");
						return;
					} else {
						Runtime.getRuntime().exec("java -jar " + method_file.getAbsolutePath());
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Menubar.add(thread_menu);
		Menubar.add(Menu);
		setJMenuBar(Menubar);

		setPreferredSize(new Dimension(850 - 50, 950 + 50 - 10 - 50 - 10 - 50));
		pack();
		setResizable(false);
		setVisible(false);
	}

	public void takeScreenshot() {
		try {

			Robot robot = new Robot();
			BufferedImage bi = robot.createScreenCapture(new Rectangle(Main.main_frame.getX(), Main.main_frame.getY(),
					Main.main_frame.getWidth(), Main.main_frame.getHeight()));

			if (!file.exists())
				file.createNewFile();

			ImageIO.write(bi, "gif", file);
			Image image = ImageIO.read(file);
			JLabel label = new JLabel(new ImageIcon(image));

			if (++Screenshot_Count > 0) {
				getContentPane().removeAll();
				add(label);
			} else {
				getContentPane().add(label);
			}

			revalidate();
			repaint();

			if (!this.isVisible()) {
				this.setVisible(true);

				revalidate();
				repaint();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(!isInterupted) {
			try {
				takeScreenshot();
				Thread.sleep(0,0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(threadRun)
			threadRun = false;
	}
}