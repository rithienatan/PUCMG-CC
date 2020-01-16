# Variaveis associadas aos registradores:
# endBase -> $16
# i -> $17
# soma -> $18

.text
.globl main
main:
	addi $8,  $0, 0x1001	# t0 = 0x00001001
	sll  $16, $8, 0x10		# endBase = 0x10010000
	addi $10, $0, 0x64		# i = 100
	
do:
	sll  $8,  $17, 0x2		# i = i * 4
	add  $8,  $8, $16		# t0 = i * 4 + endBase
	sll  $9,  $17, 0x1		# t1 = i * 2
	addi $9,  $9,  0x1		# t1 = i * 2 + 1
	sw   $9,  0($8)			# vet[i] = t1
	add  $18, $18, $9		# soma = soma + t1
	addi $17, $17, 0x1		# i = i + 1
	bne  $17, $10, do		# if (i != 0) goto do
	
	sw  $18, 400($16)		# vet[100] = soma
