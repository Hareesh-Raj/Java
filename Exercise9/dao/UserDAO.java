package Exercise9.dao;

import java.util.Collection;

import Exercise9.dto.UserDTO;

public abstract class UserDAO {
	public abstract UserDTO findByID(int uid);
	public abstract UserDTO findByName(String uname);
	public abstract Collection<UserDTO> findAll();
	public abstract int updateUser(UserDTO userdto);
	public abstract int deleteUserByID(int uid);
	public abstract int deleteUserByName(String uname);
	
}

