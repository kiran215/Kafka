# Kafka
Kafka Installation on Windows 10 using Windows Subsystem for Linux(WSL2)

Due to several issues it is not recommended to install kafka directly on windows.
Below are the issues that can be arise over a time while using kafka on windows machine. Go to below links for more details on issues.
1. https://issues.apache.org/jira/browse/KAFKA-8811
2. https://issues.apache.org/jira/browse/KAFKA-1194

It is recommended to use WSL2 to install kafka on windows 10 or above.

How to install kafka with zookeeper on windows
1. You must have windows 10 or above
2. Install WSL2
3. Install Java JDK version 11
4. Download Apache kafka latest version from https://kafka.apache.org/downloads
5. Extract contents on WSL2
6. Start zookeeper using binaries in WSL2
7. Start kafka using binaries in another process in WSL2
   
**Installation**

1. WSL2 : 

Windows Subsystem for Linux is a feature of Windows that allows developers to run a Linux environment without the need for a separate virtual machine or dual booting.

i) Open Windows Power Shell on your system
   
ii) Type wsl --install on power shell and click on Enter.
   
iii) It will start installation of wsl as shown below

   **Installing: Virtual Machine Platform
Virtual Machine Platform has been installed.
Installing: Windows Subsystem for Linux
Windows Subsystem for Linux has been installed.
Installing: Windows Subsystem for Linux
[============              21.0%**

iv) Once the installation get completed it will show below message. Changes will be effective after rebooting the system.

**Installing: Virtual Machine Platform
Virtual Machine Platform has been installed.
Installing: Windows Subsystem for Linux
Windows Subsystem for Linux has been installed.
Installing: Windows Subsystem for Linux
Windows Subsystem for Linux has been installed.
Installing: Ubuntu
Ubuntu has been installed.
The requested operation is successful. Changes will not be effective until the system is rebooted**.

v) After rebooting the system a console window will open and it will start launching of Ubuntu on your system

   **Ubuntu is already installed.
Launching Ubuntu...
Installing, this may take a few minutes...**

vi) To complete the installation you will be asked to create username and password for your Linux machine.
   Username should be different than windows username. This username will be your Linux administrator with the ability to run sudo command.
   
vii) Disable IPv6 on WSL2
   WSL2 currently has some networking issue which prevent outside program (Java programs, Conduktor etc..) to connect to kafka on WSL2.
   To fix this it is recommended that disable IPv6 on WSL2.

   Commands to disbale IPv6 on WSL2. First command will ask to enter the password of Linux user created in steps 6.
   
   > sudo sysctl -w net.ipv6.conf.all.disable_ipv6=1

   > sudo sysctl -w net.ipv6.conf.default.disable_ipv6=1

2. Install Java JDK11 on WSL2 Ubuntu

i) Run below commands to download Amazon Corretto 11 running a Debian-based operating system(Ubuntu).
   Refer below link for more details
   https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/generic-linux-install.html
   Commands as below :
   
   > wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add -

   > sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
   
   > sudo apt-get update; sudo apt-get install -y java-11-amazon-corretto-jdk

ii)   After installation of Java JDK 11 check the installed java version using java --version command , it will give below response

**openjdk 11.0.22 2024-01-16 LTS
OpenJDK Runtime Environment Corretto-11.0.22.7.1 (build 11.0.22+7-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.22.7.1 (build 11.0.22+7-LTS, mixed mode)** 

3. Install Apache kafka

i) Use below steps to download latest version of kafka on WSL2 Ubuntu.To check the latest version of kafka go to https://kafka.apache.org/downloads

   a) Below command will download zip file of kafka binaries
    
       >  wget https://archive.apache.org/dist/kafka/3.6.1/kafka_2.13-3.6.1.tgz
       
   b) To extract the zip file downloaded in above steps use below command
   
       >  tar xzf kafka_2.13-3.6.1.tgz

4. Start Zookeeper
   Apache kafka depends on Zookeeper for cluster management. Zookeeper comes with kafka installation.
   Use below command to start zookeeper
   
   > ~/kafka_2.13-3.6.1/bin/zookeeper-server-start.sh ~/kafka_2.13-3.6.1/config/zookeeper.properties
   
6. Start Apache kafka on another shell window
   
   > ~/kafka_2.13-3.6.1/bin/kafka-server-start.sh ~/kafka_2.13-3.6.1/config/server.properties

Keep both shell windows opened, otherwise you will shut down Kafka or Zookeeper.

Add on - 
To keep the zookeeper and Kafka running in background start both zookeeper and kafka using below commands

 > ~/kafka_2.13-3.6.1/bin/zookeeper-server-start.sh -daemon ~/kafka_2.13-3.6.1/config/zookeeper.properties

 > ~/kafka_2.13-3.6.1/bin/kafka-server-start.sh -daemon ~/kafka_2.13-3.6.1/config/server.properties 

We have used daemon in above command. In the Unix and Linux world, a daemon is a background process that typically performs tasks without requiring user interaction

Zookeeper by default runs on 2181 port, test the same using below telnet command 
> telnet localhost 2181

Kafka by default runs on 9092 port, test the same using below telnet command
> telnet localhost 9092

To stop Zookeeper use below command

   > ~/kafka_2.13-3.6.1/bin/zookeeper-server-stop.sh

To stop Kafka use below command

   > ~/kafka_2.13-3.6.1/bin/kafka-server-stop.sh
   
