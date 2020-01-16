# Variaveis associadas aos registradores:
# endBase -> $16
# x -> $17
# y -> $18

.data
x: .word 3

.text
.globl main
main:
	addi $8,  $0,  0x1001		# t0 = 0x00001001
	sll  $16, $8,  0x10			# endBase = 0x10010000
	
	lw   $17, 0x0($16)  		# t0 = x
	sll  $8,  $17, 0x1F			# t0 = x << 31
	srl  $8,  $8,  0x1F			# t0 = x >> 31
	bne  $8,  $0,   impar		# if (t0 != 0) goto impar
	
par:
	mult $17, $17				# x²
	mflo $8						# t0 = x²
	addi $9,  $0, -2			# t1 = -2
	mult $8,  $9				# x² * -2
	mflo $9						# t1 = -2x²
	
	mult $8,  $17				# x³
	mflo $10					# t2 = x³
	
	mult $8,  $8				# x⁴
	mflo $11					# t3 = x⁴
	
	add  $8,  $11, $10			# t0 = x⁴ + x³
	add  $18, $8,  $9			# y  x⁴ + x⁴ -2x²
	j fim						# goto fim
	
impar:
	mult $17, $17				# x²
	mflo $8						# t0 = x²
	mult $8,  $8				# x⁴
	mflo $9						# t1 = x⁴
	mult $9,  $17				# x⁵
	mflo $9						# t1 = x⁵
	
	mult $8,  $17				# x³
	mflo $10					# t2 = x³
	
	sub  $8,  $9, $10			# t0 = x⁵ - x³
	addi $18, $8, 0x1			# j = x⁵ - x³ + 1
fim:
	sw  $18,  0x4($16)				# mem[4 + endBase] = y