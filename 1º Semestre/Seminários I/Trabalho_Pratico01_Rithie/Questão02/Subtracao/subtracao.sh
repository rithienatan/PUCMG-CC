echo " Calculadora de Subtracao "

RES=$1
shift
for VALOR in $*; do
	RES=$((RES-VALOR))
done
echo "$RES"
