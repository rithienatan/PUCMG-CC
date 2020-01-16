# Variaveis associadas aos registradores:
# endBase -> $16
# x -> $17
# y -> $18

.data
x: .word -1

.text
.globl main
main:
	addi $8,  $0,  0x1001		# t0 = 0x00001001
	sll  $16, $8,  0x10			# endBase = 0x10010000
	
	lw   $17, 0x0($16)			# x = mem[0 + endBase]
	slt  $8,  $0,  $17			# if (0 < x) t0 = 1; else t0 = 0;
	beq  $8,  $0,  xMenorIgual  # if (t1 == 0) goto xMenorIgual
	
xMaior:
	mult $17, $17				# x²
	mflo $8						# t0 = x²
	mult $8,  $17				# x³
	mflo $8						# t0 = x³
	
	addi $18, $8, 0x1			# y = x³ + 1
	j fim						# goto fim
	
xMenorIgual:
	mult $17, $17				# x²
	mflo $8						# t0 = x²
	mult $8,  $8				# x⁴
	mflo $8						# t0 = x³

	addi $18, $8,  -1			# y = x³ - 1	
fim: 
	sw   $18, 0x4($16)			# mem[4 + endBase] = y