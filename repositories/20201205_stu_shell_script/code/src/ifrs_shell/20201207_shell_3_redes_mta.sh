# MTA MAIL TRANSFER AGENT

# mta transfere arquivos por email
# users, mail servers and SMTP protocol

# SMTP send menssegers between servers
# users agent read menssegers

# sudo apt-cache search ssmtp

# sudo apt-get insmtall ssmtp -y

## /etc/ssmtp 
### ssmtp.conf (arquivo de configurações do ssmtp, serviço de mail)

# mailhub=smtp.gmail.com:587
# FromLineOverride=YES  (descoment)
# UseTLS=YES  (add)
# UseSTARTTLS=YES  (add)
# AuthUser=raspcurso@gmail.com
# AuthPass=senha (senha original)
# AuthMethod=LOGIN 

# TLS = Transport Layer Security  (camada de segurança de transporte mail, criptografia)

# sudo apt-cache search mutt
## mutt : leitor de mail suporta MIME, GPG, PGP e threading (criptografia) (editor de msg de emails)
### configura:  echo "set sendmail=\"/usr/sbin/ssmtp\"" > . /.muttrc
#### mandando um e-mail:
# echo "Mensagem Inicial de Teste" | sudo mutt -s "Assunto da Mesagem Inicial" -- destinatario@gmail.com
#### mandando um e-mail com anexo:
# echo "Mensagem Inicial de Teste" | sudo mutt -s "Assunto da Mesagem Inicial" -a <file_path> -- destinatario@gmail.com

# POR FALHAS MUDOU DO SSMTP PARA MSMTP 


