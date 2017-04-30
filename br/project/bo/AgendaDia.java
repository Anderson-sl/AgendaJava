package br.project.bo;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AgendaDia extends JPanel{
	
	private Date dataEscolida;
	private int width,hight,sizeMes,sizeSemana;
	private LabelAgendaDia dataSelect;
	private boolean isSelect = false;

	public AgendaDia() {
		iniciar();
		montarAgenda();
	}
	
	public AgendaDia(int width,int height) {
		this.width = width;
		this.hight = height;
		iniciar();
		montarAgenda();
	}

	
	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

	public LabelAgendaDia getDataSelect() {
		return dataSelect;
	}

	public void setDataSelect(LabelAgendaDia dataSelect) {
		this.dataSelect = dataSelect;
	}

	public int getSizeMes() {
		if(sizeMes <= 0){
			sizeMes = (int) ((int) (getWidth()/17.5))/2;
		}
		return sizeMes;
	}

	public void setSizeMes(int sizeMes) {
		this.sizeMes = sizeMes;
	}

	public int getSizeSemana() {
		if(sizeSemana <= 0){
			sizeSemana = (int) ((int) (getWidth()/35)/ 1.66);
		}
		return sizeSemana;
	}

	public void setSizeSemana(int sizeSemana) {
		this.sizeSemana = sizeSemana;
	}

	private Date getDataEscolida() {
		if(dataEscolida == null){
			dataEscolida = Calendar.getInstance().getTime();
		}
		return dataEscolida;
	}



	public void setDataEscolida(Date dataEscolida) {
		this.dataEscolida = dataEscolida;
	}



	private void iniciar(){		
		
		setBounds(0,0,width,hight);
		setLayout(null);
//		TITULO COM NOME DOS DIAS DA SEMANA, DIAS DO MÊS, BOTAO DE AVANÇAR E RECUAR
//		BOTAO DE AVANÇAR E RECUAR
		Image image = null,imagerol = null; 
					try {
						image = ImageIO.read(new File("E:/Area de Trabalho/PROJETOS_ECLIPSE/workspace/Agenda_2/src/icons/icon_avançar.png"));
						imagerol = ImageIO.read(new File("E:/Area de Trabalho/PROJETOS_ECLIPSE/workspace/Agenda_2/src/icons/icon_avançar_2.png"));
					} catch (MalformedURLException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
		JButton botaoAvancar = new JButton();
		botaoAvancar.setFocusable(false);
		botaoAvancar.setBounds((int) (getWidth()-( getWidth()/17.5)), 0, (int) (getWidth()/17.5), (int) (getWidth()/17.5));
		botaoAvancar.setIcon(new ImageIcon(image.getScaledInstance(botaoAvancar.getWidth(), botaoAvancar.getHeight(), Image.SCALE_DEFAULT)));
		botaoAvancar.setBackground(Color.white);
		botaoAvancar.setBorder(null);
		botaoAvancar.setRolloverIcon(new ImageIcon(imagerol.getScaledInstance(botaoAvancar.getWidth(), botaoAvancar.getHeight(), Image.SCALE_DEFAULT)));
		botaoAvancar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getDataEscolida().setMonth(getDataEscolida().getMonth()+1);
				setDataSelect(null);
				setSelect(false);
				montarAgenda();		
			}
		});
		botaoAvancar.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				JButton b = (JButton) arg0.getComponent();
				b.setBackground(new Color(130,180,255));
			}
			
		});
		botaoAvancar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				JButton b = (JButton) arg0.getComponent();
				b.setBackground(Color.white);
			}
		});
		add(botaoAvancar);
					try {
						image = ImageIO.read(new File("E:/Area de Trabalho/PROJETOS_ECLIPSE/workspace/Agenda_2/src/icons/icon_recuar.png"));
						imagerol = ImageIO.read(new File("E:/Area de Trabalho/PROJETOS_ECLIPSE/workspace/Agenda_2/src/icons/icon_recuar_2.png"));
					} catch (MalformedURLException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
		JButton botaoRecuo = new JButton();
		botaoRecuo.setFocusable(false);
		botaoRecuo.setBounds(0, 0, (int) (getWidth()/17.5), (int) (getWidth()/17.5));
		botaoRecuo.setIcon(new ImageIcon(image.getScaledInstance(botaoRecuo.getWidth(), botaoRecuo.getHeight(), Image.SCALE_DEFAULT)));
		botaoRecuo.setBackground(Color.white);
		botaoRecuo.setBorder(null);
		botaoRecuo.setRolloverIcon(new ImageIcon(imagerol.getScaledInstance(botaoRecuo.getWidth(), botaoRecuo.getHeight(), Image.SCALE_DEFAULT)));
		botaoRecuo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getDataEscolida().setMonth(getDataEscolida().getMonth()-1);
				setDataSelect(null);
				setSelect(false);
				montarAgenda();	
			}
		});
		botaoRecuo.addMouseMotionListener(new MouseAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				JButton b = (JButton) arg0.getComponent();
				b.setBackground(new Color(130,180,255));
			}
			
		});
		botaoRecuo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				JButton b = (JButton) arg0.getComponent();
				b.setBackground(Color.white);
			}
		});
		add(botaoRecuo);
		
//		TITULO NOME DO MÊS
			JLabel lbTituloMes = new JLabel();
			lbTituloMes.setBounds((int) (getWidth()/17.5), 0, (getWidth())-(((int) (getWidth()/17.5))*2), (int) (getWidth()/17.5));
			lbTituloMes.setFont(new Font(Font.SANS_SERIF,Font.BOLD,getSizeMes()));
			lbTituloMes.setHorizontalAlignment(JLabel.CENTER);
			lbTituloMes.setBackground(Color.white);
			lbTituloMes.setName("lbMes");
			lbTituloMes.setOpaque(true);
			add(lbTituloMes);
			
//			TITULO NOME DOS DIAS DA SEMANA
		for(int i = 0 ; i < 7 ; i++){
			JLabel lbTitulo = new JLabel();
			lbTitulo.setBounds(i*(getWidth()/7), (int) (getWidth()/17.5), (getWidth()/7), (int) (getWidth()/35));
			switch (i) {
			case 0:
				lbTitulo.setText("DOMINGO");
				break;
		case 1:
			lbTitulo.setText("SEGUNDA");
				break;
		case 2:
			lbTitulo.setText("TERÇA");
			break;
		case 3:
			lbTitulo.setText("QUARTA");
			break;
		case 4:
			lbTitulo.setText("QUINTA");
			break;
		case 5:
			lbTitulo.setText("SEXTA");
			break;
		case 6:
			lbTitulo.setText("SÁBADO");
			break;
			
			default:
				break;
			}
			lbTitulo.setHorizontalAlignment(JLabel.CENTER);
			lbTitulo.setBackground(new Color(176,196,222));
			lbTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD,getSizeSemana()));
			lbTitulo.setOpaque(true);
			add(lbTitulo);
		}

		for(int i = 0 ; i < 6 ; i++){
			for(int j = 0 ; j < 7 ; j++){
				LabelAgendaDia label = new LabelAgendaDia(Color.WHITE,this);
				label.setBounds(j*(getWidth()/7), (i*(getWidth()/7))+((int) (getWidth()/17.5) + (int) (getWidth()/35)), (getWidth()/7), (getWidth()/7));
				label.setName("lbAgenda"+i+j);
				label.setText("");
				add(label);
		
			}
		}
		
		
		
		}
	private void montarAgenda(){
//		IMPLEMENTAÇÃO DA AGENDA DOS DIA DA SEMANA
		Calendar c = Calendar.getInstance();
		c.setTime(getDataEscolida());
		c.set(Calendar.DAY_OF_MONTH, 1);
		int diaMes = c.get(Calendar.DAY_OF_MONTH);
		int diaSemana = c.get(Calendar.DAY_OF_WEEK);
		int mes = c.get(Calendar.MONTH);
		int ano = c.get(Calendar.YEAR);
		c.set(Calendar.DAY_OF_MONTH, (1+1)-c.get(Calendar.DAY_OF_WEEK));
//		BUSCA OS COMPONENTES DA JPANEL E TRANSFORMA EM ARRAY DE COMPONENTES
		Component[] comp = getComponents();
//		BUSCA OS LABELS NO PANEL PARA ADICIONAR OS DIAS
		for(int i = 0; i < comp.length; i++){
			if(comp[i] instanceof JLabel){
				JLabel label = (JLabel) comp[i];
				if(label.getName() != null)
				if(label.getName().equals("lbMes")){
					switch (mes) {
					
				case 0:
					label.setText("JANEIRO de "+ano);
						break;
				case 1:
					label.setText("FEVEREIRO de "+ano);
					break;
				case 2:
					label.setText("MARÇO de "+ano);
					break;
				case 3:
					label.setText("ABRIL de "+ano);
					break;
				case 4:
					label.setText("MAIO de "+ano);
					break;
				case 5:
					label.setText("JUNHO de "+ano);
					break;
				case 6:
					label.setText("JULHO de "+ano);
					break;
				case 7:
					label.setText("AGOSTO de "+ano);
					break;
				case 8:
					label.setText("SETEMBRO de "+ano);
					break;
				case 9:
					label.setText("OUTUBRO de "+ano);
					break;
				case 10:
					label.setText("NOVEMBRO de "+ano);
					break;
				case 11:
					label.setText("DEZEMBRO de "+ano);
					break;
					default:
						break;
					}
				}
			}
		}
		
//		BUSCA OS LABELS NO PANEL PARA ADICIONAR OS DIAS
		for(int i = 0; i < comp.length; i++){
			if(comp[i] instanceof LabelAgendaDia){
				LabelAgendaDia label = (LabelAgendaDia) comp[i];
				if(label.getName() != null)
				if(!label.getName().equals("lbMes")){
									label.setText("<html>"+c.get(Calendar.DAY_OF_MONTH)+"</html>");	
							Calendar cal = Calendar.getInstance();
							cal.set(Calendar.YEAR, c.get(Calendar.YEAR));
							cal.set(Calendar.MONTH, c.get(Calendar.MONTH));
							cal.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
							label.setCal(cal);
								if(c.get(Calendar.MONTH) != getDataEscolida().getMonth()){
									label.setBackground(new Color(192,192,192));
								}else
									
								if(getDataEscolida().getMonth() == Calendar.getInstance().get(Calendar.MONTH)
								&& Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH)){
									label.setBackGroundColor(new Color(255,182,193));
									label.setBackground(new Color(255,182,193));
									label.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192),1));
								}else{
									label.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192),1));
									label.setBackGroundColor(Color.white);
									label.setBackground(Color.white);
								}
								
								c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+1);
						}
					comp[i] = label;
					}
				}
		

	}
	

	public Date getDataSelecionada(){
		Date result = Calendar.getInstance().getTime();
				if(isSelect()){
					result = getDataSelect().getCal().getTime();
				}
			return result;
	}
	
	public void setValorAgenda(int dia, String texto){
		Calendar c = Calendar.getInstance();
		c.setTime(dataEscolida);
		if(dia > c.getActualMaximum(Calendar.DAY_OF_MONTH)){
			return;
		}
		Component comp[] = getComponents();
		for(int i = 0 ; i < comp.length ; i++){
				if(comp[i].getClass() == LabelAgendaDia.class){
				LabelAgendaDia label = (LabelAgendaDia) comp[i];
						int verificador=0,pos = 0;
							for(int v = 0; v < 2; v++){
								if("0123456789".contains(label.getText().subSequence(6+verificador,6+1+verificador))){
									pos = 6+1+verificador;
									verificador++;
								}
							}
							
									if(Integer.parseInt(label.getText().substring(6, pos).toString()) == dia && 
												label.getCal().get(Calendar.MONTH) == getDataEscolida().getMonth()){
							
												
										label.setText(label.getText().subSequence(0, pos)+" <br> "+texto+label.getText().subSequence(label.getText().length()-7, label.getText().length()));
									}
				
			}
		}
	}
	
	public void setValorAgendaSelecionada(String texto){
		if(isSelect()){
		Component comp[] = getComponents();
		for(int i = 0 ; i < comp.length ; i++){
				if(comp[i].getClass() == LabelAgendaDia.class){
				LabelAgendaDia label = (LabelAgendaDia) comp[i];
						int verificador=0,pos = 0;
							for(int v = 0; v < 2; v++){
								if("0123456789".contains(label.getText().subSequence(6+verificador,6+1+verificador))){
									pos = 6+1+verificador;
									verificador++;
								}
							}
									if(Integer.parseInt(label.getText().substring(6, pos).toString()) == getDataSelect().getCal().get(Calendar.DAY_OF_MONTH) && 
												label.getCal().get(Calendar.MONTH) == getDataEscolida().getMonth()){
							
												
										label.setText(label.getText().subSequence(0, pos)+" <br> "+texto+label.getText().subSequence(label.getText().length()-7, label.getText().length()));
									}
				
			}
		  }
		}
	}
	
	public void removeValorAgenda(int dia){
		Calendar c = Calendar.getInstance();
		c.setTime(dataEscolida);
		if(dia > c.getActualMaximum(Calendar.DAY_OF_MONTH)){
			return;
		}
		Component comp[] = getComponents();
		for(int i = 0 ; i < comp.length ; i++){
				if(comp[i].getClass() == LabelAgendaDia.class){
				LabelAgendaDia label = (LabelAgendaDia) comp[i];
						int verificador=0,pos = 0;
							for(int v = 0; v < 2; v++){
								if("0123456789".contains(label.getText().subSequence(6+verificador,6+1+verificador))){
									pos = 6+1+verificador;
									verificador++;
								}
							}
							
									if(Integer.parseInt(label.getText().substring(6, pos).toString()) == dia && 
												label.getCal().get(Calendar.MONTH) == getDataEscolida().getMonth()){
										
												
										label.setText(label.getText().subSequence(0, pos)+" <br> "+label.getText().subSequence(label.getText().length()-7, label.getText().length()));
									}
				
			}
		}
	}
	
	public void removeValorAgendaSelecionada(){
		if(isSelect()){
		Component comp[] = getComponents();
		for(int i = 0 ; i < comp.length ; i++){
				if(comp[i].getClass() == LabelAgendaDia.class){
				LabelAgendaDia label = (LabelAgendaDia) comp[i];
						int verificador=0,pos = 0;
							for(int v = 0; v < 2; v++){
								if("0123456789".contains(label.getText().subSequence(6+verificador,6+1+verificador))){
									pos = 6+1+verificador;
									verificador++;
								}
							}
							
									if(Integer.parseInt(label.getText().substring(6, pos).toString()) == getDataSelect().getCal().get(Calendar.DAY_OF_MONTH) && 
												label.getCal().get(Calendar.MONTH) == getDataEscolida().getMonth()){
										
												
										label.setText(label.getText().subSequence(0, pos)+" <br> "+label.getText().subSequence(label.getText().length()-7, label.getText().length()));
									}
				
			}
		  }
		}
	}
	
	public void controleDeSelecao(){
		for(Component comp:getComponents()){
			if(comp instanceof LabelAgendaDia){
				LabelAgendaDia label = (LabelAgendaDia) comp;
				if(!label.equals(getDataSelect())){
					label.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192),1));
				}else{
					label.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}
			}
		}
	}
	
	public void setSizeFontData(int size){
		setSizeMes(size);
	}
	
	public void setSizeFontSemana(int size){
		setSizeSemana(size);
	}

	public void cleanAgenda(){
		montarAgenda();
	}
}
