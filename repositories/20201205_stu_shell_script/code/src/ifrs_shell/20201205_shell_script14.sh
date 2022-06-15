
# comando WHILE (é parecido com IF)

echo Continuar, Sim ou não?
read RESPOSTA
while [ $RESPOSTA = "sim" ]
do 
    echo Workintg...
    echo continuar, sim ou não?
    read RESPOSTA
done
echo fim!