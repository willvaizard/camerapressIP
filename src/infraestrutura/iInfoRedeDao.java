package infraestrutura;

import java.sql.SQLException;
import java.util.List;

import entity.InfoRedeEntity;

public interface iInfoRedeDao {
	
	public void insert(InfoRedeEntity info)throws SQLException ;
	public List<InfoRedeEntity> consultaIP(InfoRedeEntity info) throws SQLException;
	public List<InfoRedeEntity> consultaTodos() throws SQLException;
	public void update(InfoRedeEntity info)throws SQLException ;
	public void delete(InfoRedeEntity info)throws SQLException;

}
