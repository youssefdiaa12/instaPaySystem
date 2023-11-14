import Authentication.*;
import DataBase.BankAccount;
import DataBase.DbModel;
import DataBase.WalletAccount;
import Features.*;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Do you want to login or register?");
            System.out.println("1-Login");
            System.out.println("2-Register");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            UserAuthentication userAuthentication;
            UserAuth_Controller userAuth_Controller = new UserAuth_Controller();
            userAuthentication = userAuth_Controller.Descion(choice);
            String userName, password;
            User user = null;
            if (choice == 1) {
                System.out.println("Please enter your UserName");
                userName = input.next();
                System.out.println("Please enter your password");
                password = input.next();
                user = new LoginUser(userName, password);
                userAuthentication.setUser(user);
                if (!userAuthentication.Perform_Authentication()) {
                    System.out.println("Login Failed");
                    user = null;
                }

            } else if (choice == 2) {
                System.out.println("register with");
                System.out.println("1-wallet account");
                System.out.println("2-bank account");
                int type = input.nextInt();
                String accountNumber = null, BankName = null;
                while (type != 1 && type != 2) {
                    System.out.println("Please enter a valid choice");
                    type = input.nextInt();
                }
                if (type == 2) {
                    System.out.println("Please enter your bank account number");
                    accountNumber = input.next();
                    System.out.println("Please enter your bank name");
                    BankName = input.next();
                }

                UserAccountController userAccountController = new UserAccountController();
                System.out.println("Please enter your UserName");
                userName = input.next();
                System.out.println("Please enter your password");
                password = input.next();
                System.out.println("Please enter your phone number");
                String phoneNumber = input.next();
                System.out.println("Please enter your email");
                String email = input.next();
                user = new RegisterUser(phoneNumber, email, userName, password);
                user.userAcc = userAccountController.accCreator(type, phoneNumber, email, userName, password);
                userAuthentication.setUser(user);
                if (userAuthentication.Perform_Authentication()) {
                    user.userAcc.setBalance(100);
                    if (type == 2) {
                        ((BankAccount) user.userAcc).setBankId(accountNumber);
                        ((BankAccount) user.userAcc).setBankName(BankName);
                    } else {
                        ((WalletAccount) user.userAcc).setPhoneNumber(phoneNumber);
                    }

                }
                // User is successfully registered
                else {
                    user = null;
                }
            } else {
                System.out.println("Please enter a valid choice");
            }

            if (user != null) {
                System.out.println("Welcome " + user.userAcc.userName);
                userAuthentication.verification.dbModel = DbModel.getInstance();
                DbModel.addLoggedInUser(user);
                DbModel.addAccount(user.userAcc);
                if (user.userAcc instanceof BankAccount) {
                    System.out.println("Your account number is " + ((BankAccount) user.userAcc).getBankId());
                    System.out.println("Your bank name is " + ((BankAccount) user.userAcc).getBankName());
                }
                while (true) {

                    if (user.userAcc instanceof BankAccount) {
                        System.out.println("1-Transferring");
                        System.out.println("2-Billing");
                        System.out.println("3- about my balance");
                        System.out.println("4-Exit");
                        int choice2 = input.nextInt();
                        while (choice2 != 1 && choice2 != 2 && choice2 != 3&& choice2 != 4) {
                            System.out.println("Please enter a valid choice");
                            choice2 = input.nextInt();
                        }
                        if(choice2==3){
                            System.out.println("Your balance is "+user.userAcc.getBalance());

                        }
                       else if (choice2 == 4) {
                            break;
                        } else if (choice2 == 1) {
                            System.out.println("1-Transfer to InstaPay wallet account");
                            System.out.println("2-Transfer to bank account");
                            System.out.println("3-Transfer to another wallet account");
                            System.out.println("4-about my balance");
                            System.out.println("5-Exit");
                            int transferChoice = input.nextInt();
                            while (transferChoice != 1 && transferChoice != 2 && transferChoice != 3 && transferChoice != 4 && transferChoice != 5) {
                                System.out.println("Please enter a valid choice");
                                transferChoice = input.nextInt();
                            }
                            if (transferChoice == 5) {
                                break;
                            }

                            if (transferChoice == 4) {
                                System.out.println("Your balance is " + user.userAcc.getBalance());
                                continue;
                            }

                            Transfer transfer = new Transfer(new BankAccountTransfer(user, userAuthentication.verification.dbModel));
                            ;
                            TransferStratgy obj = transfer.getTransferStratgy();
                            System.out.println("Please enter the amount to be transferred");
                            double amount = input.nextDouble();
                            if (transferChoice == 1) {
                                obj.transferToInstaPayWallet(amount);
                            } else if (transferChoice == 2) {
                                obj.transferToAnotherWallet(amount);
                            } else {
                                ((BankAccountTransfer) obj).TransferToBankAccount(amount);
                            }
                        } else {
                            System.out.println("1-Electricity Bill");
                            System.out.println("2-Gas Bill");
                            System.out.println("3-Water Bill");
                            System.out.println("4-about my balance");
                            System.out.println("5-Exit");
                            int billChoice = input.nextInt();
                            while (billChoice != 1 && billChoice != 2 && billChoice != 3 && billChoice != 4&& billChoice != 5) {
                                System.out.println("Please enter a valid choice");
                                billChoice = input.nextInt();
                            }
                            if(billChoice==4){
                                System.out.println("Your balance is " + user.userAcc.getBalance());

                            }
                            else if (billChoice == 5) {
                                break;
                            } else if (billChoice == 1) {
                                Bill electricityBilling = new ElectricityBilling();
                                BillingSystem billingSystem = new BillingSystem(user, electricityBilling);
                                billingSystem.payBill(50);
                            } else if (billChoice == 2) {
                                Bill gasBilling = new GasBilling();
                                BillingSystem billingSystem = new BillingSystem(user, gasBilling);
                                billingSystem.payBill(50);
                            } else {
                                Bill waterBilling = new WaterBilling();
                                BillingSystem billingSystem = new BillingSystem(user, waterBilling);
                                billingSystem.payBill(50);
                            }
                        }
                    } else {
                        System.out.println("1-Transferring");
                        System.out.println("2-Billing");
                        System.out.println("3- about my balance");
                        System.out.println("4-Exit");
                        int choice2 = input.nextInt();
                        while (choice2 != 1 && choice2 != 2 && choice2 != 3 && choice2 != 4) {
                            System.out.println("Please enter a valid choice");
                            choice2 = input.nextInt();
                        }
                        if(choice2==3){
                            System.out.println("Your balance is "+user.userAcc.getBalance());
                        }
                        else if (choice2 == 4) {
                            break;
                        }
                       else if (choice2 == 2) {
                            System.out.println("1-Electricity Bill");
                            System.out.println("2-Gas Bill");
                            System.out.println("3-Water Bill");
                            System.out.println("4-about my balance");
                            System.out.println("5-Exit");
                            int billChoice = input.nextInt();
                            while (billChoice != 1 && billChoice != 2 && billChoice != 3 && billChoice != 4 && billChoice != 5) {
                                System.out.println("Please enter a valid choice");
                                billChoice = input.nextInt();
                            }
                            if (billChoice == 4) {
                                System.out.println("Your balance is " + user.userAcc.getBalance());
                                continue;
                            }
                            if (billChoice == 5) {
                                break;
                            }
                            else if(billChoice==3){
                                Bill waterBilling = new WaterBilling();
                                BillingSystem billingSystem = new BillingSystem(user, waterBilling);
                                billingSystem.payBill(50);
                            }
                            else if (billChoice == 1) {
                                Bill electricityBilling = new ElectricityBilling();
                                BillingSystem billingSystem = new BillingSystem(user, electricityBilling);
                                billingSystem.payBill(50);
                            }
                            else {
                                Bill gasBilling = new GasBilling();
                                BillingSystem billingSystem = new BillingSystem(user, gasBilling);
                                billingSystem.payBill(50);
                            }
                        }
                       else {
                            System.out.println("1-Transfer to InstaPay wallet account");
                            System.out.println("2-Transfer to another wallet account");
                            System.out.println("3-about my balance");
                            System.out.println("4-Exit");
                            int transferChoice = input.nextInt();
                            while (transferChoice != 1 && transferChoice != 2 && transferChoice != 3 && transferChoice != 4) {
                                System.out.println("Please enter a valid choice");
                                transferChoice = input.nextInt();
                            }
                            if (transferChoice == 3) {
                                System.out.println("Your balance is " + user.userAcc.getBalance());
                                continue;
                            }
                            if (transferChoice == 4) {
                                break;
                            }
                            Transfer transfer = new Transfer(new WalletAccountTransfer(user, userAuthentication.verification.dbModel));
                            TransferStratgy obj = transfer.getTransferStratgy();
                            System.out.println("Please enter the amount to be transferred");
                            double amount = input.nextDouble();
                            if (transferChoice == 1) {
                                obj.transferToInstaPayWallet(amount);
                            } else {
                                obj.transferToAnotherWallet(amount);
                            }
                        }
                    }
                }

            }

        }
    }
}