<p align="center">
  Language:
  <a href="README.md">English</a> | 
  <a href="README.pt.md">Português</a>
</p>

# RMI Remote Control
This project demonstrates communication between distributed applications using Java's native API. \
**RMI** allows an object in one JVM to invoke methods on an object in another JVM, making it easier to build distributed systems. \
The scenario simulates a remotely controlled TV, where the client sends commands to turn on/off, adjust volume, and change channels, and the server processes these requests in real time.

## Technologies
- Java
- Java RMI
- RMI Registry

## Structure
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

## Installation
**1.** Check if **Java** is installed on the **client** and **server** machines:
> To confirm, run in the terminal:
> ```bash
> java -version
> ```
> If not installed, download [Java](https://www.oracle.com/java/technologies/downloads/).

**2.** Download or clone the repository on both machines:
> ```bash
> git clone https://github.com/wxrley/remote-control-rmi.git
> ```

## Running
> [!WARNING]
> Ensure that the client and server are on the same **local network** and that ports **1099** (RMI Registry) and **1100** (remote object) are open in the firewall on the server machine.

### Option 1 — Via Terminal (Different machines)
**1.** In the server root, compile the files:
> ```bash
> javac ServerMain.java RemoteControl.java RemoteControlImplementation.java
> ```

**2.** Run the server:
> ```bash
> java ServerMain
> ```
> Enter the **server machine's IP**. \
> To stop the server, press `ctrl+c`.

**3.** In the client root, compile the files:
> ```bash
> javac ClientMain.java RemoteControl.java
> ```

**4.** Then, run the client:
> ```bash
> java ClientMain
> ```
> Enter the **server machine's IP**. \
> The remote control menu is displayed. \
> To close the client, choose option **0**.

### Option 2 — Via IDE (IntelliJ, Eclipse, VS Code, etc.)
**1.** Open the project folder in your preferred IDE. \
**2.** Open the project on the **server machine** and run `ServerMain` and enter the **server machine's IP**. \
**3.** Next, open the project on the **client machine** and run `ClientMain` and enter the **server machine's IP**. \
**5.** The remote control menu is displayed. \
**6.** To stop the server, stop the execution. \
**7.** To close the client, choose option **0**.
