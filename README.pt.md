<p align="center">
  Language:
  <a href="README.md">English</a> | 
  <a href="README.pt.md">Português</a>
</p>

# Controle Remoto RMI
Este projeto demonstra a comunicação entre aplicações distribuídas com a API nativa do Java. \
O **RMI** permite que um objeto em uma JVM invoque métodos em outro objeto em outra JVM, facilitando a construção de sistemas distribuídos. \
O cenário simula uma TV controlada remotamente, onde o cliente envia comandos para ligar/desligar, ajustar volume e trocar canais, e o servidor processa as requisições em tempo real.

## Tecnologias
- Java
- Java RMI
- RMI Registry

## Estrutura
```
📂 remote-control-rmi/
├── 📂 client/
│   ├── ClientMain.java
│   └── RemoteControl.java
│
├── 📂 server/
│   ├── RemoteControl.java
│   ├── RemoteControlImplementation.java
│   └── ServerMain.java
│
├── README.md
└── README.pt.md
```

## Instalação
**1.** Verifique se o **Java** está instalado na máquina do **cliente** e do **servidor**:
> Para confirmar, execute no terminal:
> ```bash
> java -version
> ```
> Caso não esteja instalado, baixe o [Java](https://www.oracle.com/java/technologies/downloads/).

**2.** Baixe ou clone o repositório em ambas as máquinas:
> ```bash
> git clone https://github.com/wxrley/remote-control-rmi.git
> ```

## Execução
> [!WARNING]
> Garanta que cliente e servidor estejam na mesma **rede local** e que as portas **1099** (RMI Registry) e **1100** (objeto remoto) estejam liberadas no firewall da máquina servidora.

### Opção 1 — Via Terminal (Máquinas diferentes)
**1.** Na raiz do servidor, compile os arquivos:
> ```bash
> javac ServerMain.java RemoteControl.java RemoteControlImplementation.java
> ```

**2.** Execute o servidor:
> ```bash
> java ServerMain
> ```
> Informe o **IP da máquina servidora**. \
> Para encerrar o servidor, digite `ctrl+c`.

**3.** Na raiz do cliente, compile os arquivos:
> ```bash
> javac ClientMain.java RemoteControl.java
> ```

**4.** Em seguida, execute o cliente:
> ```bash
> java ClientMain
> ```
> Informe o **IP da máquina servidora**. \
> O menu do controle remoto é exibido. \
> Para encerrar o cliente, escolha a opção **0**.

### Opção 2 — Via IDE (IntelliJ, Eclipse, VS Code, etc.)
**1.** Abra a pasta do projeto na sua IDE preferida. \
**2.** Abra o projeto na **máquina servidora**, execute `ServerMain` e informe o **IP da máquina servidora**. \
**3.** Em seguida, abra o projeto na **máquina cliente** e execute `ClientMain` e informe o **IP da máquina servidora**. \
**5.** O menu do controle remoto é exibido. \
**6.** Para encerrar o servidor, pare a execução. \
**7.** Para encerrar o cliente, escolha a opção **0**.
