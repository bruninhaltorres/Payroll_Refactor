# Payroll_Refactor

## Objetivo:
O objetivo do projeto é construir um sistema de **folha de pagamento**. O sistema consiste do
gerenciamento de pagamentos dos empregados de uma empresa. Além disso, o sistema deve
gerenciar os dados destes empregados, a exemplo os cartões de pontos. Empregados devem receber
o salário no momento correto, usando o método que eles preferem, obedecendo várias taxas e
impostos deduzidos do salário.
* Alguns empregados são horistas. Eles recebem um salário por hora trabalhada. Eles
submetem "cartões de ponto" todo dia para informar o número de horas trabalhadas naquele
dia. Se um empregado trabalhar mais do que 8 horas, deve receber 1.5 a taxa normal
durante as horas extras. Eles são pagos toda sexta-feira.
* Alguns empregados recebem um salário fixo mensal. São pagos no último dia útil do mês
(desconsidere feriados). Tais empregados são chamados "assalariados".
* Alguns empregados assalariados são comissionados e portanto recebem uma comissão, um
percentual das vendas que realizam. Eles submetem resultados de vendas que informam a
data e valor da venda. O percentual de comissão varia de empregado para empregado. Eles
são pagos a cada 2 sextas-feiras; neste momento, devem receber o equivalente de 2 semanas
de salário fixo mais as comissões do período.
  * Empregados podem escolher o método de pagamento.
  * Podem receber um cheque pelos correios
  * Podem receber um cheque em mãos
  * Podem pedir depósito em conta bancária
* Alguns empregados pertencem ao sindicato (para simplificar, só há um possível sindicato).
O sindicato cobra uma taxa mensal do empregado e essa taxa pode variar entre
empregados. A taxa sindical é deduzida do salário. Além do mais, o sindicato pode
ocasionalmente cobrar taxas de serviços adicionais a um empregado. Tais taxas de serviço
são submetidas pelo sindicato mensalmente e devem ser deduzidas do próximo
contracheque do empregado. A identificação do empregado no sindicato não é a mesma da
identificação no sistema de folha de pagamento.
* A folha de pagamento é rodada todo dia e deve pagar os empregados cujos salários vencem
naquele dia. O sistema receberá a data até a qual o pagamento deve ser feito e calculará o
pagamento para cada empregado desde a última vez em que este foi pago.

### Mais especificações:

[Clique aqui](https://github.com/bruninhaltorres/Projeto_De_Software/tree/main/Especifica%C3%A7%C3%B5es) para ver mais sobre o projeto.

## Code Smells
### 1. Indecent Exposure
* Um bom encapsulamento acontece quando os dados, atributos, de uma classe são ocultos e seus serviços, métodos, úteis para as demais classes, são públicos. Classes seguras são bem encapsuladas. Esse bad smell é referente à falta de encapsulamento de classes e isso podia ser visto (nessa parte)[https://github.com/bruninhaltorres/Payroll/blob/main/Main.java#L80] em que era feita a declaração das sub classes de Employees(Horistas, Comissionado e Assalariado).

## Refatorando
### 1. Encapsulate Classes with Factory
* Visando resolver o code smell 1(Indecent Exposure), na nova implementação, a classe Employees foi definida como abstract e nela foi colocada as assinaturas de métodos das sub classes, pois, posteriormente, esses métodos das sub classes eram usados por meio de casting:
```java
for(int i = 0; i < size; i++) {
    if(listEmployees.get(i).getId() == idTimeCard) {
        if(listEmployees.get(i).getClass() == Hourly.class) {
            ((Hourly)listEmployees.get(i)).addTimeCard(); 
        }
    }
}
```
Sendo assim, pude implementar herança corretamente:
```java
Employees employees = null;
if (type == 1) { // horista
    employees = new Hourly(name, adress, idEmployee);
    sH.addHourly(employees);
} else if (type == 2) { // comissionado
    double valueComissioned;
    System.out.println("Valor da comissão:");
    valueComissioned = input.nextDouble();
    employees = new Commissioned(name, adress, idEmployee, valueComissioned);
    sC.addCommisioned(employees);
} else {
    double salary;
    System.out.println("Salário:");
    salary = input.nextDouble();
    employees = new Assalaried(name, adress, idEmployee, salary);
    sA.addAssalaried(employees);
}
```
 E seguir usando os métodos que antes já eram usados, como por exemplo, `addTimeCard()` da sub classe Hourly.
```java
for(Employees employees : listEmployees){
    if(employees.getId() == idTimeCard){
        if(employees instanceof Hourly){
            employees.addTimeCard();
            isHourly = 1;
            System.out.println("Cartão de ponto lançado!");
        }
    }
} 
