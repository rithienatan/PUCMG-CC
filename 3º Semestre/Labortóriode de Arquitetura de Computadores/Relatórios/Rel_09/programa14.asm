.data
temp: .word 60
flag: .word -1

.text
.globl main
main:
	addi $8,  $8,  0x1001			# t0 = 0x00001001
	sll  $8,  $8,  0x10				# t0 = 0x10010000
	lw   $9, 0x0($8)				# t1 = temp
	addi $10, $9,  -30				# t2 = temp - 30
	addi $11, $9,  -50				# t3 = temp - 50
	srl  $10, $10, 31				# t2 = t2 >> 31
	srl  $11, $11, 31				# t3 = t3 >> 31
	xor  $12, $10, $11		 		# t4 = t2 xor t3
	beq  $12, $0,  foraDaFaixa		# if (t4 == 0) goto foraDaFaixa
	sw   $12, 0x4($8)				# mem[4 + t0] = 1
	j fim							# goto fim
foraDaFaixa:
	sw   $12, 0x4($8)				# mem[4 + t0] = 0
fim:
	nop
	
