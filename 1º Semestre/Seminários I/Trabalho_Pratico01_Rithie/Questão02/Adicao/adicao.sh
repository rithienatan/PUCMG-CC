echo " Calculadora de soma "

RES=0
for VALOR in $*; do
	RES=$((RES+VALOR))
done
echo "$RES"
