package infraestrutura;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


import entity.InfoRede;

public class InfoRedeDao implements iInfoRedeDao{
	private Connection Con;
	
	public  InfoRedeDao()throws ClassNotFoundException, SQLException {
	GenericDao gDao = new GenericDao();
	Con = gDao.getConnection();

	}

	@Override
	public void insert(InfoRede info) throws SQLException {
		String sql = "INSERT INTO IPUSER(ip, nomeComputador, nomeUser, Setor)"
				+ " values (?,?,?,?";
		PreparedStatement ps = Con.prepareStatement(sql);
		
		
		ps.execute();
		
	}


	
}
