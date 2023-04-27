package com.pranchiseeeee.shop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pranchiseeeee.common.DataBaseConnection;
import com.pranchiseeeee.shop.domain.Shop;

public class ShopRepository {

	DataBaseConnection connection =
			DataBaseConnection.getInstance();
	
	
	public void addShop(Shop shop) {
		
		System.out.println("repository: " + shop);
		String sql = "INSERT INTO shop "
				+ "(shop_id, owner_name, shop_number, owner_number, shop_address, shop_open_date) "
				+ "VALUES(shop_seq.NEXTVAL,?,?,?,?,?)";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, shop.getOwnerName());
			pstmt.setString(2, shop.getShopNumber());
			pstmt.setString(3, shop.getOwnerNumber());
			pstmt.setString(4, shop.getShopAddress());
			pstmt.setString(5, shop.getShopOpenDate());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("매장 추가가 정상 처리되었습니다.");
			} else {
				System.out.println("매장 추가에 실패했습니다. 관리자에게 문의하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	//매장 이름으로 정보 검색
//	public List<Shop> findByUserName(String userName) {
//		List<Shop> userList = new ArrayList<>();
//		String sql = "SELECT * FROM users WHERE user_name = ?";
//		
//		try(Connection conn = connection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, userName);
//			ResultSet rs = pstmt.executeQuery();	
//			
//			while(rs.next()) {
//				Grade grade = Grade.valueOf(rs.getString("grade"));
//				User user = new User(
//							rs.getInt("user_number"),
//							rs.getString("user_name"),
//							rs.getString("phone_number"),
//							rs.getInt("total_paying"),
//							grade
//						);
//				userList.add(user);
//			}
//			
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//		return userList;
//	}
//	
//  //매장 번호로 삭제	
//	public void deleteUser(int delUserNum) {
//		String sql = "DELETE FROM users WHERE user_number=?";
//		try(Connection conn = connection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setInt(1, delUserNum);
//			if(pstmt.executeUpdate() == 1) {
//				System.out.println("\n### 회원정보가 정상 삭제되었습니다.");
//			} else {
//				System.out.println("\n### 검색한 회원의 회원번호으로만 삭제가 가능합니다.");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
}
