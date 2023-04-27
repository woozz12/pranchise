package com.pranchiseeeee.shop.service;

import com.pranchiseeeee.common.AppService;
import com.pranchiseeeee.shop.*;
import com.pranchiseeeee.shop.domain.Shop;
import com.pranchiseeeee.shop.repository.ShopRepository;
import com.pranchiseeeee.shop.service.*;
import com.pranchiseeeee.view.AppUI;
import static com.pranchiseeeee.view.AppUI.inputInteger;
import static com.pranchiseeeee.view.AppUI.inputString;

import java.util.List;

public class ShopService implements AppService{

	
private final ShopRepository shopRepository = new ShopRepository();
	
	public void start() {

		while(true) {

			AppUI.shopManagementScreen();
			int selection = inputInteger();

			switch (selection) {
			case 1:
				join();
				break;
			case 2:
//				showSearchResult();
				break;
			case 3:
//				deleteUser();
				break;
			case 4:

				return; //메인 화면으로 돌아가기

			default:
				System.out.println("메뉴를 다시 입력하세요.");
			}
			System.out.println("\n====== 계속 진행하시려면 ENTER 를 누르세요 ======");
			inputString();
		}

	}

	//회원 추가 비즈니스 로직
	private void join() {
		
		System.out.println("\n====== 회원 가입을 진행합니다. ======");
		System.out.print("# 점주명: ");
		String ownerName = inputString();
		
		System.out.print("# 매장 전화번호: ");
		String shopNum = inputString();
		
		System.out.print("# 점주 전화번호: ");
		String ownerNum = inputString();
		
		System.out.print("# 매장 주소: ");
		String shopAddress = inputString();
		
		System.out.print("# 매장 오픈일: ");
		String shopOpenDate = inputString();
		
		Shop shop = new Shop(0, ownerName, shopNum, ownerNum, shopAddress, shopOpenDate);
		shop.setOwnerName(ownerName);
		shop.setShopNumber(shopNum);
		shop.setOwnerNumber(ownerNum);
		shop.setShopAddress(shopAddress);
		shop.setShopOpenDate(shopOpenDate);
		
		
		
		shopRepository.addShop(shop);
		
	}

}
