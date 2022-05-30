# Banco digital com Java e Orientação a Objetos

Reforçando o conhecimento em Programação Orientada a Objetos(POO) em Java com o desafio de projeto totalmente prático proposto 
pela [Gigital innovation One](https://www.dio.me/). Para isso, os pilares da orientação a objetos foram devidamente explorados 
no contexto bancário.

## Sobre o sistema
Para exercitar o paradigma da POO criei essa aplicação chamada, Banco Digital. Nela é possível fazer operações típicas de um banco(instituição financeira). Desta forma podemos criar uma conta, depositar, transferir, bloquear e
desativar uma conta específica de um determinado usuário, impedindo que ele realize tais movimentos financeiros dentro da sua conta. O sistema também possui um histórico de movimentações que tem como objetivo registrar todas as
operações feitas pelos titulares. Também foram criadas algumas exceções personalizadas com o objetivo de deixar claro os erros emitidos pela aplicação com relação as operações realizadas pelos titulares. E estas foram as melhorias 
feitas por mim durante o desenvolvimento desse projeto.


## Sobre a operações 
Veja quais são as operações existente dentro desse sistema bancário que podem ser realizada pelo usuário:
 * Criar conta corrente ou poupança
 * Depositar
 * Sacar
 * Transferir
 * Bloquear e desbloquear conta
 * Desativar e ativar conta
 * Ver histórico de saques, depósitos e transferências
 * Ver extrato

 Todas essas operações requer uma regra para que elas ocorram, veja:

### Criar conta
Para criar uma conta corrente ou poupança é necessário que o titular informe seus dados para que elas sejam criadas, neste caso simples, basta o usuário informar o CPF e o nome.

### Depósito
Esta operação pode ser realizada livremente pelo usuário ou terceiros exceto se, sua contra não encontrar-se bloqueada ou desativada.

### Saque
Somente o titular da conta pode realizar esta operação, a menos que, sua contra encontra-se bloqueada, inativa ou possua valores inferiores ao valor que deseja sacar.

### Transferência
Para este tipo de operação, somente dono da conta, o usuário, poderá realizar, a não ser que, ela esteja bloqueada, inativa ou possua valores inferiores ao valor que deseja transferir.

### Bloqueio de conta
Uma vez que a conta encontra-se bloqueada, o usuário fica impossibilitado de depositar, sacar, enviar e receber valores até que sua conta seja desbloqueada.

### Desativação de conta
Uma conta desativada significa que ela foi excluída, ou seja, não existe um titular para ela . Para que a desativação da conta ocorra é necessário que não haja valores nela.