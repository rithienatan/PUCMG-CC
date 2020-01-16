echo " Backup "
if [ ! -d backup ]; then
	echo "A PASTA DE BACKUP ESTA SENDO CRIADA..."
	mkdir backup
fi

if [ -d $1 ]; then
	echo "REALIZANDO BACKUP"
	cp -R $1 backup/
else
	echo "ERRO: PASTA NAO EXISTENTE"
fi
