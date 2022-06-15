# ifconfig : verifica conexão de rede com internet

# ping <ip> : ping um website

# SSH : openSSH client (remote login program)

# copmando:

# ssh <user>@<ip>
# ssh pi@127.0.0.1
### servidor deve estar com conexão ssh habilitada
### firewall não deve estar barrando

# ufw : firewall
# ufw status : verifica status do firewall
# ufw disable : desabilita firewall
# ufw enable : habilita o firewall
### o ideal é deixar o firewall ligado , e utilizar apenas uma porta aberta
# ufw allow from <ip> to any port <port> : libera uma porta para um endereço ip espsecifico

# quando o ssh conseguir conectar será necessário entrar com a senha do usuário (servidor)

# who : identifica os usuarios ativos
# whoami : identifica o usuario ativo

# exit : fecha terminal remoto (ssh)