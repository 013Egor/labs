# TCPServer

## Installation
```bash
~/$ ./start.sh
```

## Usage
Server start:
```bash
~/$ cd bin
~/bin/java src.server.TCPServer #port
```

Client start:
```bash
~/$ cd bin
~/bin/java src.client.TCPClient #IP #port
```
Commands for client:
- @YourName -- Command to set your name
- help -- Open menu
- 0 -- Send message
- 1 -- Show available users
- 2 -- Show received messages
- 3 -- Show sent messages
- 4 -- Quit

Commands for server:
- users - Show available users
- stop -- Stop server

## Example
# Server
```bash
~/$ java src.server.TCPServer 9898
users
------------------------
Availiable users: 
Egor
Misha
------------------------
stop
Server is stoped
Socket closed
```
# User1
```bash
~/$ java src.client.TCPClient 127.0.0.1 9898
Server: Enter your name (input: @name):
@Egor
Server: Name Egor is received
1

Availiable users:
------------------------
Egor
Misha
------------------------

2
---------------------------
Received messages:
---------------------------
Date:19.3.2022
From: Misha
Text:
Hello
---------------------------
3
---------------------------
Sent messages:
---------------------------
4
Client is closed
Socket closed
Receiver is crushed. Please reload.
```

# User2
```bash
~/$ java src.client.TCPClient 127.0.0.1 9898
Server: Enter your name (input: @name):
@Misha
Server: Name Misha is received
help
0: Send message
1: Show available users
2: Show received messages
3: Show sent messages
4: quit
0
Whom you want to text: Egor
Enter text of message:
Hello
quit
Server: OK: Got message
1

Availiable users:
------------------------
Egor
Misha
------------------------

2
---------------------------
Received messages:
---------------------------
3
---------------------------
Sent messages:
---------------------------
Date:19.3.2022
From: Misha
Text:
Hello
---------------------------
4
Client is closed
Socket closed
Receiver is crushed. Please reload.
```
