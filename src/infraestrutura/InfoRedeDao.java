package infraestrutura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


import entity.InfoRedeEntity;

public class InfoRedeDao implements iInfoRedeDao{
	private Connection Con;
	
	public  InfoRedeDao()throws ClassNotFoundException, SQLException {
	GenericDao gDao = new GenericDao();
	Con = gDao.getConnection();

	}

	@Override
	public void insert(InfoRedeEntity info) throws SQLException {
		String sql = "INSERT INTO IPUSER values (?,?,?,?)";
		PreparedStatement ps = Con.prepareStatement(sql);
		ps.setString(1, info.getIp());
		ps.setString(2, info.getNomeComputador());
		ps.setString(3, info.getNomeUser());
		ps.setString(4, info.getSetor());
		ps.execute();
		ps.close();
		
	}


	@Override
	public List<InfoRedeEntity> consultaIP(InfoRedeEntity info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoRedeEntity> consultaTodos() throws SQLException {
		List<InfoRedeEntity> lista = new ArrayList<InfoRedeEntity>();
		
		String sql = "SELECT id, ip, nomeComputador, nomeUser, setor from IPUSER";
		PreparedStatement ps = Con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			InfoRedeEntity info = new InfoRedeEntity();
			info.setId(rs.getInt("id"));
			info.setIp(rs.getString("ip"));
			info.setNomeComputador(rs.getString("nomeComputador"));
			info.setNomeUser(rs.getString("nomeUser"));
			info.setSetor(rs.getString("setor"));
			lista.add(info);
			
		}
		 ps.close();
		 rs.close();
		
		return lista;
	}

	@Override
	public void update(InfoRedeEntity info) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InfoRedeEntity info) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	
}
