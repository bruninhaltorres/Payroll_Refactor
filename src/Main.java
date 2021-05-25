package src;
import src.payment.*;
import src.employees.*;
import src.EmployeeMenu;
import src.strategy.*;

import java.util.Scanner;
import java.lang.String;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static int actions(Scanner input){
        System.out.println("Ações:");
        System.out.println("1 - Adicionar empregado"); 
        System.out.println("2 - Remoção empregado"); 
        System.out.println("3 - Lançar um cartão"); 
        System.out.println("4 - Lançar resultado venda");
        System.out.println("5 - Lançar taxa serviço"); 
        System.out.println("6 - Alterar detalhes"); 
        System.out.println("7 - Folha de pagamento para hoje");
        System.out.println("8 - Undo/redo");
        System.out.println("9 - Agendar pagamento");
        System.out.println("10 - Criar novas agendas");
        System.out.println("0 - Encerrar");
        int command = input.nextInt();
        return command;
    }

    public static int invalid(Scanner input) {
        System.out.println("Acão inválida! Tente novamente.");
        int command = actions(input);
        return command;
    }
    
    public static void main(String[] args) {
        System.out.println("Esse é o sistema para folha de pagamento.");    
        Scanner input = new Scanner(System.in);
        
        int command = actions(input);
        int commandOk = 0;

        ArrayList<Syndicate> listSyndicate = new ArrayList<Syndicate>();
        ArrayList<Employees> listEmployees = new ArrayList<Employees>(); 

        EmployeeMenu employeeMenu = new EmployeeMenu();
        Payment payment = new Payment();
        Employees employee = null;
        
        StrategyHourly strategyHourly = new StrategyHourly();
        StrategyCommisioned strategyCommisioned= new StrategyCommisioned();
        StrategyAssalaried strategyAssalaried = new StrategyAssalaried();

        while (command != 0){
            if (command == 1) {
                System.out.println("Adicionando empregado...");
                
                employee = employeeMenu.createEmployee(listEmployees, listSyndicate, payment, strategyHourly, strategyCommisioned, strategyAssalaried);
                System.out.println("Empregado adicionado com sucesso.");

            } else if (command == 2) {
                System.out.println("Qual o identificador do empregado que será removido?");
                int idRemove = input.nextInt();

                Employees employeeRemove = null;
                for(Employees employees : listEmployees){
                    if(employees.getId() == idRemove){
                        employeeRemove = employees;
                    }
                }
                listEmployees.remove(employeeRemove);

                Syndicate syndicateRemove = null;
                for(Syndicate syndicate : listSyndicate){
                    if(syndicate.getIdSyndicate() == idRemove){
                        syndicateRemove = syndicate;
                    }
                }
                listSyndicate.remove(syndicateRemove);

                employee.printEmployees(listEmployees);
                System.out.println("Empregado removido!"); 

            } else if (command == 3) { // adicionando cartão de ponto
                System.out.println("Qual seu numero de identificação?");
                int idTimeCard = input.nextInt();
                int isHourly = 0;
                for(Employees employees : listEmployees){
                    if(employees.getId() == idTimeCard){
                        //if(employees instanceof Hourly){
                        employees.addTimeCard();
                        isHourly = 1;
                        System.out.println("Cartão de ponto lançado!");
                        //}
                    }
                } if (isHourly == 0) {
                    System.out.println("Você não está cadastrado em Horistas.");
                }

            } else if (command == 4) { // cadastrando venda
                System.out.println("Qual seu numero de identificação?");
                int idVendedor = input.nextInt();
                int isCommisioned = 0;
                for(Employees employees : listEmployees){
                    if(employees.getId() == idVendedor){
                        //if(employees instanceof Commissioned){
                        employees.addSale();
                        isCommisioned = 1;
                        System.out.println("Venda cadastrada!");
                        //}
                    }
                } if (isCommisioned == 0) {
                    System.out.println("Você não está cadastrado em Comissionado.");
                }

            } else if (command == 5) {
                System.out.println("Qual seu número de identificação?");
                int idChange = input.nextInt();
                int isSyndicate = 0;
                for(Syndicate syndicate : listSyndicate){
                    if(syndicate.getIdSyndicate() == idChange){
                        System.out.println("Qual a taxa cobrada pelo serviço? (R$)");
                        double feeService = input.nextDouble();
                        syndicate.setFeeService(feeService);
                        isSyndicate = 1;
                        System.out.println("Taxa de serviço adicionada!");
                    }
                } if (isSyndicate == 0) {
                    System.out.println("Você não está cadastrado no Sindicato");
                }

            } else if (command == 6) {
                System.out.println("Qual seu número de identificação?");
                int idChange = input.nextInt();

                int registeOK = 0;
                for(Employees employees : listEmployees){
                    if(employees.getId() == idChange){
                        registeOK = 1;
                    }
                }
                if(registeOK == 0) {
                    System.out.println("Você ainda não tem um cadastro."); 
                } else {
                    System.out.println("O que você deseja alterar?");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Endereço");
                    System.out.println("3 - Tipo(Horista/Comissionado/Assalariado)");
                    System.out.println("4 - Método de pagamento");
                    System.out.println("5 - Informações relacionadas ao sindicato");
                    int change = input.nextInt();
                    
                    int valid = 1;

                    while (valid == 1){
                        valid = 0;
                        if (change == 1) {
                            for(Employees employees : listEmployees){
                                if(employees.getId() == idChange){
                                    System.out.println("Novo nome:");
                                    String newName = input.next();
                                    employees.setName(newName);
                                    System.out.println("MENSAGEM: Nome alterado.");
                                }
                            }

                        } else if (change == 2) {
                            for(Employees employees : listEmployees){
                                if(employees.getId() == idChange){
                                    System.out.println("Novo endereço:");
                                    String newAdress = input.next();
                                    employees.setName(newAdress);
                                    System.out.println("MENSAGEM: Endereço alterado.");
                                }
                            }

                        } else if(change == 3) {
                            for(Employees employees : listEmployees){
                                if(employees.getId() == idChange){
                                    System.out.println("Para qual tipo o empregado será alterado?\n1 - Horista\n2 - Comissionado\n3 - Assalariado");
                                    int newType = input.nextInt();
                                    Employees aux = employees;
                                    listEmployees.remove(employees);
                                    if(newType == 1){
                                        employees = new Hourly(aux.getName(), aux.getAdress(), aux.getId());
                                    } else if (newType == 2) {
                                        double valueComissioned;
                                        System.out.println("Valor da comissão:");
                                        valueComissioned = input.nextDouble();
                                        employees = new Commissioned(aux.getName(), aux.getAdress(), aux.getId(), valueComissioned);
                                    } else {
                                        double salary;
                                        System.out.println("Salário:");
                                        salary = input.nextDouble();
                                        employees = new Assalaried(aux.getName(), aux.getAdress(), aux.getId(), salary);
                                    }
                                    listEmployees.add(employees);
                                    System.out.println("MENSAGEM: Alteração feita.");
                                    break;
                                }
                            }
                        } else if (change == 4) {
                            for(Employees employees : listEmployees){
                                if(employees.getId() == idChange){
                                    payment.payment_method(employees);
                                    System.out.println("MENSAGEM: Alteração feita.");
                                }
                            }
                        } else if (change == 5) {
                            System.out.println("Mais sobre essa opção...");
                            System.out.println("1 - Você deseja entrar ou sair do sindicato\n2 - Mudar a sua identificação de usuario no sindicato\n3 - Alterar taxa sindical");
                            int changeS = input.nextInt();
                            if (changeS == 1) {
                                System.out.println("1 - Entrar.\n2 - Sair");
                                int inOut = input.nextInt();
                                int pertence = 0;
                                if (inOut == 1) { // quer entrar.
                                    for(Syndicate syndicate : listSyndicate){
                                        if(syndicate.getIdSyndicate() == idChange){
                                            System.out.println("Você já faz parte do Sindicato.");
                                            pertence = 1;
                                        }
                                    } if (pertence == 0) { // verifica se ainda não faz parte, mas já tem cadastro em empregados.
                                        for(Employees employees : listEmployees){
                                            if(employees.getId() == idChange){
                                                employeeMenu.isSyndicate(listSyndicate, employees);
                                                System.out.println("Empregado adicionado ao sindicato.");
                                            }
                                        }
                                    }
                                } else { // quer sair.
                                    for(Syndicate syndicate : listSyndicate){
                                        if(syndicate.getIdSyndicate() == idChange){
                                            listSyndicate.remove(syndicate);
                                            pertence = 1;
                                            System.out.println("Empregado removido do Sindicato.");
                                        }
                                    }
                                    if (pertence == 0) {
                                        System.out.println("Você ainda não faz parte do sindicato.");
                                    }
                                }
                            } if(changeS == 2) {
                                //2 - Mudar a sua identificação de usuario no sindicato
                                for(Syndicate syndicate : listSyndicate){
                                    if(syndicate.getIdSyndicate() == idChange){
                                        int idSyndicate = employeeMenu.generateIdSyndicate(listSyndicate); // gero novo Id
                                        syndicate.setIdSyndicate(idSyndicate);
                                        System.out.println("MENSAGEM: Alteração feita.");

                                    }
                                }
                            } if (changeS == 3) { // Alterar taxa sindical
                                System.out.println("Qual a nova taxa sindical?");
                                double newFeeSyndical = input.nextDouble();
                                for(Syndicate syndicate : listSyndicate){
                                    if(syndicate.getIdSyndicate() == idChange){
                                        syndicate.setFeeSyndicate(newFeeSyndical);
                                        System.out.println("MENSAGEM: Alteração feita.");

                                    }
                                }
                            }
                        } else {
                            valid = 1;
                            invalid(input);
                            change = input.nextInt();
                        }
                    }
                }
            } else if (command == 7) {
                
                boolean testing = true;
                strategyHourly.payroll(testing);
                strategyCommisioned.payroll(testing);
                strategyAssalaried.payroll(testing);
                
                System.out.println("Pagamentos efetuados com sucesso!");
                
            } else if (command == 8) {
                //
                System.out.println("Ação desfeita. (undo)");
                System.out.println("Ação refeita. (redo)");
            } else if (command == 9) {
                //
            } else if (command == 10) {
                //
            } else if (command == 0) {
                break;
            } else {
                command = invalid(input);
                commandOk = 1; // para marcar que o command já foi pego.
            }
            if (commandOk == 0){ // se ainda não foi pego o proximo, pegue!
                command = actions(input);
            }
            commandOk = 0;
        }
        input.close();
    }
}
