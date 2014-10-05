class Program22 {
    public static void main(String[] args) {
        CashAccount account1 = new CashAccount("Vincent");
        int s1 = 1200, s2 = 100;
        account1.addMoney(s1);
        CashAccount account2 = new CashAccount("Michael");
        if(account1.moreOrNot(s2)) {
            account2.addMoney(account1.getSomeMoney(s2));
        }
        CashAccount account3 = new CashAccount(account2);
        account1.addMoney(account3.getSomeMoney(account3.getBalance()/2));
    }
}
