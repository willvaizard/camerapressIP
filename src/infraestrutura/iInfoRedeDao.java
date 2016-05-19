package infraestrutura;

import java.sql.SQLException;

import entity.InfoRede;

public interface iInfoRedeDao {
	
	public void insert(InfoRede info)throws SQLException ;

}
