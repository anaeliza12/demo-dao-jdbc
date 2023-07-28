package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private static Connection con = DB.getConnection();

	@Override
	public void insert(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement("INSERT INTO DEPARTMENT (ID, NAME)" + "VALUES (?, ? )",
					PreparedStatement.RETURN_GENERATED_KEYS);

			st.setInt(1, department.getId());
			st.setString(2, department.getName());

			rs = st.getGeneratedKeys();

			if (rs.next()) {

				int id = rs.getInt(1);
				department.setId(id);

			}

			int row = st.executeUpdate();
			if (row == 0) {
				throw new DbException("Error unexpected!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	@Override
	public void update(Department department) {

		PreparedStatement st = null;

		try {
			st = con.prepareStatement("UPDATE DEPARTMENT SET NAME = ?  WHERE ID =? ");

			st.setString(1, department.getName());
			st.setInt(2, department.getId());

			int row = st.executeUpdate();

			if (row == 0) {
				throw new DbException("Error unexpected!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);

			DB.closeConnection();
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("DELETE FROM DEPARTMENT WHERE ID =  ?  ");

			st.setInt(1, id);

			int row = st.executeUpdate();

			if (row == 0) {
				throw new DbException("Error unexpected!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM DEPARTMENT WHERE ID = ?  ");
			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				Department dep = instantiationDepartment(rs);
				return dep;
			} else
				throw new DbException("This Id or department doesn't exist!");

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

	}

	@Override
	public List<Department> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM DEPARTMENT ");

			rs = st.executeQuery();

			List<Department> list = new ArrayList<>();

			while (rs.next()) {
				Department dep = instantiationDepartment(rs);

				list.add(dep);
			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

	}



	private Department instantiationDepartment(ResultSet rs) throws SQLException {
		int id = rs.getInt("Id");
		String name = rs.getString("Name");

		Department dep = new Department(id, name);
		return dep;
	}

}
