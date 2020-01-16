.text
.globl main
main:
addi $16, $0, 0x00000003 # x = 3
addi $17, $0, 0x00000004 # y = 4
sll $8, $16, 4 # t0 = 16x
sub $8, $8, $16 # t0 = 15x
sll $9, $17, 6 # t1 = 64y
add $9, $9, $17 # t1 = 65y
add $9, $9, $17 # t1 = 66y
add $9, $9, $17 # t1 = 67y
add $10, $8, $9 # t2 = t1 + t0
sll $18, $10, 2 # t2 = 4*t2