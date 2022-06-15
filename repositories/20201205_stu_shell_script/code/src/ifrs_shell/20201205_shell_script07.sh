
# testa arquivo

echo entre com um caminho identificando arquivo ou diretorio
read FILENAME
test -d $FILENAME && echo O caminho é um diretório
test -f $FILENAME && echo O caminho é um arquivo

# -d    | testa se é um diretório
# -f    | testa se é um arquivo

