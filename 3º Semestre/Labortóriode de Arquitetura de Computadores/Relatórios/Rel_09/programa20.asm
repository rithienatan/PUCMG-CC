# Variaveis associadas aos registradores:
# endBase -> $16
# i -> $17
# soma -> $18

.text
.globl main
main:
	addi $8,  $0,  0x1001		# t0 = 0x00001001
	sll  $16, $8,  0x10			# t0 = 0x10010000
	addi $8,  $0,  0x63			# t0 = 99
	addi $17, $0,  0x32			# i = 50
	
vet:
	sll  $9,  $17, 0x2			# t1 = i * 4
	add  $9,  $9,  $16			# t1 = i * 4 + endBase
	sw   $8,  -4($9)			# vet[i] = t0
	addi $8,  $8,  -2			# t0 = t0 - 2
	addi $17, $17, -1			# i = i - 1
	bne  $17, $0,  vet			# if (t0 != -1) goto vet
	
	addi $17, $0,  0x32			# i = 50
soma:
	sll  $9,  $17, 0x2			# t1 = i * 4
	add  $9,  $9,  $16			# t1 = i * 4 + endBase
	lw   $11, -4($9)			# t3 = vet[i]
	add  $18, $18, $11			# soma = soma + vet[i]
	addi $17, $17,  -1			# i = i - 1
	bne  $17, $0, soma			# if (t0 != -1) goto soma
	
	sw   $18, 200($16)			# vet[50] = soma
	