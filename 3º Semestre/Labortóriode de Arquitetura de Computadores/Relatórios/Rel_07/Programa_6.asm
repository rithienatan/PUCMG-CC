.text
.globl main
main:
addi $8, $0, 0x7fff # t0 = 7fff
sll $8, $8, 16 # t0 = 7fff 0000
ori $16, $8, 0xffff # x = 7fffffff
addi $9, $0, 4 # t1 = 4
sll $9, $9, 16 # t1 = 0004 0000
ori $17, $9, 0x93E0 # y = 300000
sll $10, $17, 2 # t2 = 4y
sub $18, $16, $10 # z = x - 4y