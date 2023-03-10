package Exercise9.dao;

import java.util.Collection;

import Exercise9.dto.CustomerDTO;


public abstract class CustomerDAO {
	public abstract CustomerDTO findByID(String cid);
	public abstract CustomerDTO findByName(String uname);
	public abstract Collection<CustomerDTO> findAll();
	public abstract CustomerDTO updateUser(CustomerDTO userdto);
	public abstract int deleteUserByID(String cid);
}
