package Mock;

public class AccountManager {
    AccountRepository accRepository;
    public AccountManager(AccountRepository accRepository)
    {
        this.accRepository = accRepository;
    }

    public String withDraw(String account, long money)
    {
        Account acc = accRepository.getAccountByNumber(account);
        if(acc==null)
        {
            return "Tài khoản không tồn tại.";
        }
        else
        {
            if(acc.Money< money)
            {
                return "Số dư không đủ để giao dịch.";
            }
            else
            {
                acc.Money -= money;
                boolean saveResult = accRepository.updateAccount(acc);
                if(saveResult) return "Giao dịch thành công.";
                return "Giao dịch thất bại";
            }

        }
    }
}
