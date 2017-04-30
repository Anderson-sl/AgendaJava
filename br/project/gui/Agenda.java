package br.project.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.project.bo.AgendaDia;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JLabel;

import java.awt.Font;

public class Agenda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AgendaDia agendaDia;
	private JTextField tfData;
	private JTextField txtAnotacao;
	private JButton btnAdd;
	private JButton btnLimpar;
	private JButton btnRemoveSelecao;
	private JLabel lblRemoveTextoDo;
	private JTextField txtAnotacao2;
	private JLabel lblAddTexto;
	private JFormattedTextField txtDia;
	private JLabel lblDia;
	private JButton btnAdd2;
	private JFormattedTextField txtDiaRemover;
	private JLabel lblNewLabel;
	private JButton btnRemover2;
	private JLabel lblAesPassandoDia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Agenda dialog = new Agenda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Agenda() {
		setBounds(100, 100, 957, 747);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 588, 582);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		agendaDia = new AgendaDia(panel.getWidth(),panel.getHeight());
		agendaDia.setBounds(0,0,588,582);
		panel.add(agendaDia);
		
		tfData = new JTextField();
		tfData.setBounds(662, 70, 168, 20);
		contentPanel.add(tfData);
		tfData.setColumns(10);
		
		JButton btnPegar = new JButton("Pegar");
		btnPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar c = Calendar.getInstance();
				
				c.setTime(agendaDia.getDataSelecionada());
				tfData.setText("Dia: "+c.get(Calendar.DAY_OF_MONTH)+"  Mes: "+c.get(Calendar.MONTH)+"  Ano: "+c.get(Calendar.YEAR));
				
			}
		});
		btnPegar.setBounds(861, 69, 70, 23);
		contentPanel.add(btnPegar);
		
		txtAnotacao = new JTextField();
		txtAnotacao.setBounds(662, 122, 168, 20);
		contentPanel.add(txtAnotacao);
		txtAnotacao.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(agendaDia.isSelect()){
				agendaDia.setValorAgendaSelecionada(txtAnotacao.getText());
				}
			}
		});
		btnAdd.setBounds(861, 121, 70, 23);
		contentPanel.add(btnAdd);
		
		btnLimpar = new JButton("Limpar toda agenda");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agendaDia.cleanAgenda();
			}
		});
		btnLimpar.setBounds(692, 570, 171, 23);
		contentPanel.add(btnLimpar);
		
		JLabel lblPegarDataSelecionada = new JLabel("Pegar Data Selecionada");
		lblPegarDataSelecionada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPegarDataSelecionada.setBounds(663, 54, 167, 14);
		contentPanel.add(lblPegarDataSelecionada);
		
		JLabel lblAddTextoPara = new JLabel("Add texto para dia selecionado");
		lblAddTextoPara.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddTextoPara.setBounds(662, 107, 201, 14);
		contentPanel.add(lblAddTextoPara);
		
		btnRemoveSelecao = new JButton("Remover");
		btnRemoveSelecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(agendaDia.isSelect()){
					agendaDia.removeValorAgendaSelecionada();
				}
			}
		});
		btnRemoveSelecao.setBounds(842, 172, 89, 23);
		contentPanel.add(btnRemoveSelecao);
		
		lblRemoveTextoDo = new JLabel("Remove texto do dia selecionado");
		lblRemoveTextoDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRemoveTextoDo.setBounds(635, 176, 189, 14);
		contentPanel.add(lblRemoveTextoDo);
		
		txtAnotacao2 = new JTextField();
		txtAnotacao2.setBounds(662, 354, 86, 20);
		contentPanel.add(txtAnotacao2);
		txtAnotacao2.setColumns(10);
		
		lblAddTexto = new JLabel("Add texto");
		lblAddTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddTexto.setBounds(662, 337, 86, 14);
		contentPanel.add(lblAddTexto);
		
		
		DecimalFormat num = null;
		num = new DecimalFormat("##");
		txtDia = new JFormattedTextField(num);
		txtDia.setBounds(784, 354, 42, 20);
		contentPanel.add(txtDia);
		txtDia.setColumns(10);
		
		lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDia.setBounds(784, 337, 46, 14);
		contentPanel.add(lblDia);
		
		btnAdd2 = new JButton("Add 2");
		btnAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtDia.getText().equals(""))
				agendaDia.setValorAgenda(Integer.parseInt(txtDia.getText().trim()), txtAnotacao2.getText());
			}
		});
		btnAdd2.setBounds(842, 353, 89, 23);
		contentPanel.add(btnAdd2);
		
		txtDiaRemover = new JFormattedTextField(num);
		txtDiaRemover.setBounds(784, 419, 42, 20);
		contentPanel.add(txtDiaRemover);
		txtDiaRemover.setColumns(10);
		
		lblNewLabel = new JLabel("Dia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(784, 405, 31, 14);
		contentPanel.add(lblNewLabel);
		
		btnRemover2 = new JButton("Remover");
		btnRemover2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtDiaRemover.getText().equals(""))
					agendaDia.removeValorAgenda(Integer.parseInt(txtDiaRemover.getText()));
			}
		});
		btnRemover2.setBounds(842, 416, 89, 23);
		contentPanel.add(btnRemover2);
		
		lblAesPassandoDia = new JLabel("A\u00E7\u00F5es passando dia como parametro!");
		lblAesPassandoDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAesPassandoDia.setBounds(674, 312, 227, 14);
		contentPanel.add(lblAesPassandoDia);
	}
}
