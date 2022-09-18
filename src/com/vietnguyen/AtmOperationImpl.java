package com.vietnguyen;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{
    ATM atm = new ATM();
    Map<Double, String> miniStatement = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available balance is : " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                miniStatement.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash" + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance.");
            }
        }
        else {
            System.out.println("Please enter the amount in multiples of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        miniStatement.put(depositAmount, " Amount deposited");
        System.out.println(depositAmount + " Deposited Successfully!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double, String> m:miniStatement.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
}
