# Trabalho de Sistemas Operacionais
# Trabalho Prático 2

## Prof. Miguel Gomes Xavier

### Roteiro
### Objetivos
1. Utilizar programação multithreading.
2. Praticar técnicas de sincronização de processos.
3. Estudar soluções para o problema clássico do jantar dos filósofos.

#### Jantar para N filósofos
Este trabalho prático consiste na implementação de uma aplicação multithreading capaz de
modelar o problema do jantar dos filósofos para N filósofos.

**Cada filósofo deve ser modelado como uma thread** em linguagem Java, C/C++, Python ou
C#. Os garfos consistem em semáforos binários (mutex). Cada par de filósofos adjacentes
possuem um garfo compartilhado.

Os filósofos devem alternar entre os estados PENSANDO, COMENDO e
TENTANDO_COMER. Um filósofo gasta 5 segundos pensando e 2 segundos comendo. Para
poder comer, o filósofo deve ter sido capaz de segurar os garfos da esquerda e da direita
simultaneamente. Se ele não conseguir pegar os garfos ele deve entrar no estado
TENTANDO_COMER e pensar durante um tempo aleatório entre 0 e 3 antes de tentar comer
novamente. Os três estados citados devem estar explicitos no código.

O usuário da aplicação deve ser capaz de **escolher a quantidade de filósofos e o tempo de
execução da aplicação.** Ao final da execução, a aplicação deve exibir um relatório indicando
os seguintes itens:
- Quantas vezes cada filósofo comeu;
- Quantas vezes cada filósofo pensou;
- Quantas vezes cada filósofo entrou no estado TENTANDO_COMER.

#### Entrega
O trabalho pode ser realizado com no máximo 3 alunos. Junto com a implementação, deve ser
entregue um relatório de no máximo 3 páginas explicando detalhes da implementação. A
entrega do trabalho deve ser realizada pelo Moodle e o mesmo deve ser apresentado em sala
de aula na data indicada no cronograma da disciplina.
