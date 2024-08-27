package Mock;

import lombok.Builder;
public class AccountRepository {

    public Account getAccountByNumber(String Number)
    {
        //Get account from database by Number
        throw new RuntimeException("Not implement");
    }

    public Boolean updateAccount(Account acc)
    {
        //Update account to database
        throw new RuntimeException("Not implement");
    }
}
