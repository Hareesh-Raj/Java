package Exercise9.dao;

import java.util.Collection;

import Exercise9.dto.ItemMasterDTO;

abstract public class ItemMasterDAO {
	public abstract ItemMasterDTO findByID(int id);
	public abstract ItemMasterDTO findByName(String uname);
	public abstract Collection<ItemMasterDTO> findAll();
	abstract public int update(ItemMasterDTO dto);
	abstract public int deleteItem(ItemMasterDTO dto);
}