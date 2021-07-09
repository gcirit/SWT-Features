package swttutorial.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GridLayoutWithFixedColumnDistribution {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(2, false));

		Composite left = new Composite(shell, SWT.BORDER);
		Composite right = new Composite(shell, SWT.BORDER);

		GridData leftData = new GridData(SWT.FILL, SWT.FILL, true, true);
		GridData rightData = new GridData(SWT.FILL, SWT.FILL, true, true);

		left.setLayoutData(leftData);
		right.setLayoutData(rightData);

		shell.addListener(SWT.Resize, arg0 -> {
			Point size = shell.getSize();

			leftData.widthHint = (int) (size.x * 0.75);
			rightData.widthHint = size.x - leftData.widthHint;

			System.out.println(leftData.widthHint + " + " + rightData.widthHint + " = " + size.x);
		});

		shell.open();
		shell.requestLayout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
