import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClassAutoSave implements Serializable, Runnable{
	public static final long serialVersionUID = 1111111111111111111L;

	@Override
	public void run() {
		while(true) {
			try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\Capture.ser"));
					oos.writeObject(Main.data);
					oos.close();
			     	Thread.sleep(0,0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
