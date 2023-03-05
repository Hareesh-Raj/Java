package Exercise9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Exercise9.DBUtility;
import Exercise9.dto.ItemMasterDTO;

public class ItemMasterDAOImpl extends ItemMasterDAO implements Cloneable{
	
	private ItemMasterDAOImpl()
	{
		
	}
	private static ItemMasterDAOImpl itemmasterdao;
	public static ItemMasterDAOImpl getUserDAOImplObject() {
		if(itemmasterdao==null) {
			itemmasterdao=new ItemMasterDAOImpl();
			return itemmasterdao;
		}
		else {
			return itemmasterdao.createClone();
		}
	}
	private ItemMasterDAOImpl createClone() {
		if(itemmasterdao!=null) {
			try{
				return ( ItemMasterDAOImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	public ItemMasterDTO findByID(int id) {
		try {
		Connection con=DBUtility.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from itemmaster where itemno=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			ItemMasterDTO itemdto=new ItemMasterDTO();
			itemdto.setItemname(rs.getString("itemname"));
			itemdto.setItemprice(rs.getInt("itemprice"));
			itemdto.setUnit(rs.getString("itemunit"));
			itemdto.setItemno(id);
			return itemdto;
		}
		else {
			return null;
		}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public Collection<ItemMasterDTO> findAll(){
		try {
			Connection con=DBUtility.getConnection();
			Statement ps=con.createStatement();
			
			ResultSet rs=ps.executeQuery("select * from itemmaster");
			List<ItemMasterDTO> items=new ArrayList<ItemMasterDTO>();
			while(rs.next()) {
				ItemMasterDTO dto=new ItemMasterDTO();
				dto.setItemno(rs.getInt("itemno"));
				dto.setItemname(rs.getString("itemname"));
				dto.setItemprice(rs.getInt("itemprice"));
				dto.setUnit(rs.getString("itemunit"));				
				items.add(dto);
			}
			return items;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public int update(ItemMasterDTO dto) {
		try {
			Connection con=DBUtility.getConnection();
			int ino=dto.getItemno();
			PreparedStatement ps=con.prepareStatement("select * from itemmaster where itemno=?");
			ps.setInt(1, ino);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update itemmaster set itemname=?,itemprice=?,itemunit=? where itemno=?");
				ps.setString(1, dto.getItemname());
				ps.setInt(2, dto.getItemprice());
				ps.setString(3, dto.getUnit());
				int n=ps.executeUpdate();
				DBUtility.closeConnection(null);
				return n;
			}
			else {
				return 0;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	public int deleteItem(ItemMasterDTO dto) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from itemmaster where itemno=?");
			ps.setInt(1, dto.getItemno());
			int n=ps.executeUpdate();
			return n;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	
	@Override
	public ItemMasterDTO findByName(String uname) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from itemmaster where itemname=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ItemMasterDTO dto=new ItemMasterDTO();
				dto.setItemname(rs.getString("itemname"));
				dto.setItemno(rs.getInt("itemno"));
				dto.setItemprice(rs.getInt("itemprice"));
				dto.setUnit(rs.getString("itemunit"));
				return dto;
			}
			else {
				return null;
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
}
