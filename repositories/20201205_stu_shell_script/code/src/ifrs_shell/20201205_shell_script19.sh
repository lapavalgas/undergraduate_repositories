
# comando FOR e SEQ

# seq -5 5 | gera uma sequencia de -5 até 5


for I in $(seq -5 5)
do
    echo Valor de i: $I
done
