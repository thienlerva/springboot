package com.revature.practice;

public class BuyingCar {
	
	private double saving;
	//private final double DEPRECIATION_RATE = 1.5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuyingCar buy = new BuyingCar();
		System.out.println(buy.monthsToBuy(8000, 1.5));
		System.out.println(buy);
	}
	
	public BuyingCar() {
		this.saving = 1000;
	}
	
	public int monthsToBuy(double carPrice, double depreciationRate) {
		int count = 0;
		double depreciatedCarPrice = carPrice;
		while(depreciatedCarPrice >= saving) {
			depreciatedCarPrice = depreciatedCarPrice - ( depreciatedCarPrice * depreciationRate / 100);
			count++;
			saving += 1000;
			if(count%2==0) { depreciationRate += 0.5; }
		}
		
		saving = saving - depreciatedCarPrice;
		return count;
	}

	@Override
	public String toString() {
		return "BuyingCar [saving=" + saving + "]";
	}
	
	

}
