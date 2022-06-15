
# comando WHILE testando o sistema de arquivos

while test -f /mnt/c/Users/lock
do
    echo Aguardando liberação
    sleep 5
done
echo Recurso liberado






# ssh pi@ip (shell remoto)