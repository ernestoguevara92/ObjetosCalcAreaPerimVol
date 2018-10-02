package objetosAPV;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Calc {

	protected Shell shell;
	private Text lado;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calc window = new Calc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Roberto Ernesto Guevara
	 * Programa para calcular Area y perimetro de un cuadrado y volumen de un cubo
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("APV");
		
		lado = new Text(shell, SWT.BORDER);
		lado.setBounds(142, 54, 174, 26);
		
		Label lblIngresaLaMedida = new Label(shell, SWT.NONE);
		lblIngresaLaMedida.setBounds(132, 26, 200, 20);
		lblIngresaLaMedida.setText("Ingresa la medida de un lado");
		
		final Label ans = new Label(shell, SWT.NONE);
		ans.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		ans.setBounds(10, 217, 412, 26);
		ans.setText("Respuesta: ");
		
		Button area = new Button(shell, SWT.NONE);
		area.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Double side;
				try {
					side = Double.parseDouble(lado.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shell, "Error", "Ingresa un número");
					return;
				}
				Double answer = side*side;
				ans.setText("Respuesta: "+answer+" unidades cuadrados");
			}
		});
		area.setBounds(164, 143, 132, 30);
		area.setText("Calcular Area");
		
		Button perim = new Button(shell, SWT.NONE);
		perim.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Double side;
				try {
					side = Double.parseDouble(lado.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shell, "Error", "Ingresa un número");
					return;
				}
				Double answer = side*3;
				ans.setText("Respuesta: "+answer+" unidades");
			}
		});
		perim.setBounds(164, 103, 132, 30);
		perim.setText("Calcular Perimetro");
		
		Button vol = new Button(shell, SWT.NONE);
		vol.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Double side;
				try {
					side = Double.parseDouble(lado.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shell, "Error", "Ingresa un número");
					return;
				}
				Double answer = side*side*side;
				ans.setText("Respuesta: "+answer+" unidades cubicos");
			}
		});
		vol.setBounds(164, 179, 132, 30);
		vol.setText("Calcular Volumen");
	}
}
