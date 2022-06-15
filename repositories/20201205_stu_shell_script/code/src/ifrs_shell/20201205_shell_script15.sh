
# comando WHILE (é parecido com IF)

echo Entre com uma nota valida
read NOTA
while [ $NOTA -lt 0 -o $NOTA -gt 10 ] # esses operadores são tricks
do 
    echo nota invalida, redigite
    read NOTA
done
echo nota valida!
echo Continua procesasmento....