.text
.globl main
main:

addi $8, $zero, 0x1001
sll $8, $8, 16
lw $16, 0($8)
lw $17, 4($8)
nop # sll $zero, $zero, 0
add $18, $17, $16
sw $18, 8($8)

.data

x1: .word 1
x2: .word 3
x3: .word 5
