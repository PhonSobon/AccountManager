import java.util.*;
public class Main {
    public static void main(String[] args) {

        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("===================================================");
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account infor");
            System.out.println("5. Exit ");
            System.out.println("===================================================");
            System.out.println("Choose option ( 1 - 5 ) : ");
            option  = input.nextInt();

            switch (option){
                case  1 :
                    System.out.println("Enter your account infor");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = input.nextInt();
                    System.out.print("Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Balance:");
                    acc.balance = input.nextDouble();
                    accountList.add(acc);
                    break;
                case 2 :
                    boolean idIsEdit = false;
                    System.out.println("==================== Edit Account =====================  ");
                    System.out.print("Enter your ID:");
                    int editId = input.nextInt();
                    accountList.removeIf(account -> account.getId()==account.id);
                    break;
                case 3 :
                    boolean idIsExist = false;
                    System.out.println("==================== Edit Account =====================  ");
                    System.out.println("Enter your ID:");
                    int editID = input.nextInt();
                    for (Account account : accountList){
                        if(account.id == editID){
                            idIsExist = true;
                            System.out.println("---------------Enter new Account-------------");
                            System.out.print("Input new account name : ");
                            input.nextLine();
                            account.ownerName = input.nextLine();
                            System.out.print("Input new Balance : ");
                            account.balance = input.nextDouble();
                            System.out.println("Account with ID : " + editID );
                        }
                    }if(!idIsExist) {
                    System.out.println("Wrong ID, Please input ID again.");
                }
                    break;
                case 4 :
                    int showOption ;
                    System.out.println("Show account nformation");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descendig order by balance ");

                    System.out.println("Choose show option : ");
                    showOption =  input.nextInt();
                    switch (showOption){
                        case 1:
                            Collections.sort(accountList,Comparator.comparing(account -> account.id));
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 2:
                            Collections.sort(accountList, Comparator.comparingInt(Account::getId).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 3:
                        case 4:
                            Collections.sort(accountList, Comparator.comparingDouble(Account::getBalance).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                    }
                    break;
                default:
                    System.out.println("Exit the program....!");
                    break;
            }
        }while(option  !=5);

    }
}