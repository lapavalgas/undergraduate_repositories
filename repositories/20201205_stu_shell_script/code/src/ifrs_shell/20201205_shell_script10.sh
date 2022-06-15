
# comando IF em shell ## portanto o comando TEST não é o comando IF
# detalhes utilizando o comando  : man test
#man test

echo sim ou não
read RESPOSTA
if [ $RESPOSTA = "SIM" -o $RESPOSTA = "sim" ] #respeitar os espaços!
then
    echo resposta afirmativa
else
    echo resposta negativa
fi
echo hello!

