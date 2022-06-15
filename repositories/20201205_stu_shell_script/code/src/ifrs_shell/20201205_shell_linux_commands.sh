# SISTEMAS DE ARQUIVOS 
# man   | é o comando de manual e apresenta o manual de comandos linux
# cat   | apresenta conteudo de arquivos | cat > arquivo.txt (apaga o conteúdo e coloca um novo conteudo no arquivo) | cat >> arquivo.txt (coloca ao final do arquivo uma nova informação) |  |ctrl + z sai do editor
# pwd   | indica a posição no diretório de arquivos
# cd    | troca de diretórios
# ls    | apresenta o conteudo dos diretórios | -l (lista)
# wc    | imprime a contagem de bytes, palavras ou linhas de um arquivo
# |     | redireciona a saida de um arquivo para outro comando
# EXEMPLO :  cat arquivo.txt | wc -l (linha), -c (caracteres), -b (bytes), -m (chars), -L (max lengh )

# SISTEMAS DE ARQUIVOS 
# touch | cria arquivos
# mkdir | cria diretórios
# cp    | copia arquivo | exemplo: cp /mnt/c/Users/DIRETORIO/ARQUIVO /mnt/c/Users/DIRETORIO/ARQUIVO
# mv    | move arquivos (diferente de copiar)
# cmp   | compara dois arquivos. é útil para comparar as strings de sha256() dos downloads

# SISTEMAS DE ARQUIVOS 
# OPÇÕES são as flag que acompanham comandos e alteram a execução do comando
# ARGUMENTO são os objetos de trabalhos do comandos

# comandos são compostos de comando, opções e argumentos
# exemplo: ls -l script*.sh  (comando: ls, opção: -l, argumento: script*.sh)

# SISTEMAS DE ARQUIVOS 
# META CARACTER são caracteres que modificam os nomes, exemplo: * que representa todos ou: ? que representa qualquer valor

# SISTEMAS DE ARQUIVOS 
# HEAD  | mostra as primeiras 10 linhas
# TAIL  | mostra as ultimas 10 linhas
# SORT  | ordena o arquivo conforme uma opção (flags): sort 
# cmp   | compara dois arquivos. é útil para comparar as strings de sha256() dos downloads

# SISTEMAS DE ARQUIVOS 
#-rw-r--r--     | r (read) w (write) - (nao pode executar) ; x (executar)
#- identifica se é arquivo ou dire´tiriuo 
#rw- sao as parmissoes para o dono do arquivo  (u usuario)
#r-- são para os usuarios do grupo do dono (g grupo)
#r-- são para os usuarios a outros grupos  (o outros)
# chmod | altera permissoes de acesso. exemplo: chmod g+w arquivo.txt || chmod o-r arquivo.txt  || chmod u+x arquivo.txt
# chown | altera o dono do arquivo
# chgrp | altera o grupo do arquivo (melhor que o chmod no caso de grupos)

# SISTEMAS DE ARQUIVOS 
# date       | retorna data hora
# cal        | retorna o calendario (aceita como argumento um ano)
# who        | usuarios logados na maquina
# tty        | apresenta o nome e local do arquivo que representa o terminal
# ps         | processos em execussão
# kill       | mata o processo (-9 encerra execução do processo)
# passwd     | altera a senha de usuario (senha atual, e 2x a nova senha)
# ping       | verifica se maquina esta na rede , ou recurso disponivel
# touch      | cria um arquivo
# su         | super usuario / admin
# sudo       | executa como su sem abrir sessão su
# reboot     | reinicia maquina
# shutdown   | desliga maquina