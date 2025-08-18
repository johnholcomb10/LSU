
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <ws2spi.h>
#include <errno.h>




int main(int argc, char** argv){

    if(argc != 3){
        printf("[*]USAGE: %s <ipaddr> <port> \n",argv[0]);
        return 0;
    }


    printf("[*]Starting...\n");
    int port = atoi(argv[2]); //We get the port as text, so convert it to an integer with atoi (ascii to integer)
    int sock, addrlen, opt;

    struct sockaddr_in server; //make our sockaddr struct
    sock = socket(AF_INET,SOCK_STREAM,0);//AF_Inet - addresses are in ipv4 format | SOCK_STREAM -> connected, Stream based (TCP) | 0 corresponds to the IP protocol (see man socket)
    server.sin_family = AF_INET; //server's address will be in ipv4
    server.sin_port = htons(port); // convert local machine port representation (little endian most likely) to network representation (Big endian)

    //Next we convert our text based ipv4 address into one that the struct needs (binary)
    if(inet_pton(AF_INET,argv[1],&server.sin_addr) <=0){
        printf("[!]Error processing IP address\n");
        return 1;
    }
    //Connect to server
    if(connect(sock,(struct sockaddr *) &server, sizeof(server))){
        printf("[!]Connection to file server failed\n");
        return 1;
    }

    char buf[1024];
    int sentC, readCount;

    while (1) {
        printf("[*] Enter a message to send to the server (or type 'exit' to quit):\n");
        fgets(buf, 1024, stdin);
        
        if (strncmp(buf, "exit", 4) == 0) {
            break;
        }
        
        int len = strlen(buf);
        if ((sentC = send(sock, buf, len, 0)) < len) {
            printf("[!] Message not fully sent!\n");
        }
        printf("[*] Message sent! Sent %d bytes!\n", sentC);
        
        printf("[*] Waiting for server response...\n");
        printf("[*] Begin Message!\n");
        do {
            readCount = recv(sock, buf, sizeof(buf) - 1, 0);
            if (readCount > 0) {
                buf[readCount] = '\0';
                printf("%s", buf);
            }
        } while (readCount > 0);
        printf("<---------END--------->\n");
    }

    closesocket(sock);

}