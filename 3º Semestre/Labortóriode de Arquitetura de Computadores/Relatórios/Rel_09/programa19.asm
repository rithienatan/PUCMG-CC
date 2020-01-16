# Variaveis associadas aos registradores:
# x -> $16
# y -> $17
# z -> $18
# result -> $19

.text
.globl main
main:
	addi $8,  $0,  0x186A			# t0 = 0x0000186A
	sll  $16, $8,  0x8				# x  = 0x00186A00  
	
	addi $8,  $0,  0x1388			# t0 = 0x00001388
	sll  $17, $8,  0x4				# y  = 0x00013880
	
	addi $8,  $0,  0x61A8			# t0 = 0x000061A8
	sll  $18, $8,  0x4				# z  = 0x00061A80
	
	div  $16,  $18					# x/z
	mflo $8							# t0 = x/z
	mult $8,   $17					# x/z * y
	mflo $19						# result = xy/z
	
	#add  $8,  $0,  $17				# t0 = y
	
#doMult:
	#add  $9,  $9,  $16				# t1 = t1 + x
	#addi $8,  $8,  -1				# t0 = t0 - 1
	#bne  $8,  $0,  doMult			# if (t0 != 0) goto doMult
	
	#addi $19, $0,  -1				# result = -1
#doDiv:
	#sub  $9,  $9,  $18				# t1 = t1 - z
	#addi $19, $19, 0x1				# t2 = t2 + 1
	#slt  $10, $9,  $0				# if ( t1 < 0 ) t2 = 1; else t2 = 0;
	#beq  $10, $0,  doDiv			# if (t2 == 0) goto doDiv	