echo " Calculadora "

if [ $1 = + ]; then
	shift
	RES=0
	for VALOR in $*; do
		RES=$((RES+VALOR))
	done
	echo "$RES"
fi

if [ $1 = - ]; then
shift
	RES=$1
shift
	for VALOR in $*; do
		RES=$((RES-VALOR))
	done
	echo "$RES"
fi

if [ $1 = / ]; then
shift
	RES=$1
shift
	for VALOR in $*; do
		RES=$((RES/VALOR))
	done
	echo "$RES"
fi

if [ $1 = x ]; then
shift
	RES=$1
shift
	for VALOR in $*; do
		RES=$((RES*VALOR))
	done
	echo "$RES"
fi
