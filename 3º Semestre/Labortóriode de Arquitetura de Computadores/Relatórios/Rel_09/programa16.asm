# Programa:
# i = 0;
# j = 0;
# do {
# 	do {
#		aux = vet[j];;
#		vet[j] = vet[j+1];
#		vet[j+1] = aux;
#		j++;
#	} while ( j < 100 );
#		j = 0;
#		i++;
# } while ( i < 100 );

# Variaveis associadas aos registradores
# endBase -> $16
# i -> $17
# j -> $18

.data
a: .word 5 : 20
b: .word 4 : 20
c: .word 3 : 20
d: .word 2 : 20
e: .word 1 : 20


.text
.globl main
main:
	addi $8,  $0,  0x1001			# t0 = 0x00001001
	sll  $16, $8,  0x10				# endBase = 0x10010000
	addi $9,  $0,  0x63				# t1 = 99
	
doExterno: 
	addi $18, $0, 0x0				# j = 0
	doInterno:
		sll  $8,  $18, 0x2			# t0 = j * 4
		add  $8,  $8,  $16			# t0 = j * 4 + endBase
		lw   $10, 0x0($8)			# aux = vet[j]
		lw   $11, 0x4($8)			# t3 = vet[j+1]
		
		if:
			slt  $12, $11, $10		# if (vet[j+1] < vet[j]) t4 = 1; else t4 = 0
			beq  $12, $0,  fimIf	# if (t4 == 0) goto fimIf
			sw   $11, 0x0($8)		# vet[j] = vet[j+1]
			sw   $10, 0x4($8)		# vet[j+1] = aux
		fimIf:
		
		addi $18, $18, 0x1			# j = j + 1	
		bne  $18, $9,  doInterno 	# if (j != 99) goto doInterno
		
	addi $17, $17, 0x1				# i = i + 1
	bne	 $17, $9,  doExterno		# if (i != 99) goto doExterno
