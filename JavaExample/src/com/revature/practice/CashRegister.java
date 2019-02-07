package com.revature.practice;

import java.util.Map;
import java.util.TreeMap;

public class CashRegister {
	
	private double availableCash;
	private Map<Double, Integer> cashMap;
	
	public CashRegister() {
		availableCash = 0;
		cashMap = new TreeMap<>();
	}
	
	public static void main(String[] args) {
		
		double[] cash = {25, 75, 25, 75, 25};
		CashRegister reg = new CashRegister();
		System.out.println(reg.enoughCash(cash));
		System.out.println(reg.getCashMap());
		
	}
	
	
	
	public Map<Double, Integer> getCashMap() {
		return cashMap;
	}

	public void setCashMap(Map<Double, Integer> cashMap) {
		this.cashMap = cashMap;
	}

	public String enoughCash(double[] cash) {
	
		
		for(int i = 0; i < cash.length; i++) {
			if(!haveChange(cash[i])) {
				return "No";
			}
		}
		return "yes";
	}
	
	private boolean haveChange(double cash) {
		final double TICKETPRICE = 25;
		
		double change = cash - TICKETPRICE;
		
		if (availableCash >= change) {
			if(cashMap.containsKey(cash)) {
				Integer number = cashMap.get(cash);
				cashMap.put(cash, ++number);
			} else {
				cashMap.put(cash, 1);
			}
			Integer numOfNote = cashMap.get(change);
			cashMap.replace(change, numOfNote, --numOfNote);
			availableCash += cash - change;
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(availableCash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cashMap == null) ? 0 : cashMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashRegister other = (CashRegister) obj;
		if (Double.doubleToLongBits(availableCash) != Double.doubleToLongBits(other.availableCash))
			return false;
		if (cashMap == null) {
			if (other.cashMap != null)
				return false;
		} else if (!cashMap.equals(other.cashMap))
			return false;
		return true;
	}
	
	

}
