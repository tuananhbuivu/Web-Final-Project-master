package com.newspaper.app.models;

import com.newspaper.app.beans.Articles;
import com.newspaper.app.utils.DbUtils;
/*
import org.sql2o.Connection;
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticlesModel {
	public static List<Articles> findAll() throws SQLException, ClassNotFoundException {
		List<Articles> list = new ArrayList<>();
		try (Connection con = DbUtils.initializeDatabase()) {
			String query = "select * from articles";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Articles(rs.getInt("id"), rs.getString("title"), (rs.getTimestamp("publish_date")), rs.getInt("views"),
						rs.getString("abstract"), rs.getString("content"),rs.getString("picture_main"), rs.getInt("preminum"), rs.getInt("status"),
						rs.getInt("categories_id"), rs.getInt("writer_id")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Articles> findbyStatus(int status) {
		List<Articles> list = new ArrayList<>();
		try (Connection con = DbUtils.initializeDatabase()) {
			String query = "select * from articles where status = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, status);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Articles(rs.getInt("id"), rs.getString("title"), (rs.getTimestamp("publish_date")), rs.getInt("views"),
						rs.getString("abstract"), rs.getString("content"),rs.getString("picture_main"), rs.getInt("preminum"), rs.getInt("status"),
						rs.getInt("categories_id"), rs.getInt("writer_id")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static Articles findbyID(int ID) {

		try (Connection con = DbUtils.initializeDatabase()) {
			String query = "select * from articles where id = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, ID);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return new Articles(rs.getInt("id"), rs.getString("title"), (rs.getTimestamp("publish_date")), rs.getInt("views"),
						rs.getString("abstract"), rs.getString("content"),rs.getString("picture_main"), rs.getInt("preminum"), rs.getInt("status"),
						rs.getInt("categories_id"), rs.getInt("writer_id"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public void save(Articles a) {
		try (Connection con = DbUtils.initializeDatabase()) {
			String query = "insert into articles"
					+ "(title,publish_date, views, abstract, content, categories_id, picture_main, preminum, writer_id, status) "
					+ "values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, a.getTittle());
			pre.setTimestamp(2, a.getPublish_date());
			pre.setInt(3, a.getViews());
			pre.setString(4, a.getAbstracts());
			pre.setString(5, a.getContent());
			pre.setInt(6, a.getCategories_id());
			pre.setString(7, a.getPicture_main());
			pre.setInt(8, a.getPreminum());
			pre.setInt(9, a.getWriter_id());
			pre.setInt(10, a.getStatus());
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Articles a) {
		try (Connection con = DbUtils.initializeDatabase()) {
			String query = "update articles set "
					+ "title=?,publish_date=?, views=?, abstract=?, content=?, categories_id=?, picture_main=?, preminum=?, writer_id=?, status=? where id = ? ";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, a.getTittle());
			pre.setTimestamp(2, a.getPublish_date());
			pre.setInt(3, a.getViews());
			pre.setString(4, a.getAbstracts());
			pre.setString(5, a.getContent());
			pre.setInt(6, a.getCategories_id());
			pre.setString(7, a.getPicture_main());
			pre.setInt(8, a.getPreminum());
			pre.setInt(9, a.getWriter_id());
			pre.setInt(10, a.getStatus());
			pre.setInt(11, a.getId());
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
