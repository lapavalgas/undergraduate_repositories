
# comando IF

echo entre com uma nota, 0-10:
read NOTA
if [ $NOTA -ge 0 -a $NOTA -le 10 ]
then
    echo no intervalo, nota valida
else
    echo fora intervalo, nota invalida
fi
