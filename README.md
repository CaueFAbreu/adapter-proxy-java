# 🧩 Lab 3 — Padrões de Projeto: Adapter & Proxy

Implementações dos padrões de projeto **Adapter** e **Proxy** desenvolvidas para o Laboratório 3 da disciplina *Princípios e Padrões de Projetos*.

---

## 📋 Visão Geral

| Questão | Padrão | Contexto |
|---------|--------|----------|
| `questao1` | Adapter | Adaptação de patos e pavões para a interface `Ave` |
| `questao2` | Adapter | Adaptação de uma calculadora binária para operar com decimais |
| `questao3` | Adapter / Wrapper | Integração de um sistema de pagamento legado a uma loja virtual |
| `questao4` | Proxy | Controle de acesso a vídeos premium com lazy initialization |

---

## 🗂️ Estrutura do Projeto

```
src/
├── questao1/
│   ├── Ave.java              # Interface alvo (target)
│   ├── Pato.java             # Interface incompatível
│   ├── Pavao.java            # Interface incompatível
│   ├── PatoDomestico.java    # Adaptado via PatoAdapter
│   ├── PavaoAzul.java        # Adaptado via PavaoAdapter
│   ├── PatoAdapter.java      # Adapter: Pato → Ave
│   ├── PavaoAdapter.java     # Adapter: Pavao → Ave
│   └── Main.java
├── questao2/
│   ├── CalculadoraDecimal.java   # Interface alvo (target)
│   ├── CalculadoraBinaria.java   # Classe legada (adaptada)
│   ├── CalculadoraAdapter.java   # Adapter: binária → decimal
│   └── Main.java
├── questao3/
│   ├── LeitorPagamento.java        # Interface alvo (target)
│   ├── SistemaPagamentoAntigo.java # Sistema legado (adaptado)
│   ├── PagamentoAdapter.java       # Adapter: centavos → reais
│   ├── LojaVirtual.java            # Cliente do LeitorPagamento
│   └── Main.java
└── questao4/
    ├── Video.java          # Interface compartilhada (Proxy + RealSubject)
    ├── VideoPremium.java   # RealSubject (objeto base)
    ├── VideoProxy.java     # Proxy (controle de acesso + lazy init)
    ├── Usuario.java        # Entidade com flag de assinatura premium
    └── Main.java
```

---

## 🔍 Detalhamento das Questões

### Questão 1 — Adapter: Aves

**Problema:** o sistema trabalha com a interface `Ave` (`voar()` + `emitirSom()`), mas as classes `PatoDomestico` e `PavaoAzul` implementam interfaces incompatíveis (`Pato` e `Pavao`, respectivamente).

**Solução:** `PatoAdapter` e `PavaoAdapter` implementam `Ave` e delegam as chamadas às interfaces originais, traduzindo `grasnar()` e `cantar()` para `emitirSom()`.

```
PatoDomestico  ──►  PatoAdapter  ──►  Ave
PavaoAzul      ──►  PavaoAdapter ──►  Ave
```

---

### Questão 2 — Adapter: Calculadora Binária → Decimal

**Problema:** existe uma `CalculadoraBinaria` que opera com `String` no formato binário, mas o sistema precisa de uma `CalculadoraDecimal` que opere com `int`.

**Solução:** `CalculadoraAdapter` implementa `CalculadoraDecimal` e delega para `CalculadoraBinaria`, convertendo os valores entre decimal e binário. A operação `multiplicar` é implementada diretamente no adapter via somas repetidas.

```
CalculadoraBinaria  ──►  CalculadoraAdapter  ──►  CalculadoraDecimal
```

---

### Questão 3 — Adapter: Sistema de Pagamento Legado

**Problema:** a `LojaVirtual` depende da interface `LeitorPagamento` que recebe valores em `double` (reais), mas o `SistemaPagamentoAntigo` só aceita pagamentos em `int` (centavos).

**Solução:** `PagamentoAdapter` faz a ponte, convertendo o valor em reais para centavos antes de repassar ao sistema legado.

```
SistemaPagamentoAntigo  ──►  PagamentoAdapter  ──►  LeitorPagamento  ◄──  LojaVirtual
```

---

### Questão 4 — Proxy: Vídeo Premium com Controle de Acesso

**Problema:** o objeto `VideoPremium` é pesado para carregar e seu acesso deve ser restrito a assinantes premium. O cliente (`Main`) não deve interagir diretamente com `VideoPremium`.

**Solução:** `VideoProxy` implementa a mesma interface `Video` e atua como intermediário: verifica se o usuário tem assinatura premium antes de instanciar `VideoPremium` (lazy initialization). Usuários comuns recebem mensagem de acesso negado sem que o objeto real seja criado.

```
Main  ──►  VideoProxy  ──► (se premium) ──►  VideoPremium
                      └──► (se comum) ──►  "Acesso negado"
```

| Papel no padrão | Classe |
|---|---|
| Proxy | `VideoProxy` |
| RealSubject | `VideoPremium` |
| Interface | `Video` |
| Cliente | `Main` |

---

## ⚙️ Como Compilar e Executar

**Pré-requisito:** JDK 8 ou superior instalado.

### Compilar todas as questões

```bash
javac -d out src/questao1/*.java src/questao2/*.java src/questao3/*.java src/questao4/*.java
```

### Executar cada questão

```bash
java -cp out questao1.Main
java -cp out questao2.Main
java -cp out questao3.Main
java -cp out questao4.Main
```

---

## 🖥️ Saída Esperada

**Questão 1**
```
=== Pato Domestico como Ave ===
Pato domestico voando.
Pato domestico grasnando.

=== Pavao Azul como Ave ===
Pavao nao consegue voar.
Pavao azul cantando.
```

**Questão 2**
```
=== Operacoes binarias usando calculadora existente ===
1010 + 11 = 1101
1010 - 11 = 111

=== Operacoes decimais usando Adapter ===
10 + 3 = 13
10 - 3 = 7
10 * 3 = 30
```

**Questão 3**
```
Finalizando compra no valor de R$ 59.9
Pagamento processado pelo sistema antigo: 5990 centavos.
```

**Questão 4**
```
=== Tentativa de usuario comum ===
Acesso negado para Fabiola. Apenas assinantes premium podem assistir a este video.

=== Tentativa de usuario premium ===
Carregando arquivo pesado do video premium: Aula exclusiva de Padroes de Projeto
Reproduzindo o video premium 'Aula exclusiva de Padroes de Projeto' para Cauê.
```

---

## 🛠️ Tecnologias

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=flat&logo=intellij-idea&logoColor=white)
