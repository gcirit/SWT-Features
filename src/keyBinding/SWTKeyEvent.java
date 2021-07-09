package keyBinding;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTKeyEvent {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("KeyListener Example");

		shell.setLayout(new GridLayout());

		Button button = new Button(shell, SWT.CENTER);

		button.setText("Type here and use optionally meta keys");

		button.addKeyListener(KeyListener.keyPressedAdapter(e -> handleKeyEvent(e)));

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static void handleKeyEvent(KeyEvent e) {
		String string = "";

		// check click together?
		if ((e.stateMask & SWT.ALT) != 0)
			string += "ALT ";
		if ((e.stateMask & SWT.CTRL) != 0)
			string += "CTRL ";
		if ((e.stateMask & SWT.SHIFT) != 0)
			string += "SHIFT ";

		if (e.keyCode == SWT.BS) {
			string += "BACKSPACE ";
		}

		if (e.keyCode == SWT.ESC) {
			string += "ESCAPE ";
		}

		// check characters (digits are from 48 to 57)
		if ((e.keyCode >= 97 && e.keyCode <= 122) || (e.keyCode >= 48 && e.keyCode <= 57)) {
			string += " " + e.character + " - keyCode = " + e.keyCode;
		}

		if (!string.equals("")) {
			System.out.println(string);
		}
	}

}
