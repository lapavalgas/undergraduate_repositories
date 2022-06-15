
# verifica condições
echo entre com um valor numerico entre 0 e 10
read NUMBER
# a leitura da linha é: se o num é menor que 0 ou maior que 10 (&&) então executa o comando (SE NÃO) executa o próximo comando
test $NUMBER -lt 0 -o $NUMBER -gt 10 && echo digitação incorreta || echo Digitação correta!

# test  | para verificar
# -lt   | menor que 
# -o    | maior que 
# &&    | então
# ||    | se não