# ssh pi@ip (shell remoto)




# comando WHILE testando o sistema de arquivos

# while ping - c 3 192.168.0.146  # faz um ping, se enviar/receber então permanece conectando
# do
#     echo
#     echo @@@@ Host Ativo
# done
# echo
# echo @@@@ Host Down @@@@
# echo


# mesmo script de cima mas utilizando argumentos, para passar o ip dinamicamente ao chamar o programa
while ping - c 3 $1  
do
    echo
    echo @@@@ Host Ativo
done
echo
echo @@@@ Host Down @@@@
echo