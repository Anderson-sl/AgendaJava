package br.project.bo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JLabel;



public class LabelAgendaDia extends JLabel{

	private Calendar cal;
	private Color backGroundColor; 
	private AgendaDia panel;

	public LabelAgendaDia() {
		Iniciar();
	}
	
	public LabelAgendaDia(Color color) {
		this.backGroundColor = color;
		Iniciar();
	}
	
	public LabelAgendaDia(Color color,AgendaDia panel) {
		this.panel = panel;
		this.backGroundColor = color;
		Iniciar();
	}
	
	public Color getBackGroundColor() {
		if(backGroundColor == null){
			backGroundColor = Color.WHITE;
		}
		return backGroundColor;
	}

	public AgendaDia getPanel() {
		if(panel == null){
			panel = new AgendaDia(200,200);
		}
		return panel;
	}

	public void setPanel(AgendaDia panel) {
		this.panel = panel;
	}

	public void setBackGroundColor(Color backGroundColor) {
		this.backGroundColor = backGroundColor;
	}

	public Calendar getCal() {
		if(cal == null){
			cal = Calendar.getInstance();
		}
		return cal;
	}


	public void setCal(Calendar cal) {
		this.cal = cal;
	}



	private void Iniciar(){
		setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192),1));
		setOpaque(true);
		setBackground(getBackGroundColor());
		setVerticalAlignment(JLabel.TOP);
		addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!getBackground().toString().equals(new Color(192,192,192).toString())){
					addDataSelecionada();
					getPanel().setSelect(true);
					requestFocus();
					getPanel().controleDeSelecao();
				}
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				if(getBackground().toString().equals(new Color(192,192,192).toString()) || 
						getBackground().toString().equals(new Color(255,182,193).toString())){
					
				}else{
					setBackground(new Color(130,180,255));
					setForeground(Color.white);
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent arg0) {
		
					if(getBackground().toString().equals(new Color(192,192,192).toString()) ||
							getBackground().toString().equals(new Color(255,182,193).toString())){
						
					}else{
						setBackground(getBackGroundColor());
						setForeground(Color.black);
					}
			}
			

		});
		
		
	}
	
	public void addDataSelecionada(){
		getPanel().setDataSelect(this);
	}
	
}
