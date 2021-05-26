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

## Refatoramento
### 1. Encapsulate Classes with Factory
Um bom encapsulamento acontece quando os dados, atributos, de uma classe são ocultos e seus serviços, métodos, úteis para as demais classes, são públicos. Classes seguras são bem encapsuladas. **Indecent Exposure** é o nome referente à falta de encapsulamento de classes e isso podia ser visto na implementação anterior a partir [dessa linha](https://github.com/bruninhaltorres/Payroll/blob/main/Main.java#L80) onde era feita a declaração das sub classes de Employees(Horistas, Comissionado e Assalariado).
Visando resolver esse problema, na nova implementação, a classe Employees foi definida como abstract e nela foi colocada as assinaturas de métodos das sub classes, pois, posteriormente, esses métodos das sub classes eram usados por meio de [casting](https://github.com/bruninhaltorres/Payroll/blob/main/Main.java#L163).
Sendo assim, pude [implementar herança corretamente](https://github.com/bruninhaltorres/Payroll_Refactor/blob/main/src/EmployeeMenu.java#L72) e continuar usando os métodos que antes já eram usados, como por exemplo, `addTimeCard()` da sub classe Hourly.

### 2. Strategy
Esse padrão permite que você extraia o comportamento variante para uma hierarquia de classe separada e combine as classes originais em uma, reduzindo o código duplicado. Ou seja, quando você tem muitas classes parecidas que somente diferem na forma que elas executam algum comportamento é o momento de aplicar o padrão Strategy. Então, pode-se afirmar que, na implementação anterior, tem uma grande duplicação de código quando é rodada a folha de pagamento, pois a ação de pagar os empregados é a mesma para todas as classes, e o que muda é apenas a *estratégia* de quando será pago. [Clique para ver](https://github.com/bruninhaltorres/Payroll/blob/6dcf7d4f604309489cd848d35444e7d3dae424ec/src/payment/Payroll.java#L29)
Visto isso, foi criada uma [interface](https://github.com/bruninhaltorres/Payroll_Refactor/blob/main/src/strategy/StrategyPayment.java) que é implementada em cada classe do Strategy e na hora de [rodar a folha de pagamento](https://github.com/bruninhaltorres/Payroll_Refactor/blob/main/src/Main.java#L275) todas as sub classes (Horista, Comissionado e Assalariado) rodam o método `payroll()` declarado na interface, porém só é pago quem satisfaz as condições de pagamento.
