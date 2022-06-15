# FTP / file transfere protocol : transferencia de arquivos

# sudo apt-get update 
# sudo apt-get upgrade -y --fix-missing

# sudo apt-cache search ftp | more  : pesquisa uma série de serviços de ftp disponiveis
### foi sugerido o  >>> vsftpd

# sudo apt-get install vsftpd -y


# service <nome_serviço> status : verifica o status do serviço  

# portas ftp  20 / 21 (controle / envio dados)

# sudo ufw status numbered

# sudo ufw allow from <ip> to any port 20 
# sudo ufw allow from <ip> to any port 21

# ftp : acessa o ftp (estilo sql)

# ftp <ip> : conecta via ftp a um host
## é solicitado nome usuario
### é solicitado a senha
### pwd : demonstra o diretório e mque o ftp foi conectado  (comum:  /home/<user>)

# após falhas foi sugerido o >> filezilla (interface grafica)

# sudo apt-cache search filezilla
# sudo apt-get install filezilla -y








