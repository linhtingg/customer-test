package com.samsung;

import lombok.Builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WithDrawMoney {
    //public static class
    @Builder
    public static class Accounts
    {
        public String accCode;
        public String accName;
        public long accAmount;
    }

    List<Accounts> lstAccount;
    public WithDrawMoney()
    {
        this.lstAccount = new ArrayList<>();

        this.lstAccount.add(Accounts.builder().accCode("HYN").accName("Account 1").accAmount(1000000l).build());
    }
    public String getGeneratedDate(String withDrawCode)
    {
        return withDrawCode.substring(3,9);
    }

    public String getTodayDateInString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String todayDate = dateFormat.format(new Date());
        return todayDate;
    }
    public String withDraw(String withDrawCode, long money)
    {
        if(withDrawCode.length()!=9)
            throw new IllegalArgumentException("WithDraw Code is invalid");

        String strGeneratedDate = getGeneratedDate(withDrawCode);
        String todayDate = getTodayDateInString();

        if(!strGeneratedDate.equals(todayDate))
        {
            throw new IllegalArgumentException("WithDraw Code is invalid");
        }

        List<Accounts> filterAccount = lstAccount.stream().filter((acc)->acc.accCode.equals(withDrawCode.substring(0,3))).collect(Collectors.toList());
        if(filterAccount.size()==0)
        {
            throw new IllegalArgumentException("Account Code does not exist");
        }
        else
        {
            Accounts acc = filterAccount.get(0);
            if(acc.accAmount>=money) {
                acc.accAmount -= money;
                return "Giao dịch thành công";
            }
            else
            {
                return "Giao dịch không thành công";
            }
        }
    }
}
