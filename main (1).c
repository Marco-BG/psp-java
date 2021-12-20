#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>


void manejadorSennal(int num_senyal){
    printf("[Señal recibida %d\n]",num_senyal);
}

int main(int argc, char const *argv[]){

int fd[2];
pid_t pidAbuelo;

pid_t proceso;

pipe(fd); //Se crea el pipe para la comunicacion entre padre e hijo

//Creamos el padre y el hijo

proceso = fork();

if(proceso == -1){
    perror("No se ha creado el hijo correctamente");
    exit(-1);
}
if(proceso == 0){//Nos encontramos con el hijo
    close(fd[1]); //Cierro el pipe que no usa
    sleep(1);
    kill(getppid(), SIGUSR1);
    read(fd[0], &pidAbuelo, sizeof(pidAbuelo));

    printf("[Hijo]: Mi pid es %d, el pid de mi padre es %d y el pid de mi abuelo es %d\n",getpid(), getppid(), pidAbuelo);

}else{
     int estado_hijo = -4;

     pid_t abuelo = getppid();

    signal(SIGUSR1, manejadorSennal);
    pause(); //Esperamos la señal del hijo
    write(fd[1], &abuelo, sizeof(unsigned int));//Envio el pid del padre del padre al hijo
    wait(&estado_hijo);//Espero a que termine el hijo pasandole su estado
    printf("El estado de salida es => %d\n", WEXITSTATUS(estado_hijo));//Imprimo el estado de salida
}
return 2;
}

