# Kafka
Kafka Installation on Windows 10 using Windows Subsystem for Linux(WSL2) and Spring boot integration with kafka

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
8. Setup the $PATH environment variables for easy access to the kafka binaries

   
**Installation**

WSL2
Windows Subsystem for Linux is a feature of Windows that allows developers to run a Linux environment without the need for a separate virtual machine or dual booting.

1. Open Windows Power Shell on your system
   
2. Type wsl --install on power shell and click on Enter.
   
3. It will start installation of wsl as shown below
   **Installing: Virtual Machine Platform
Virtual Machine Platform has been installed.
Installing: Windows Subsystem for Linux
Windows Subsystem for Linux has been installed.
Installing: Windows Subsystem for Linux
[============              21.0%**

4. Once the installation get completed it will show below message. Changes will be effective after rebooting the system.
**Installing: Virtual Machine Platform
Virtual Machine Platform has been installed.
Installing: Windows Subsystem for Linux
Windows Subsystem for Linux has been installed.
Installing: Windows Subsystem for Linux
Windows Subsystem for Linux has been installed.
Installing: Ubuntu
Ubuntu has been installed.
The requested operation is successful. Changes will not be effective until the system is rebooted**.

