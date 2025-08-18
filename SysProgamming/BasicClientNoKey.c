#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <errno.h>

int main(int argc, char** argv){

    if(argc != 3){
        printf("[*]USAGE: %s <ipaddr> <port> \n",argv[0]);
        return 0;
    }

    printf("[*]Starting...\n");
    int port = atoi(argv[2]);
    int sock;

    struct sockaddr_in server;
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0) {
        perror("[!]Socket creation failed");
        return 1;
    }

    server.sin_family = AF_INET;
    server.sin_port = htons(port);

    if(inet_pton(AF_INET, argv[1], &server.sin_addr) <= 0){
        printf("[!]Error processing IP address\n");
        return 1;
    }

    if(connect(sock, (struct sockaddr *) &server, sizeof(server)) < 0){
        perror("[!]Connection to server failed");
        return 1;
    }

    char buf[1024];
    while(1){
        printf("[*]Enter a message to send to the server (type 'exit' to quit):\n");
        if (fgets(buf, sizeof(buf), stdin) == NULL) {
            printf("[!]Error reading input\n");
            break;
        }

        // Remove newline character
        size_t len = strlen(buf);
        if(buf[len - 1] == '\n') buf[len - 1] = '\0';

        if(strcmp(buf, "exit") == 0){
            printf("[*]Exiting.\n");
            break;
        }

        int sentC = send(sock, buf, strlen(buf), 0);
        if(sentC < 0){
            perror("[!]Failed to send message");
            break;
        }

        printf("[*]Message sent! Sent %d bytes!\n", sentC);
        printf("[*]Waiting for server response...\n");

        printf("[*]Begin Message!\n");
        int readCount;
        do{
            readCount = recv(sock, buf, sizeof(buf) - 1, 0);
            if(readCount <= 0){
                printf("[!]Connection closed or error occurred\n");
                goto end;
            }
            buf[readCount] = '\0';
            printf("%s", buf);
        } while(readCount == sizeof(buf) - 1);
        printf("\n<---------END--------->\n");
    }

end:
    close(sock);
    return 0;
}