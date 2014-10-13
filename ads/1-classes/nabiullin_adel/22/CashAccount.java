public class CashAccount {
    // количество открытых счетов(по совместительству номер последнего)
    static int count = 0;
    private int accountId;
    private String ownerName;
    private int cashBalance;
    // конструктор с заданием имени владельца счета
    CashAccount(String name) {
        count++;
        this.cashBalance = 0;
        this.ownerName = name;
        this.accountId = count;
    }
    // положить(добавить) деньги на счет
    public void addMoney(int howMuch) {
        this.cashBalance += howMuch;
    }
    // снять часть денег со счета
    public int getSomeMoney(int howMuch) {
        this.cashBalance -= howMuch;
        return howMuch;
    }
    // получить остаток счета(узнать сколько осталось)
    public int getBalance() {
        return this.cashBalance;
    }
    // узнать, больше(>=) ли денег на счете, чем заданное кол-во
    public boolean moreOrNot(int ourSum) {
        return this.cashBalance >= ourSum;
    }
    // открыть владельцу новый счет с переносом всего остатка со старого счета
    CashAccount(CashAccount oldAccount) {
        count++;
        this.cashBalance = oldAccount.getSomeMoney(oldAccount.getBalance());
        this.ownerName = oldAccount.ownerName;
        this.accountId = count;
    }
}
