.text
.globl main
main:
addi $8, $0, 1 # t0 = 1
sll $8, $8, 16 # t0 = 0001 0000
ori $16, $8, 0x86A0 # x = 100000
addi $9, $0, 2 # t1 = 2
sll $9, $9, 16 # t0 = 0002 0000
ori $17, $9, 0x0D40 # x = 200000
add $18, $16, $17 # z = x + y
