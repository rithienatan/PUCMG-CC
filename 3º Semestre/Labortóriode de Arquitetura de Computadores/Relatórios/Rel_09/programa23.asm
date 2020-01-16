# Variaveis associadas aos registradores:
# endBase -> $16
# k -> $17
# x -> $18
# y -> $19

.data
x: .word 3
y: .word 4

.text
.globl main
main:
	addi $8,  $0,  0x1001			# t0 = 0x00001001
	sll  $16, $8,  0x10				# t0 = 0x10010000
	lw   $18, 0x0($16)				# x = mem[0 + endBase]
	lw   $19, 0x4($16)				# y = mem[4 + endBase]	
	add  $17, $0,  $10				# k = x^y
	add  $8,  $0,  $18				# t0 = x
	add  $10, $0,  $19				# t2 = y
	add  $10, $10, -1				# t2 = y - 1
	
doExterno:
	add  $9,  $0,  $18				# t1 = x
	add  $11, $0,  $0				# t3 = 0
	doInterno:
		add  $11, $11, $8			# t3 = t3 + t0
		addi $9,  $9,  -1			# t1 = t1 - 1
		bne  $9,  $0,  doInterno	# if (t1 != 0) goto doInterno
	
	add  $8,  $0,  $11				# t0 = t3
	addi $10, $10, -1				# t2 = t2 - 1
	bne  $10, $0,  doExterno		# if (t2 != 0) goto doExterno

	add  $17, $0,  $11				# k = x^y 
	sw   $17, 0x8($16)				# mem[8 + endBase] = k
	
	
