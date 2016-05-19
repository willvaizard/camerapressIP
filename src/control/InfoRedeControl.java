package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.InfoRedeEntity;
import infraestrutura.InfoRedeDao;

public class InfoRedeControl implements TableModel {
List<InfoRedeEntity> lista = new ArrayList<InfoRedeEntity>();

	public  InfoRedeControl() {
		InfoRedeDao iDao;
		
		try {
			iDao = new InfoRedeDao();
			List<InfoRedeEntity> list = iDao.consultaTodos();
			for(InfoRedeEntity i : list)
			{
				lista.add(i);
			}
			
				
		} catch (ClassNotFoundException e) {
			
						
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: return int.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return String.class;
		case 4: return String.class;
		}
			
			
			

		
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	
	public void setLista(List<InfoRedeEntity> lista) {
		this.lista = lista;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String nomeColunas[] = {"ID", "Nome", "Nome Computador", "IP", "Setor"};
		return nomeColunas[columnIndex];
	}



	@Override
	public int getRowCount() {
		
		return lista.size();
	}
	public List<InfoRedeEntity> getLista() {
		return lista;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		InfoRedeEntity info = lista.get(rowIndex);
		switch (columnIndex) {
			case 0: return info.getId(); 
			case 1: return info.getNomeUser();
			case 2: return info.getNomeComputador();
			case 3: return info.getIp();
			case 4: return info.getSetor();
			
			}
		
		return info;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public void insereDados(InfoRedeEntity info){
		
		try {
			InfoRedeDao iDao = new InfoRedeDao();
			iDao.insert(info);
			JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso", "Sucesso!!!", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	

}
