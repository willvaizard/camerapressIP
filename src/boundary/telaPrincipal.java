package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;

import control.InfoRedeControl;
import entity.InfoRedeEntity;
import javafx.scene.layout.Border;

public class telaPrincipal implements ListSelectionListener, ActionListener {
	private JPanel panelPrincipal = new JPanel(new BorderLayout());
	private JScrollPane panTableUserIp;
	private JTable tabela;
	private InfoRedeControl control = new InfoRedeControl();
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JFormattedTextField txtIp;
	private JTextField txtNomeUser;
	private JTextField txtNomeComputer;
	private JTextField txtSetor;
	public telaPrincipal() {
		JFrame janela = new JFrame("Cadastro de Usuários e IPs");
		
		janela.setContentPane(panelPrincipal);
		janela.add(topo(), BorderLayout.NORTH);
		janela.add(CentroPrincipal(), BorderLayout.CENTER);
		
		janela.add(sul(), BorderLayout.SOUTH);
		janela.setVisible(true);
		janela.setSize(800,650);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
	public JComponent topo (){
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel();
		titulo.setText("Cadastro de IPs");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		panelTopo.add(titulo);
		
		return panelTopo;
	}
	
	public JComponent CentroPrincipal(){
		JPanel panelCentro = new JPanel(new GridLayout(1,1));
		panTableUserIp = new JScrollPane();
		
		tabela = new JTable(control);
		
		

		tabela.getColumnModel().getColumn(0).setPreferredWidth(15);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(95);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(110);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(135);
		
		
		
		
		
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0;i<5;i++)
			tabela.getColumnModel().getColumn(i).setCellRenderer(centro);
		
		
		panTableUserIp.getViewport().add(tabela);
		tabela.getSelectionModel().addListSelectionListener(this);
		panelCentro.add(panTableUserIp);
		
		
		
		
		return panelCentro;
	}
	
	
	public JComponent sul (){
		JPanel panelSul = new JPanel(new FlowLayout());
		
		panelSul.add(Campos(),BorderLayout.CENTER);
		panelSul.add(Botoes(), BorderLayout.PAGE_END);
		
		
		return panelSul;
		
		
	}
	
	
	public JComponent Botoes(){
		JPanel panelBotoes = new JPanel(new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnExcluir);
		
		
		
		return panelBotoes;
	}
	
	public JComponent Campos (){
		JPanel panelCampos = new JPanel(new GridLayout(2,5));
		panelCampos.add(new JLabel("IP: "));
		txtIp = new JFormattedTextField();
		try {
			MaskFormatter maskIp = new MaskFormatter("###.###.#.###");
			maskIp.install(txtIp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelCampos.add(txtIp);
		
		panelCampos.add(new JLabel("Nome do Usuário"));
		txtNomeUser = new JTextField();
		panelCampos.add(txtNomeUser);
		
		panelCampos.add(new JLabel("Nome do Computador"));
		txtNomeComputer = new JTextField();
		panelCampos.add(txtNomeComputer);
		
		panelCampos.add(new JLabel("Setor"));
		txtSetor = new JTextField();
		panelCampos.add(txtSetor);
		
		
		
		
		
	return panelCampos;	
	}
	
			
	
	public static void main(String[] args) {
		new telaPrincipal();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSalvar){
		InfoRedeEntity info = new InfoRedeEntity();
		info.setIp(txtIp.getText().trim());
		info.setNomeComputador(txtNomeComputer.getText());
		info.setNomeUser(txtNomeUser.getText());
		info.setSetor(txtSetor.getText());
		
		control.insereDados(info);
			
			
	}}

}
