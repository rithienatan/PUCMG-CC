# Variaveis associadas aos registradores:
# endBase -> $16

.data
A: .word -2

.text
.globl main
main:
	addi $16, $0,  0x1001   # endBase = 0x00001001
	sll  $16, $16, 0x10		# endBase = 0x10010000

	lw   $8, 0x0($16)		# t0 = mem[ 0 + endBase ]
	sra  $9, $8,   0x19		# t0 >> 31
	beq  $9, $0,   fim		# if (t0 == 0) goto fim
	sub  $8, $0,   $8		# t0 = 0 - t0
	sw   $8, 0x0($16)		# mem[0 + endBase] = t0
fim:
	nop
