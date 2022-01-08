package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					obj.setId(rs.getInt(1));
				}
				DB.closeResultSet(rs);
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Department obj) {
//		PreparedStatement st = null;
//		try {
//			st = conn.prepareStatement(
//					"UPDATE seller "
//					+ "SET Name = ? "
//					+ "WHERE Id = ?");
//			
//			st.setString(1, obj.getName());
//			st.setInt(2, obj.getId());
//			
//			st.executeUpdate();
//			
//		}catch (SQLException e) {
//			throw new DbException(e.getMessage());
//		}
//		finally {
//			DB.closeStatement(st);
//		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM department "
					+ "WHERE Id = ?");
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Department dep = new Department(rs.getInt(1), rs.getString(2));
				DB.closeResultSet(rs);
				return dep;
			}
			DB.closeResultSet(rs);
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
