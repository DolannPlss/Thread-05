package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ThreadCorrida extends Thread{
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private int i;
	private double ale;
	private double dist=15;
	private JTextArea textPerdedor;
	private JTextArea textVencedor;
	private static int ganhador=0;
	private JButton btnCorrida;

	
	public ThreadCorrida(JLabel lblCarro1, JLabel lblCarro2,int i,JTextArea textPerdedor, JTextArea textVencedor,JButton btnCorrida) {
		this.lblCarro1=lblCarro1;
		this.lblCarro2=lblCarro2;
		this.i=i;
		this.textPerdedor=textPerdedor;
		this.textVencedor=textVencedor;
		this.btnCorrida=btnCorrida;
	}
	
	public void run() {
		ganhador=0;
		do {
		ale=(double) (Math.random()*1);
		dist=dist+ale;
		try {
			sleep(0,1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if (i==0){
				lblCarro1.setBounds((int) dist, 90, 42, 17);
				if (dist>=650){
					if (ganhador==0){
						posi();
						textVencedor.setText("Carro1");
						textPerdedor.setText("Carro2");
						btnCorrida.setVisible(true);
					}
				}
			}else if (i==1){
				lblCarro2.setBounds((int) dist, 154, 42, 17);
				if (dist>=650){
					if (ganhador==0){
						posi();
						textVencedor.setText("Carro2");
						textPerdedor.setText("Carro1");
						btnCorrida.setVisible(true);
					}
				}
			}
		}while(dist<=650);
//		if (ganhador == 0) {
//			textVencedor.setText("Carro1");
//			textPerdedor.setText("Carro2");
//		} else{if (ganhador == 1){
//			textVencedor.setText("Carro2");
//			textPerdedor.setText("Carro1");
//		}
//		}
	}
	public void posi() {
		ganhador++;
	}
}
