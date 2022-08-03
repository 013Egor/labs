# UDPServer_java

## Installation
```bash
~/$ javac src/UDPClient.java src/Receiver.java src/Sender.java -d bin/
```

## Usage
```bash
~/$ cd bin
~/bin/java UDPClient #IP #PortReceiver #PortSender
```

After those steps you can:
1) Set your name (@name YourName)
2) Text other user (if you don't set your name you will seems like Unknown)
3) Quit (@quit)

## Example
# User1
```bash
~/$ java UDPClient 127.0.0.1 9898 8989
Input: 
RECEIVED: |from Unknown| Hello
@Misha  
Input: 
Hello, but I don't know you
Input: 
RECEIVED: |from Unknown| I'am sorry, I forgot to set my name name
@quit
Socket closed
```
# User2
```bash
~/$ java UDPClient 127.0.0.1 8989 9898
Input: 
Hello
Input: 
RECEIVED: |from Unknown| Hello, but I don't know you
@Egor
Input: 
I'am sorry, I forgot to set my name name
Input: 
@quit
Socket closed
```
