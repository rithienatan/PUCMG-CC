# Variaveis associadas aos registradores:
# endBase -> $16
# k -> $17
# x -> $18
# y -> $19

.data
x: .word -2
y: .word 30

.text
.globl main
main:
	addi $8,  $0,  0x1001			# t0 = 0x00001001
	sll  $16, $8,  0x10				# t0 = 0x10010000
	lw   $18, 0x0($16)				# x = mem[0 + endBase]
	lw   $19, 0x4($16)				# y = mem[4 + endBase]	
	add  $8,  $0,  $19				# t0 = y
do:
	add  $9,  $9,  $18				# t1 = t1 + x
	addi $8,  $8,  -1				# t0 = t0 - 1
	bne  $8,  $0,  do				# if (t0 != 0) goto do
	
	add  $17, $0,  $9				# k = x * y
	sw   $17,  0x8($16)				# mem[8 + endBase] = k