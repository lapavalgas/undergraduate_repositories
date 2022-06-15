
# comando test (equivaleria a um if?)
echo sim ou não
read RESPOSTA
test $RESPOSTA = "sim" && exit
echo O usuário não digitou sim e permanece no programa...
echo o programa continua!
