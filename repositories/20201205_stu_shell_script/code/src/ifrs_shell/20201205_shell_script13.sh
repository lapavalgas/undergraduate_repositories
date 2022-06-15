
# comando IF

# quyando usa o comando TEST em uma verificação IF não se utiliza os colchetes

#testa diretório
if test -d /mnt/c/Users/ 
then
    echo existe a pasta users
    
else
    echo não existe a pasta users
fi

# testa arquivo
if test -f /mnt/c/Users/hellowWorld.sh 
then
    echo existe a o arquivo hwlloWorld.sh
    
else
    echo não existe a o arquivo hwlloWorld.sh
fi